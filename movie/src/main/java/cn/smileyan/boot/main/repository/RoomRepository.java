package cn.smileyan.boot.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cn.smileyan.boot.main.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Integer>{
	
	// cinema_name  movie_name  room_name   time row   column  已经选好的座位     price
	@Query(nativeQuery=true,
			value="select cinema_name,movie_name,room_name,time,room_row,room_column,price from room_view where screen_id=:id")
	List<Object[]> roomView(@Param("id")Integer screen_id);
}
