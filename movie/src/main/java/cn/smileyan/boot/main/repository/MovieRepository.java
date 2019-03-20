package cn.smileyan.boot.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.smileyan.boot.main.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer>{

}
