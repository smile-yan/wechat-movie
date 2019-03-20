package cn.smileyan.boot.main.service.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.smileyan.boot.main.entity.Form;
import cn.smileyan.boot.main.entity.Screen;
import cn.smileyan.boot.main.entity.User;
import cn.smileyan.boot.main.repository.FormRepository;
import cn.smileyan.boot.main.repository.ScreenRepository;
import cn.smileyan.boot.main.repository.UserRepository;
import cn.smileyan.boot.main.service.FormService;

@Service
public class FormServiceImpl implements FormService{
	@Autowired
	private FormRepository formRepository;
	@Autowired
	private ScreenRepository screenRepository;
	@Autowired
	private UserRepository userRepository;
	@Override
	public List<Form> findAll() {
		return formRepository.findAll();
	}

	@Transactional
	@Override
	public Form addForm(Form form) {
		// 拿到表单的信息
		Integer screen_id = form.getScreen_id();
		Integer seat_x = form.getSeat_x();
		Integer seat_y = form.getSeat_y();
		
		// 判断这个座位是否已经买好
		if(formRepository.findByScreen_idAndXY(screen_id, seat_x, seat_y).size()!=0) {
			System.out.println();
			System.out.println("此座位已经买好！");
			Form form2=new Form();
			form2.setOrder_id((int)EXISTED);
			return form2;
		}
		
		// 添加成功后扣除钱
		Screen screen = screenRepository.findByScreen_id(screen_id);
		float price = screen.getPrice();
		System.out.println("价格为："+price);
		
		User user=userRepository.findById(form.getUser_id()).get();
		float money=user.getMoney();
		if(money<price) {
			System.out.println("余额不足！");
			Form form2=new Form();
			form2.setOrder_id((int)NOMONEY);
			return form2;
		}
		// 购买成功
		money -= price;
		user.setMoney(money);
		userRepository.save(user);
		
		return formRepository.save(form);
	}

	@Override
	public List<Form> findOrderedForm(Integer screen_id) {
		return formRepository.findByScreen_id(screen_id);
	}

	@Override
	public List<Form> findByUser_id(Integer user_id) {
		return formRepository.findByUser_id(user_id);
	}

	@Override
	public List<Form> findByScreen_id(Integer screen_id) {
		return formRepository.findAllByScreen_id(screen_id);
	}

	@Override
	public String findCodeByOrder_id(Integer order_id) {
		return formRepository.findCodeByOrder_id(order_id);
	}


}
