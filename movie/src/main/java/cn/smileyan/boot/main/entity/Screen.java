package cn.smileyan.boot.main.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 场次信息
 * @author Administrator
 *
 */
@Entity
public class Screen {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer screen_id;
	
	private Integer cenima_id;
	private Integer movie_id;
	private String time;
	private Integer room_id;
	private float price;
	public Integer getScreen_id() {
		return screen_id;
	}
	public void setScreen_id(Integer screen_id) {
		this.screen_id = screen_id;
	}
	public Integer getCenima_id() {
		return cenima_id;
	}
	public void setCenima_id(Integer cenima_id) {
		this.cenima_id = cenima_id;
	}
	public Integer getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(Integer movie_id) {
		this.movie_id = movie_id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Integer getRoom_id() {
		return room_id;
	}
	public void setRoom_id(Integer room_id) {
		this.room_id = room_id;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
}
