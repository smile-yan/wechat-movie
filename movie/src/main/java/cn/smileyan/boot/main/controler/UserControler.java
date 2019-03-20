package cn.smileyan.boot.main.controler;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import cn.smileyan.boot.main.entity.User;
import cn.smileyan.boot.main.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserControler {
	@Autowired
	private UserService userService;

	@RequestMapping("/all")
	public List <User> test() {
		return  userService.findAll();
	} 
	
	@GetMapping("/one")
	public User logined(@RequestParam("user_id")Integer userid) {
		return userService.findUserById(userid);
	}
	
	/**
	 * @Title 根据用户id查询所有表单
	 * post方式
	 * @param user_id
	 * @return json 包括 订单号， 电影名   ，放映影院，座位号，订单时间，金额 
	 */
	@GetMapping("/form")
	public String allForm(@RequestParam("user_id") Integer user_id){
		List<JSONObject>all= userService.findUserInfor(user_id);
		StringBuffer stringBuffer=new StringBuffer();
		stringBuffer.append("[");
		int i;
		for (i=0; i<all.size()-1; i++) {
			stringBuffer.append(all.get(i)+",");
		}
		stringBuffer.append(all.get(i));
		stringBuffer.append("]");
		return stringBuffer.toString();
	}
	
	/**
	 * @description 根据session查询用户是否登录
	 * @return
	 */
	@GetMapping("/state")
	public String getUserid(HttpSession session) {
//		 System.out.println("session--->"+((User)session.getAttribute("logined_user")).getUser_name());
		User user = (User)session.getAttribute("logined_user");
		return user.getUser_id()+"";
	}
	
}
