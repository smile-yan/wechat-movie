package cn.smileyan.boot.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cn.smileyan.boot.main.entity.Form;

public interface FormRepository extends JpaRepository<Form, Integer>{
	/**
	 * 根据screen查询当场的所有表单
	 * @param sceen_id
	 * @return
	 */
	@Query("select o from Form o where o.screen_id=?1 ")
	List<Form> findByScreen_id(Integer sceen_id);
 
	/**
	 * 判断此场电影这个位置是否已经购买
	 * @param screen_id
	 * @param seat_x
	 * @param seat_y
	 * @return 购买则返回这个list否则返回空
	 */
	@Query("select o from Form o where o.screen_id=?1 and o.seat_x=?2 and o.seat_y=?3 ")
	List<Form> findByScreen_idAndXY(Integer screen_id,Integer seat_x,Integer seat_y);
	
	/**
	 * 根据用户id进行查询
	 * @param user_id
	 * @return
	 */
	@Query("select o from Form o where o.user_id=?1")
	List<Form> findByUser_id(Integer user_id);
	
	/**
	 * 根据screen_id查询所有数据
	 * @param screen_id
	 * @return
	 */
	@Query("select o from Form o where o.screen_id=?1")
	List<Form> findAllByScreen_id(Integer screen_id);
	/**
	 * 根据id查询随机code
	 * @param screen_id
	 * @return
	 */
	@Query("select o.code from Form o where o.order_id=?1")
	String findCodeByOrder_id(Integer order_id);
}
