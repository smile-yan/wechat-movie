package cn.smileyan.boot.main.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.smileyan.boot.main.entity.Screen;
import cn.smileyan.boot.main.repository.ScreenRepository;
import cn.smileyan.boot.main.service.ScreenService;

@Service
public class ScreenServiceImpl implements ScreenService{
	@Autowired
	private ScreenRepository screenRepository;
	
	@Override
	public Screen showOneById(Integer id) {
		return screenRepository.findById(id).get();
	}

	@Override
	public float showPrice(Integer screen_id) {
		return screenRepository.findPriceById(screen_id);
	}

	@Override
	public Integer findRoom_idByScreen_id(Integer screen_id) {
		return screenRepository.findRoom_idByCenima_id(screen_id);
	}
	
}
