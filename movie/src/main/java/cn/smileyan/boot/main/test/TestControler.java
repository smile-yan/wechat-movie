package cn.smileyan.boot.main.test;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.smileyan.boot.main.entity.User;
import cn.smileyan.boot.main.repository.UserRepository;

@RestController
@CrossOrigin
public class TestControler {

	@Autowired
	private UserRepository userRepository;
	
	
	@RequestMapping("/test")
	public List <User> test() {
		
		return  userRepository.findAll();
	}
}
