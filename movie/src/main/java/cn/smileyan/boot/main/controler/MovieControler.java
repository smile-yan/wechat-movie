package cn.smileyan.boot.main.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import cn.smileyan.boot.main.entity.Movie;
import cn.smileyan.boot.main.service.MovieService;

/**
 * 用于电影的所有操作
 * @author smileyan
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/movie")
public class MovieControler {
	@Autowired
	private MovieService movieService;
	
	@RequestMapping("/all")
	public List<Movie> showAllMovies(){
		return movieService.findAllMovies();
	}
	
	@RequestMapping("/one")
	public Movie showOneMovie(@RequestParam("movie_id")Integer id) {
		System.out.println("movie_id=="+id);
		return movieService.showOneMovie(id);
	}
	/**
	 * 用于后台添加电影
	 * @param movie_name
	 * @param release
	 * @param post_url
	 * @param instroduction
	 * @return 添加的电影
	 */
	@PostMapping("/add")
	public Movie addMovie(@RequestParam("movie_name")String movie_name,
						@RequestParam("release")String release,
						@RequestParam("post_url")String post_url,
						@RequestParam("instroduction")String introduction) {
		Movie movie=new Movie();
		movie.setIntroduction(introduction);
		movie.setMovie_id(0);
		movie.setMovie_name(movie_name);
		movie.setPost_url(post_url);
		movie.setRelease(release);
		return movieService.addMovie(movie);
	}
}
