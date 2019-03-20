package cn.smileyan.boot.main.controler;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.smileyan.boot.main.entity.User;
import cn.smileyan.boot.main.service.UserService;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

@Controller
@Slf4j
@RequestMapping("/login")
@CrossOrigin
public class LoginControler {
	@Autowired
	private UserService userService;
	
	@Value("${wechat.appid}")
	private String appid;
	@Value("${wechat.appsecret}")
	private String appsecret;
	
	@Value("${wechat.login_url}")
	private String login_url;				// 授权网址
   
	@Value("${wechat.success_login_url}")
	private String success_login_url;		// 登录成功后返回的网页
	
	private WxMpService wxMpService;
	/**
	 * 提示用户点击同意，授权登录
	 * @return
	 */
	@GetMapping("/welcome")
	public String  welcome() {
		// 1.根据appid和appsecret和回调地址配置微信授权
        WxMpInMemoryConfigStorage wxMpConfigStorage = new WxMpInMemoryConfigStorage();
        wxMpConfigStorage.setAppId(appid);
        wxMpConfigStorage.setSecret(appsecret);
        wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxMpConfigStorage);
        // 完成配置后进行跳转
		String oauth2buildAuthorizationUrl = wxMpService.oauth2buildAuthorizationUrl(login_url, WxConsts.OAuth2Scope.SNSAPI_USERINFO,  null);
		System.out.println(oauth2buildAuthorizationUrl);
		return "redirect:" + oauth2buildAuthorizationUrl;
	}
	/**
	 * 通过code拿到数据openid
	 * @param code
	 * @param returnUrl
	 * @return 进行网站跳转
	 */
	@GetMapping("/login")
	public String login(@RequestParam("code") String code,
            @RequestParam("state") String returnUrl,HttpServletRequest request,HttpServletResponse response) {
		System.out.println("code=="+code);
		// 2.根据code换取AccessToken
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = null;
        try {
            wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
        } catch (WxErrorException e) {
        	e.printStackTrace();
        }
        
        // 3.进一步获取用户信息
        String openId = wxMpOAuth2AccessToken.getOpenId();
        System.out.println("openid="+openId);
        // 拿到用户的基本信息
        WxMpUser wxMpUser=null; 
        try {
        	wxMpUser = wxMpService.oauth2getUserInfo(wxMpOAuth2AccessToken, null);
		} catch (WxErrorException e) {
			e.printStackTrace();
		}
       
        // 判断这个用户是否已经注册
        User user=newFromWechat(wxMpUser);
        User loginedUser = userService.registerOrLogin(user);
//        System.out.println(loginedUser.getUser_id());
        String url_add = "user_id="+loginedUser.getUser_id()+"&portrait_url="+loginedUser.getPortrait_url();

        return "redirect:" + success_login_url+"?"+url_add;
	}
	
	@Value("${wechat.user.money_default}")
	private float money;
	@Value("${wechat.user.password_default}")
	private String password;
	
	/**
	 * 将微信端拿到的数据存储到服务器
	 * @param wxMpUser
	 * @return 此用户
	 */
	public User newFromWechat(WxMpUser wxMpUser) {
		User user=new User();
		user.setOpenid(wxMpUser.getOpenId());
		user.setUser_name(wxMpUser.getNickname().toString());
		user.setPortrait_url(wxMpUser.getHeadImgUrl());
		user.setPassword(password);
		user.setMoney(money);
		user.setUser_id(0);
		return user;
	}
	
	
	

	@RequestMapping("/addCookie")
	@ResponseBody
	public String addCookie(@RequestParam("username")String username,
			HttpServletRequest request,HttpServletResponse response) {
		Cookie cookie = new Cookie("username", username);
		cookie.setPath("/");
		cookie.setMaxAge(80000);
		response.addCookie(cookie);
		return "添加成功";
	}
}
