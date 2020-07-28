package com.example.demo;

public class SavedStock {
public String username;
public String companyname;
public String savedstock;
public String symbol;
public String price;
public String volume;
public String marketCap;

public SavedStock()
{
	
}

public SavedStock(String username, String companyname, String savedstock, String symbol, String price, String volume,String marketCap) {
	
	this.username = username;
	this.companyname = companyname;
	this.savedstock = savedstock;
	this.symbol = symbol;
	this.price = price;
	this.volume = volume;
	this.marketCap=marketCap;
}

public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getCompanyname() {
	return companyname;
}
public void setCompanyname(String companyname) {
	this.companyname = companyname;
}
public String getSavedStock() {
	return savedstock;
}
public void setSavedStock(String savedstock) {
	this.savedstock = savedstock;
}

public String getSymbol() {
	return symbol;
}
public void setSymbol(String symbol) {
	this.symbol = symbol;
}

public String getMarketCap() {
	return marketCap;
}

public void setMarketCap(String marketCap) {
	this.marketCap = marketCap;
}

@Override
public String toString() {
	return "SavedStock [username=" + username + ", companyname=" + companyname + ", savedstock=" + savedstock
			+ ", symbol=" + symbol + ", price=" + price + ", volume=" + volume + "]";
}



}
