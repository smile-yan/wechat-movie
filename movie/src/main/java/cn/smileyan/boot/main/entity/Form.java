package cn.smileyan.boot.main.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * 表单信息
 * @author Administrator
 *
 */
@Entity
public class Form {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer order_id;
	
	private Integer user_id;
	
	private Integer screen_id;
	
	private String order_time;

	private Integer seat_x;
	
	private Integer seat_y;

	private String code;
	
	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getScreen_id() {
		return screen_id;
	}

	public void setScreen_id(Integer screen_id) {
		this.screen_id = screen_id;
	}

	public String getOrder_time() {
		return order_time;
	}

	public void setOrder_time(String order_time) {
		this.order_time = order_time;
	}

	public Integer getSeat_x() {
		return seat_x;
	}

	public void setSeat_x(Integer seat_x) {
		this.seat_x = seat_x;
	}

	public Integer getSeat_y() {
		return seat_y;
	}

	public void setSeat_y(Integer seat_y) {
		this.seat_y = seat_y;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
