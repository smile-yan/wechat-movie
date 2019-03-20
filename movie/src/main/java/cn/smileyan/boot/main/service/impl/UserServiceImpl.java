package cn.smileyan.boot.main.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.smileyan.boot.main.entity.Form;
import cn.smileyan.boot.main.entity.User;
import cn.smileyan.boot.main.repository.FormRepository;
import cn.smileyan.boot.main.repository.UserRepository;
import cn.smileyan.boot.main.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private FormRepository formRepository;
	
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findUserById(Integer id) {
		return userRepository.findById(id).get();
	}

	@Override
	public User registerOrLogin(User user) {
		// 1. 查询数据库中此用户的openid是否存在
		List<User> fuser=userRepository.findByOpenid(user.getOpenid());
		
		if(fuser.size()==0) {
			// 2.如果不存在则写入数据库
			return userRepository.save(user);
		}
		// 3.返回这个用户 注意是查询后的
		return fuser.get(0);
	}

	@Override
	public List<Form> findFormsByUser_id(Integer user_id) {
		return formRepository.findByUser_id(user_id);
	}

	@Override
	public List<JSONObject> findUserInfor(Integer user_id) {
		List<Object[]>all = userRepository.findUserForms(user_id);
		List<JSONObject>allInfor=new LinkedList<>();
		
		//order_id,movie_name,cinema_name,room_name,seat_x,seat_y,time,order_time,price
		String[] key = {"order_id","movie_name","cinema_name","room_name","seat_x","seat_y","time","order_time","price"};
		// 遍历所有
		for (Object[] objects : all) {	
			JSONObject json = new JSONObject();
			int i;
			for(i=0; i<objects.length; i++) {
				json.put(key[i], objects[i]);
			}
			allInfor.add(json);
		}
//		System.out.println(allInfor);
		return allInfor;
		
	}
}
