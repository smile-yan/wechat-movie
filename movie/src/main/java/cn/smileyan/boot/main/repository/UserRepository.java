package cn.smileyan.boot.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cn.smileyan.boot.main.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	/**
	 * 根据用户的openid查询
	 * @param openid
	 * @return
	 */
	List<User> findByOpenid(String openid);
	
	@Query(nativeQuery=true, value="select order_id,movie_name,cinema_name,room_name,seat_x,seat_y,time,order_time,price from UserInfo where user_id=:id")	
	List<Object[]> findUserForms(@Param("id")Integer user_id);
}
