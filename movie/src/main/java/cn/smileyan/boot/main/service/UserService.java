package cn.smileyan.boot.main.service;

import java.util.List;

import org.json.JSONObject;

import cn.smileyan.boot.main.entity.Form;
import cn.smileyan.boot.main.entity.User;

public interface UserService {
	/**
	 * 查看所有的用户信息
	 * @return 所有的用户
	 */
	List<User> findAll();
	
	/**
	 * 根据Id查询用户
	 * @param id
	 * @return 返回该用户或者返回空
	 */
	User findUserById(Integer id);

	/**
	 * 微信授权后，会返回openid
	 * 如果数据库中存在此用户，则只是简单的登录，
	 * 如果数据库中不存在，则注册此用户
	 * @return 此用户
	 */
	User registerOrLogin(User user);

	/**
	 * 
	 * @param user_id
	 * @return
	 */
	List<Form> findFormsByUser_id(Integer user_id);
	
	/**
	 * @description 根据用户的id查询用户的表单信息
	 * @param user_id
	 * @return
	 */
	List<JSONObject> findUserInfor(Integer user_id);
}
