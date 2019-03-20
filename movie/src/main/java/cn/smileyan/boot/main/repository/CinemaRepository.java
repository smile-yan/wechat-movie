package cn.smileyan.boot.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cn.smileyan.boot.main.entity.Cinema;

public interface CinemaRepository extends JpaRepository<Cinema, Integer> {
	@Query("select o.cinema_name from Cinema o where o.cinema_id=?1")
	String getCinemaNameById(Integer cinema_id);
	
	@Query(nativeQuery=true,
		value="select screen_id,cinema_name,room_name,location,time,price from cinema_screen where movie_id=:id")
	List<Object[]> getScreenInfoByMovie_id(@Param("id")Integer movie_id);
}
