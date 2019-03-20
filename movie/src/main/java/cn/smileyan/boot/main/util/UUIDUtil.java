package cn.smileyan.boot.main.util;

import java.util.UUID;

public class UUIDUtil {
	// 获得64位随机数
	public static String getUUID64() {
		String uuid1 = UUID.randomUUID().toString().replaceAll("-", "");
		String uuid2 = UUID.randomUUID().toString().replaceAll("-", "");
		return uuid1+uuid2;
	}
}
