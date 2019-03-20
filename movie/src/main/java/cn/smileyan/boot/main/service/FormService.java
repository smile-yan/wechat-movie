package cn.smileyan.boot.main.service;

import java.util.List;

import cn.smileyan.boot.main.entity.Form;

public interface FormService {
	
	byte EXISTED = -1;		// 座位已经占
	byte NOMONEY = -2;		// 金额不够
	byte OTHER = -3;		// 其他原因
	/**
	 * 查找所有表单
	 * @return 所有表单
	 */
	List<Form> findAll();
	
	/**
	 * 添加表单 
	 * @param form
	 * @return 添加成功时的表单或者null
	 */
	Form addForm(Form form);
	
	/**
	 * 查询已经订好的票 
	 * @param screen_id
	 * @return
	 */
	List<Form> findOrderedForm(Integer screen_id);
	
	/**
	 * 根据用户id查询
	 * @param user_id
	 * @return 此用户相关的所有订单
	 */
	List<Form> findByUser_id(Integer user_id);
	
	/**
	 * 根据screen_id查所有表
	 * @param screen_id
	 * @return
	 */
	List<Form> findByScreen_id(Integer screen_id);
	
	/**
	 * @description 获得随机码用于取票 
	 * @param screen_id
	 * @return
	 */
	String findCodeByOrder_id(Integer order_id);
}
