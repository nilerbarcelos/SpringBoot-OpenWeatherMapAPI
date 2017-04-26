package com.nilerbarcelos.model;

import java.util.List;

public class Previsao {

	private String cod;
	private List<Item> list;
	private CidadeApi city;
	
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public List<Item> getList() {
		return list;
	}
	public void setList(List<Item> list) {
		this.list = list;
	}
	public CidadeApi getCity() {
		return city;
	}
	public void setCity(CidadeApi city) {
		this.city = city;
	}
}