package com.dto;

public class Movie {
	private int id;
	private String name;
	private double price;
	private double rate;
	private String language;
	private byte [] image;

	public Movie() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public String toString() {
		return "movie [id=" + id + ", name=" + name + ", price=" + price + ", rate=" + rate + ", language=" + language
				+ "]";
	}

	public byte [] getImage() {
		return image;
	}

	public void setImage(byte [] image) {
		this.image = image;
	}

}
