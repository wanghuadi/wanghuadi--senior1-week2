package com.wanghuadi.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wanghuadi.beans.Goods;
import com.wanghuadi.mapper.GoodsMapper;

@Service
public class GoodsServiceImpl implements GoodsService {

	@Resource
	private GoodsMapper goodsMapper;
	
	@Override
	public List<Goods> queryAll(Map<String, Object> map) {
		return goodsMapper.queryAll(map);
	}

}
