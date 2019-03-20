package cn.smileyan.boot.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cn.smileyan.boot.main.entity.Screen;

public interface ScreenRepository extends JpaRepository<Screen, Integer>{
	@Query("select o from Screen o where o.screen_id=?1")
	Screen findByScreen_id(Integer screen_id);
	
	@Query("select o.price from Screen o where o.screen_id=?1")
	float findPriceById(Integer screen_id);
	
	// 根据screen_id查询room_id
	@Query("select o.room_id from Screen o where o.screen_id=?1")
	Integer findRoom_idByCenima_id(Integer screen_id);
	
	@Query(nativeQuery=true,
			value="select cinema_name,location from cinema_screen where movie_id=:id")
	List<Object[]> findCinemaByMovie_name(@Param("id")Integer movie_id);
}
