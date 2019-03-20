package cn.smileyan.boot.main.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.smileyan.boot.main.service.ScreenService;

@RestController
@CrossOrigin
@RequestMapping("/screen")
public class ScreenControler {
	@Autowired
	private ScreenService screenService;

	@RequestMapping("/price")
	public float showPrice(@RequestParam("screen_id")Integer screen_id) {
		return screenService.showPrice(screen_id);
	}
	
	@RequestMapping("/room_id")
	public Integer getRoom_idByScreen_id(Integer screen_id) {
		return screenService.findRoom_idByScreen_id(screen_id);
	}
	
}
