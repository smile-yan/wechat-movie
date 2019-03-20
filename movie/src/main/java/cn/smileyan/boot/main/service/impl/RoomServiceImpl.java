package cn.smileyan.boot.main.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.smileyan.boot.main.entity.Room;
import cn.smileyan.boot.main.repository.CinemaRepository;
import cn.smileyan.boot.main.repository.RoomRepository;
import cn.smileyan.boot.main.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService{
	@Autowired
	private RoomRepository roomRepository;
	@Autowired
	private CinemaRepository cinemaRepository;
	
	@Transactional
	@Override
	public Room findById(Integer id) {
		return roomRepository.findById(id).get();
	}

	@Override
	public String findCinema_nameById(Integer cinema_id) {
		return cinemaRepository.getCinemaNameById(cinema_id);
	}

	@Override
	public JSONObject findRoomView(Integer screen_id) {
		List<Object[]> all= roomRepository.roomView(screen_id);
//		需要获取：cinema_name  movie_name   time  room_name room_row   room_column  已经选好的座位     price
		String[] params= {"cinema_name","movie_name","room_name","time","room_row","room_column","price"};
		int i;
		JSONObject json = new JSONObject();
		for (Object[] objects : all) {
			for(i=0; i<objects.length; i++) {
//				System.out.println(objects[i]);
				json.put(params[i], objects[i]);
			}
		}
		
		return json;
	}
}
