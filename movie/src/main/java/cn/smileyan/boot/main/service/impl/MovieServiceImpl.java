package cn.smileyan.boot.main.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.smileyan.boot.main.entity.Movie;
import cn.smileyan.boot.main.repository.MovieRepository;
import cn.smileyan.boot.main.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService{

	@Autowired
	private MovieRepository movieRepository;

	@Override
	@Transactional
	public List<Movie> findAllMovies() {
		return movieRepository.findAll();
	}

	@Override
	public Movie showOneMovie(Integer id) {
		return movieRepository.findById(id).get();
	}

	@Override
	public Movie addMovie(Movie movie) {
		return movieRepository.save(movie);
	}
	
}
