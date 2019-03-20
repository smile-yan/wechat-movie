package cn.smileyan.boot.main.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * 放映室信息、座位信息
 * @author Administrator
 *
 */
@Entity
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer room_id;
	
	private Integer cinema_id;
	
	private String room_name;
	
	private Integer room_row;
	
	private Integer room_column;

	public Integer getRoom_id() {
		return room_id;
	}

	public void setRoom_id(Integer room_id) {
		this.room_id = room_id;
	}

	public Integer getCinema_id() {
		return cinema_id;
	}

	public void setCinema_id(Integer cinema_id) {
		this.cinema_id = cinema_id;
	}

	public String getRoom_name() {
		return room_name;
	}

	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}

	public Integer getRoom_row() {
		return room_row;
	}

	public void setRoom_row(Integer room_row) {
		this.room_row = room_row;
	}

	public Integer getRoom_column() {
		return room_column;
	}

	public void setRoom_column(Integer room_column) {
		this.room_column = room_column;
	}
}
