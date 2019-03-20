package cn.smileyan.boot.main.test;

import org.json.JSONObject;

public class TestJson {
	public static void main(String[] args) {
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("name", "stupid");
		System.out.println(jsonObject.get("name"));
	}
}
