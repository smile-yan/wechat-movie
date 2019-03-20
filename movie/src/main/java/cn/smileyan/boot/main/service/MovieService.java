package cn.smileyan.boot.main.service;

import java.util.List;

import cn.smileyan.boot.main.entity.Movie;

/**
 * 
 * @author Smileyan
 *
 */
public interface MovieService {
	/**
	 * 查看所有的电影
	 * @return 所有电影
	 */
	List<Movie> findAllMovies();

	/**
	 * 根据电影的Id查询返回电影详情
	 * @param id
	 * @return
	 */
	Movie showOneMovie(Integer id);
	
	/**
	 * 添加电影
	 * @param movie
	 * @return 添加的电影或者null
	 */
	Movie addMovie(Movie movie);
}
