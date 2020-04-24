package com.wanghuadi.mapper;

import java.util.List;
import java.util.Map;

import com.wanghuadi.beans.Goods;

public interface GoodsMapper {
	public void insertGoods(Goods goods);
	public List<Goods> queryAll(Map<String,Object> map);
}
