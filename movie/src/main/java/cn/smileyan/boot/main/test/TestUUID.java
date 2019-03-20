package cn.smileyan.boot.main.test;

import java.util.UUID;

public class TestUUID {
	public static void main(String[] args) {
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.replace("-", "");           
		System.out.println(uuid);
	}
}
