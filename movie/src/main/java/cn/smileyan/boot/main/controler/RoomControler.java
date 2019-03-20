package cn.smileyan.boot.main.controler;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.smileyan.boot.main.entity.Room;
import cn.smileyan.boot.main.service.RoomService;

@RestController
@RequestMapping("/room")
@CrossOrigin
public class RoomControler {
	@Autowired
	private RoomService roomService;
	
	@RequestMapping("/one")
	public Room findById(@RequestParam("room_id")Integer id) {
		return roomService.findById(id);
	}
	
	@RequestMapping("/cinema_name")
	public String findCinema_name(@RequestParam("cinema_id")Integer cinema_id) {
		return roomService.findCinema_nameById(cinema_id);
	}
		
	/**
	 * @desc 通过screen_id，需要获取：cinema_name  movie_name   time  room_name room_row   room_column  已经选好的座位     price
	 * 
	 */
	@RequestMapping("/info")
	public String roomShow(@RequestParam("screen_id")Integer screen_id) {
		JSONObject json=roomService.findRoomView(screen_id);
//		System.out.println(json);
		return json+"";
	}
	
	
	
}
