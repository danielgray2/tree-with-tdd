package classes;

import java.text.NumberFormat;

public class Coffee implements Comparable<Coffee>{
	private Double price;
	private String color;
	private String company;
	
	public Coffee(Double price, String color, String company) {
		this.price = price;
		this.color = color;
		this.company = company;
	}
	
	public Coffee() {
		this.price = 1.00;
		this.color = "light";
		this.company = "Starbucks";
	}
	
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	@Override
	public int compareTo(Coffee coffee) {
		if(this.price > coffee.price) {
			return 1;
		}else if(this.price < coffee.price) {
			return -1;
		}else if(this.company.compareTo(coffee.company) > 0) {
			return 1;
		}else if(this.company.compareTo(coffee.company) < 0) {
			return -1;
		}else if(this.color.compareTo(coffee.color) > 0) {
			return 1;
		}else if(this.color.compareTo(coffee.color) < 0) {
			return -1;
		}else {
			return 0;
		}
	}
	
	@Override 
	public String toString(){
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		String price = formatter.format(this.price);
		return this.company + " " + this.color + " roast" + " for " + price;
	}
}
