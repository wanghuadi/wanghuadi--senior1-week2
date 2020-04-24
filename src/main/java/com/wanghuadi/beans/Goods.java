package com.wanghuadi.beans;

public class Goods {
	private Integer id;
	private String name;
	private Double price;
	private Integer sales;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getSales() {
		return sales;
	}
	public void setSales(Integer sales) {
		this.sales = sales;
	}
	public Goods(Integer id, String name, Double price, Integer sales) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.sales = sales;
	}
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", price=" + price + ", sales=" + sales + "]";
	}
	
}
