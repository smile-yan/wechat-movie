package cn.smileyan.boot.main.service;

import org.json.JSONObject;

import cn.smileyan.boot.main.entity.Room;

/**
 * 用于提供Room相关的服务
 * @author Smileyan
 */
public interface RoomService {
	/**
	 * @description 根据Id号查询
	 * @param id 
	 * @return
	 */
	Room findById(Integer id);
	
	/**
	 * @description 根据cenima_id查询名称
	 * @param cenima_id
	 * @return
	 */
	String findCinema_nameById(Integer cinema_id);
	
	/**
	 * @description 根据screen_id查询视图
	 * @param screen_id
	 * @return
	 */
	JSONObject findRoomView(Integer screen_id);
}
