package cn.smileyan.boot.main.service;

import cn.smileyan.boot.main.entity.Screen;

public interface ScreenService {
	/**
	 * 根据id查询Screen
	 * @param id
	 * @return screen
	 */
	Screen showOneById(Integer id);
	/**
	 * 根据id查价格
	 * @param screen_id
	 * @return 价格
	 */
	float showPrice(Integer screen_id);
	
	/**
	 * 根据screen_id查询room_id
	 * @param screen_id
	 * @return
	 */
	Integer findRoom_idByScreen_id(Integer screen_id);
	
}
