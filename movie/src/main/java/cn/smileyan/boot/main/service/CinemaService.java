package cn.smileyan.boot.main.service;


import java.util.List;

import org.json.JSONObject;

import cn.smileyan.boot.main.entity.Cinema;

public interface CinemaService {
	/**
	 * 返回所有的影院
	 * @return
	 */
	List<Cinema> findAll();
	
	/**
	 * 返回特定的影院
	 * @return 
	 */
	Cinema findById(Integer id);
	
	/**
	 * @description 根据电影名查看screen和影院信息
	 * @param movie_id
	 * @return
	 */
	List<JSONObject> findScreenByMovie_id(Integer movie_id);
}
