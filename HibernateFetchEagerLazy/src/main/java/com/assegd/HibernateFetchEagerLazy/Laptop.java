package com.assegd.HibernateFetchEagerLazy;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Laptop 
{
	@Id
	private int lid;
	private String Brand;
	private int price;

	@ManyToOne
	private Alien alien;

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Alien getAlien() {
		return alien;
	}

	public void setAlien(Alien alien) {
		this.alien = alien;
	}

	@Override
	public String toString() {
		return "Laptop [lid=" + lid + ", Brand=" + Brand + ", price=" + price + ", alien=" + alien + "]";
	}
	
	
	
}
