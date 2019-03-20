package cn.smileyan.boot.main.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
/**
 * 影院信息
 * @author Administrator
 *
 */
public class Cinema {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cinema_id;
	
	private String cinema_name;
	private String location;
	public Integer getCinema_id() {
		return cinema_id;
	}
	public void setCinema_id(Integer cinema_id) {
		this.cinema_id = cinema_id;
	}
	public String getCinema_name() {
		return cinema_name;
	}
	public void setCinema_name(String cinema_name) {
		this.cinema_name = cinema_name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}
