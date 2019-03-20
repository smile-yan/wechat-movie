package cn.smileyan.boot.main.controler;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.smileyan.boot.main.entity.Cinema;
import cn.smileyan.boot.main.service.CinemaService;

@RestController
@RequestMapping("/cinema")
@CrossOrigin
public class CinemaControler {
	@Autowired
	private CinemaService cinemaService;
	
	@RequestMapping("/all")
	public List<Cinema> showAll(){
		return cinemaService.findAll();
	}
	
	@RequestMapping("/one")
	public Cinema showOne(@RequestParam("cinema_id")Integer id) {
		return cinemaService.findById(id);
	}
	
	@RequestMapping("/cinema")
	public String allCinemaInfo(@Param("movie_id")Integer movie_id) {
		List<JSONObject> list = cinemaService.findScreenByMovie_id(movie_id);
		StringBuffer stringBuffer=new StringBuffer();
		stringBuffer.append("[");
		int i;
		for (i=0; i<list.size()-1; i++) {
			stringBuffer.append(list.get(i)+",");
		}
		stringBuffer.append(list.get(i));
		stringBuffer.append("]");
		return stringBuffer.toString();
	}
}
