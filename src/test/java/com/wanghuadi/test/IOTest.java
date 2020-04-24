package com.wanghuadi.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wanghuadi.beans.Goods;
import com.wanghuadi.mapper.GoodsMapper;
import com.wanghuadi.utils.IOUtil;
import com.wanghuadi.utils.StringUtil;

public class IOTest {

	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		GoodsMapper mapper = ac.getBean(GoodsMapper.class);
		List<Object[]> list = IOUtil.readFile("file.txt", "==");
		for (Object[] objects : list) {
			String id = objects[0]+"";
			String name = objects[1]+"";
			String price = objects[2]+"";
			String sales = objects[3]+"";
			
			if(!StringUtil.isEmpty(price) && !StringUtil.isNumber(price)){
				price = price.substring(1);
			}
			
			if(!StringUtil.isEmpty(sales)){
				 if(!StringUtil.isNumber(sales)){
					 sales = sales.replaceAll("%", "");
				 }
			}else{
				sales = "0";
			}
			
			/**
			    a)ID值要使用isNumber()工具方法判断是不是数字。（2分）
				b)商品名称要使用hasText()方法判断有没有值。（2分）
				c)价格要使用hasText()方法判断有没有值，并使用isNumber()判断是不是数字（不是数字的可以手工处理好再解析）。然后去掉“¥”符号，再转成数字。（4分）
				d)百分比使用hasText()方法判断有没有值，如果没值则默认为0，并使用isNumber()判断是不是数字。然后去掉“%”符号，再转成数字。（4分）
				e)将每行数据解析到Goods类中，然后通过MyBatis保存到数据库。总共106条数据，少1行扣2分，最多扣20分。（6分）
			 */
			Goods goods = new Goods(Integer.parseInt(id), name, Double.parseDouble(price), Integer.parseInt(sales));
			
			
			//添加数据库
			mapper.insertGoods(goods);
		}
		
	}
	
}
