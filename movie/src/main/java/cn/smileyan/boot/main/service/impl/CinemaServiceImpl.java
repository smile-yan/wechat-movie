package cn.smileyan.boot.main.service.impl;

import java.util.LinkedList;
import java.util.List;
import javax.transaction.Transactional;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.smileyan.boot.main.entity.Cinema;
import cn.smileyan.boot.main.repository.CinemaRepository;
import cn.smileyan.boot.main.service.CinemaService;

@Service
public class CinemaServiceImpl implements CinemaService{
	@Autowired
	private CinemaRepository cinemaRepository;
	
	@Transactional
	@Override
	public List<Cinema> findAll() {
		return cinemaRepository.findAll();
	}

	@Transactional
	@Override
	public Cinema findById(Integer id) {
		return cinemaRepository.findById(id).get();
	}

	@Override
	public List<JSONObject> findScreenByMovie_id(Integer movie_id) {
		List<Object[]>all =  cinemaRepository.getScreenInfoByMovie_id(movie_id);
		List<JSONObject>allInfor=new LinkedList<>();
		
		// screen_id,cinema_name,room_name,location,time,price 
		String[] key = {"screen_id","cinema_name","room_name","location","time","price"};
		// 遍历所有
		for (Object[] objects : all) {	
			JSONObject json = new JSONObject();
			int i;
			for(i=0; i<objects.length; i++) {
				json.put(key[i], objects[i]);
			}
			allInfor.add(json);
		}
		System.out.println(allInfor);
		return allInfor;
	}

}
