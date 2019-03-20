package cn.smileyan.boot.main.controler;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import cn.smileyan.boot.main.entity.Form;
import cn.smileyan.boot.main.service.FormService;
import cn.smileyan.boot.main.util.TimeUtil;
import cn.smileyan.boot.main.util.UUIDUtil;

@RestController
@RequestMapping("/form")
@CrossOrigin
public class FormControler {
	@Autowired
	private FormService formService;
	/**
	 * 根据场次号查询已经订好的座位
	 * @return 所有订好的座位
	 */
	@RequestMapping("/find")
	public ArrayList<Form> showForm(@RequestParam("screen_id")Integer screen_id) {
		ArrayList<Form> forms = (ArrayList<Form>) formService.findOrderedForm(screen_id);
		return forms;
	}
	
	/**
	 * 添加订票
	 * @return 订阅的票
	 */
	@PostMapping("/submit")
	public String addForm(@RequestParam("user_id")Integer user_id,
						@RequestParam("screen_id")Integer screen_id,
						@RequestParam("seat_info")String seat_info) {
		String strResult = "";
		Form form = new Form();
		form.setOrder_id(0);
		form.setScreen_id(screen_id);
	
		form.setUser_id(user_id);
		// 设置64位随机数
		String code = UUIDUtil.getUUID64();
		form.setCode(code);
		System.out.println("code"+code);
		// 获得座位数目
		String allseats = seat_info.trim();
		System.out.println("screen_id="+screen_id+"seat_info=="+seat_info);
//		int num = allseats.length()/4;
	
		int i,j;
		for(j=0,i=0; j<allseats.length()/4; i+=4,j++) {
			System.out.println("i=="+i+"and "+allseats.charAt(i));
			String seat = allseats.substring(i, i+4);
			System.out.println("seat=="+seat);
			
			String strx = allseats.substring(i,i+2);
			System.out.println("seatx=="+strx);
			String stry = allseats.substring(i+2,i+4);
			System.out.println("stry=="+stry);
			
			System.out.println("所选择的座位为"+strx+","+stry);
			// 解决行与列颠倒了的问题
			int seat_x = Integer.parseInt(stry);
			int seat_y = Integer.parseInt(strx);
			form.setSeat_x(seat_x);
			form.setSeat_y(seat_y);
			
			form.setOrder_time(TimeUtil.getCurrentTime());
			// 保存信息
			Form result=formService.addForm(form);
			if(result.getOrder_id()==FormService.EXISTED) {
				System.out.println(j+"此位置已被购买！");
				strResult += "("+seat_y+","+seat_x+")已经被购买";
//				return "此位置已被购买";
			}else if(result.getOrder_id()==FormService.NOMONEY) {
				System.out.println("用户余额不足");
				strResult += "购买("+seat_y+","+seat_x+")失败，用户余额不足";
			}else {
				strResult += "购买("+seat_y+","+seat_x+")成功！";
			}
		}
		
		return strResult;
	}
	
	
	// 查询所有已经购买了 的
	@RequestMapping("/all_seats")
	public List<Seats> allSeatsOrdered(@RequestParam("screen_id")Integer screen_id){
		List<Form> forms = formService.findByScreen_id(screen_id);
		List<Seats> allSeats=new LinkedList<Seats>();
		for (Form form : forms) {
			Seats seat = new Seats();
			seat.setX(form.getSeat_x());
			seat.setY(form.getSeat_y());
			allSeats.add(seat);
		}
		return allSeats;
	}

	/**
	 * 根据order_id查随机码
	 * @param order_id
	 * @return
	 */
	@RequestMapping("/code")
	public String getCodeByOrderId(@RequestParam("order_id") Integer order_id) {
		return formService.findCodeByOrder_id(order_id);
	}
	
	// 所有已经购买的座位
	private class Seats{
		private Integer x;
		private Integer y;
		@SuppressWarnings("unused")
		public Integer getX() {
			return x;
		}
		public void setX(Integer x) {
			this.x = x;
		}
		@SuppressWarnings("unused")
		public Integer getY() {
			return y;
		}
		public void setY(Integer y) {
			this.y = y;
		}
	}
	
}
