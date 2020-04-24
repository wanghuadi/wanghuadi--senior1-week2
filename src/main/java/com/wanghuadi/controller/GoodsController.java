package com.wanghuadi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wanghuadi.beans.Goods;
import com.wanghuadi.service.GoodsService;

@Controller
public class GoodsController {

	@Resource
	private GoodsService goodsService;

	
	@RequestMapping("queryAll")
	public String list(@RequestParam(defaultValue="1")Integer pageNum,Model model,Integer startPrice,
			Integer endPrice,Integer startSales,Integer endSales,String column,String orders){
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startPrice", startPrice);
		map.put("endPrice", endPrice);
		map.put("startSales", startSales);
		map.put("endSales", endSales);
		map.put("column", column);
		map.put("orders", orders);
		PageHelper.startPage(pageNum, 5);
		List<Goods> list = goodsService.queryAll(map);
		PageInfo<Goods> page = new PageInfo<>(list);
		model.addAttribute("page", page);
		return "list";
	}
	
}
