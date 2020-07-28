package com.example.demo;

public class Stock {
public String symbol;
public String companyname;
public String marketCap;

public String price;
public String volume;

public String beta;
public String getSymbol() {
	return symbol;
}
public void setSymbol(String symbol) {
	this.symbol = symbol;
}
public String getCompanyname() {
	return companyname;
}
public void setCompanyname(String companyname) {
	this.companyname = companyname;
}
public String getMarketCap() {
	return marketCap;
}
public void setMarketCap(String marketCap) {
	this.marketCap = marketCap;
}

public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public String getVolume() {
	return volume;
}
public void setVolume(String volume) {
	this.volume = volume;
}

public String getBeta() {
	return beta;
}
public void setBeta(String beta) {
	this.beta = beta;
}
@Override
public String toString() {
	return "Stock [symbol=" + symbol + ", companyname=" + companyname + ", marketCap=" + marketCap +  ", price=" + price + ", volume=" + volume  + ", beta=" + beta + "]";
}




}
