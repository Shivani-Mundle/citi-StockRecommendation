
package com.example.demo;

import java.util.ArrayList;

public class User {
	
public String username=" ";
public String password=" ";
public String msg=" " ;
public String msg1=" " ;
public String marketcap;
public String savedstock=" ";
public String Savedstockno=" ";
public User() {};
public ArrayList<String> cmplist =new ArrayList<String>() ;
public User(String username, String password) {
	
	this.username = username;
	this.password = password;
}
public String getUsername() {
	System.out.println(username);
	return username;
	
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getMsg() {
	return msg;
}
public void setMsg(String msg) {
	this.msg = msg;
}
public String getMarketcap() {
	return marketcap;
}
public void setMarketcap(String marketcap) {
	this.marketcap = marketcap;
}
public String getSavedstock() {
	return savedstock;
}
public void setSavedstock(String savedstock) {
	this.savedstock = savedstock;
}
public String getMsg1() {
	return msg1;
}
public void setMsg1(String msg1) {
	this.msg1 = msg1;
}
public String getSavedstockno() {
	return Savedstockno;
}
public void setSavedstockno(String savedstockno) {
	Savedstockno = savedstockno;
}
public ArrayList<String> getCmplist() {
	return cmplist;
}
public void setCmplist(ArrayList<String> cmplist) {
	this.cmplist = cmplist;
}



}
