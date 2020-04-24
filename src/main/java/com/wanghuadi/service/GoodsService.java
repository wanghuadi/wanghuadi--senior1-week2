package com.wanghuadi.service;

import java.util.List;
import java.util.Map;

import com.wanghuadi.beans.Goods;

public interface GoodsService {
	public List<Goods> queryAll(Map<String,Object> map);
}
