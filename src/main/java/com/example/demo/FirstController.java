package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import antlr.collections.List;
@Controller
public class FirstController {
	ArrayList<String> cmplist = new ArrayList<String>();
	User user1 = new User();
		private URL Null;

		@GetMapping("/home")
	    public String HomePage(@ModelAttribute User user){
			 System.out.println(user.getUsername());
	        return "home";
	    }
		@GetMapping("/contact")
	    public String ContactPage(@ModelAttribute User user){
			 System.out.println(user.getUsername());
	        return "contact";
	    }
		
	
		@GetMapping("/login")
	    public String LoginPage(Model model){
			model.addAttribute("user",new User());
			cmplist.clear();
			savedstocks.clear();
	        return "login";
	    }
		
		
		ArrayList<Stock> stocks= new ArrayList<Stock>();
		ArrayList<SavedStock> savedstocks= new ArrayList<SavedStock>();
		ArrayList<SavedStock> ts= new ArrayList<SavedStock>();
		ArrayList<Stock> stocks1= new ArrayList<Stock>();
		 
		
		@GetMapping("/searchresult")
		public String SearchResult(Model model,@ModelAttribute User user)
		{
			//System.out.println("MArket capital is "+user1.marketcap);
			  stocks1.clear();
			  stocks.clear();
			  //System.out.println("Market cap issssss"+user.marketcap);
			  //System.out.println("Market cap issssssssss"+user1.marketcap);
			  if(user.marketcap=="")
			  {
				  System.out.println("Inside market cap nulll");
				  return "registeredsuccess";
			  }
			  if(!(user.marketcap==(null)))
			  {
				 
				  user1.marketcap=user.marketcap;    
			  }
			  if(user1.marketcap==null)
			  {
				  System.out.println("Inside market cap nulll");
				  return "registeredsuccess";
			  }
			  
			 
			  
			  topFiveStocks t= new topFiveStocks();
			  model.addAttribute("user", new User());
			 model.addAttribute("t", t);
			  String url1="https://financialmodelingprep.com/api/v3/stock-screener?marketCapMoreThan="+user1.marketcap+"&betaMoreThan=1&volumeMoreThan=10000&limit=100&apikey=620c11c196a561b03e5e6201f4970816";
			System.out.println(url1);
			  URL url=Null;
				try {
					url= new URL(url1);
					
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"))) {
					int i=0;
					Stock s1=new Stock ();
				    for (String line; (line = reader.readLine()) != null;) {
				    	
				    	if(line.contains("symbol"))
				    	{
				    		i++;
				    		String symbol= line.substring(13);
				    		String[] splitlines= symbol.split(",");
				    		s1.symbol=splitlines[0];
				    		//System.out.println("printing "+splitlines[0]);
				    		
				    	}
				    	else if(line.contains("companyName"))
				    	{
				    		
				    		String symbol= line.substring(18);
				    		String[] splitlines= symbol.split(",");
				    		s1.setCompanyname(splitlines[0]);
				    		//System.out.println("printing "+splitlines[0]);
				    		
				    	}
				    	 else if(line.contains("marketCap"))
				    	{
				    		
				    		String symbol= line.substring(16);
				    		String[] splitlines= symbol.split(",");
				    		s1.marketCap=splitlines[0];
				    		//System.out.println("printing "+splitlines[0]);
				    		
				    	}
				    	else if(line.contains("price"))
				    	{
				    		
				    		String symbol= line.substring(11);
				    		
				    		String[] splitlines;
				    		
				    		splitlines= symbol.split(",");
				    		
				    		
				    		s1.price=splitlines[0];
				    		
				    		
				    	}
				    	else if(line.contains("volume"))
				    	{
				    		
				    		String symbol= line.substring(12);
				    		String[] splitlines= symbol.split(",");
				    		s1.volume=splitlines[0];
				    		//System.out.println("printing "2+splitlines[0]);
				    		
				    	}
				   
				    	else if(line.contains("beta"))
				    	{
				    		
				    		String symbol= line.substring(10,15);
				    		String[] splitlines= symbol.split(",");
				    		s1.beta=splitlines[0];
				    		//System.out.println("printing "+splitlines[0]);
				    		
				    	}
				    	else if(line.contains("{")||line.contains("lastAnnualDividend")||line.contains("sector")||line.contains("exchangeShortName")||line.contains("}"))
				    	{
				    		continue;
				    	}
				    	else 
				    	{
				    		
													
				    		stocks.add(s1);
				    		//System.out.println(s1.toString());
				    		 s1=new Stock ();

				    	}
				    
				    
				  }
				    
				 
						
						//long n=Long.parseLong("100872479000");
						//System.out.println("LONGGGGGGGGG"+n);
						
						//stocks.sort((o1, o2) -> o1.getMarketCap().compareTo(o2.getMarketCap()));
				    boolean sorted = false;
				    	Stock temp;
				    while (!sorted) {
				        sorted = true;
				        for (int p = 0; p < stocks.size()-1; p++) {
				        	long n1=Long.parseLong(stocks.get(p).marketCap);
				        	long n2=Long.parseLong(stocks.get(p+ 1).marketCap);
				            if (n1>n2) {
				                temp = stocks.get(p);
				                stocks.set(p, stocks.get(p + 1));
				                stocks.set(p+ 1, temp);
				                sorted = false;
				            }
				        }
				    }
						int length=stocks.size();
						
						int j=0,count=0;
						
						System.out.println(" sorted Stockssssssssssss");
						for ( j=0;j<length;j++) {
							
							String sn1=stocks.get(j).marketCap;
							String sn2=user1.marketcap;
							long n1=Long.parseLong(sn1);
				        	long n2=Long.parseLong(sn2);
							if(count<5&& (n1>=n2))
							{
								stocks1.add(stocks.get(j));
								count ++;
							}
						}
						 for (Stock s: stocks) {
					            System.out.println(s.getCompanyname() +s.getMarketCap());
					        }
						 System.out.println("hereeee");
						 System.out.println(" 5 closest stocks");
				        for (Stock s: stocks1) {
				            System.out.println(s.getCompanyname() +s.getMarketCap());
				        }
				      
				        t.setSymbol1(stocks1.get(0).symbol);
				        t.setSymbol2(stocks1.get(1).symbol);
				        t.setSymbol3(stocks1.get(2).symbol);
				        t.setSymbol4(stocks1.get(3).symbol);
				        t.setSymbol5(stocks1.get(4).symbol);
				        
				        t.companyname1=stocks1.get(0).companyname;
				        t.companyname2=stocks1.get(1).companyname;
				        t.companyname3=stocks1.get(2).companyname;
				        t.companyname4=stocks1.get(3).companyname;
				        t.companyname5=stocks1.get(4).companyname;
				        
				        t.marketCap1=stocks1.get(0).marketCap;
				        t.marketCap2=stocks1.get(1).marketCap;
				       t.marketCap3=stocks1.get(2).marketCap;
				       t.marketCap4=stocks1.get(3).marketCap;
				       t.marketCap5=stocks1.get(4).marketCap;
				       
				       t.price1=stocks1.get(0).price;
				       t.price2=stocks1.get(1).price;
				       t.price3=stocks1.get(2).price;
				       t.price4=stocks1.get(3).price;
				       t.price5=stocks1.get(4).price;
				       
				       t.volume1=stocks1.get(0).volume;
				       t.volume2=stocks1.get(1).volume;
				       t.volume3=stocks1.get(2).volume;
				       t.volume4=stocks1.get(3).volume;
				       t.volume5=stocks1.get(4).volume;
				       
				       t.beta1=stocks1.get(0).beta;
				       t.beta2=stocks1.get(1).beta;
				       t.beta3=stocks1.get(2).beta;
				       t.beta4=stocks1.get(3).beta;
				       t.beta5=stocks1.get(4).beta;
				        System.out.println("printingg    "+t.symbol1);
					
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
	        return "searchresult";
			}

		

		  @PostMapping("/searchresult")
		  public String greetingSubmit(@ModelAttribute topFiveStocks tfs,@ModelAttribute User user) {
			  
		    return "searchresult";
		  }
	
		  
		  @GetMapping("/register")
		  public String registerForm(Model model)
		  {
			  model.addAttribute("user", user1);
			  return "registeredsuccess";
		  }
		  @PostMapping("/register")
		public String submitForm(@ModelAttribute("user") User user) {

			//findById(user.username);
			user1.setUsername(user.username);
			user1.setPassword(user.password);
			
			
			int l1=verify(user);
			
			if (l1==1)
			{
		    return "registeredsuccess";
			}
			else 
			{
				user.setMsg("User not available");
				System.out.println("User not available");
			}
			return "login";
		}
		@Autowired
		 public JdbcTemplate jdbcTemplate;
		
		 public int verify(User user)
		 {
			 try {
			 String query ="select * from user where username ='"+user.username+"'";
			 System.out.println(query);
			 User l1=jdbcTemplate.queryForObject(query, new Object[] { },

			        (rs,rowNum) -> new User(rs.getString("username"),rs.getString("pass")));
			 if(user.password.equals(l1.password))
			 {
				 return 1;
			 }
			
				
			 
			 }
			 catch(Exception e){
				 
				 return 0;
			 }
			 return 0;
			}
		 public void gotdata(String data)
		 {
			 System.out.println(data);
		 }
		 
		
		 
		 @GetMapping("/savedstock")
		 public String getSavedStock(@ModelAttribute("user") User user,Model model)
		 {
			 model.addAttribute("user1",user1);
			 int index= Integer.parseInt(user.savedstock);
			 index=index-1;
			 if(index<5)
			 {
			 String cmpname= stocks.get(index).getCompanyname();
			 String symbol =stocks.get(index).getSymbol();
			 String[] splitlines1= cmpname.split("\"");
			 cmpname=splitlines1[1];
			 String[] splitlines2= symbol.split("\"");
			 symbol=splitlines2[1];
			 String query ="insert into savedstock values("+"'"+user1.getUsername()+"'"+",'"+cmpname+"',"+user.savedstock+",'"+symbol+"')";
			 System.out.println("SAves stock query"+query);
			 jdbcTemplate.update(query,new Object[] {});
			 }
			 else
			 {
				System.out.println("user 1 market capital"+user1.marketcap);
				String turl="redirect:/searchresult?marketcap="+user1.marketcap;
				 return turl;
			 }
			 return "savedstock";
		 }
		 URL url2;
		
		 
		 
		
		 @GetMapping("/viewsavedstocks")
		 public String viewSavedStock(@ModelAttribute("user") User user,Model model,@ModelAttribute("ss") SavedStock ss)		 {
			 model.addAttribute("user1",user1);
			 System.out.println("Saved stock is "+user.savedstock);
			if(!user.savedstock.equals(" "))
			{
				user1.setSavedstockno(user.savedstock);
			
			 int index= Integer.parseInt(user1.Savedstockno);
			 index=index-1;
			 if(index<5)
			 {
			 String cmpname= stocks.get(index).getCompanyname();
			 String symbol =stocks.get(index).getSymbol();
			 String[] splitlines1= cmpname.split("\"");
			 cmpname=splitlines1[1];
			 String[] splitlines2= symbol.split("\"");
			 symbol=splitlines2[1];
			 if(user1.cmplist.contains(cmpname))
			 {
				 System.out.println("Exists");
			 }
			 else
			 {
				 
			 
			 String query ="insert into savedstock values("+"'"+user1.getUsername()+"'"+",'"+cmpname+"',"+user1.Savedstockno+",'"+symbol+"')";
			 System.out.println("SAves stock query"+query);
			 jdbcTemplate.update(query,new Object[] {});
			 user1.cmplist.add(cmpname);
			 }
			 }
			 else
			 {
				System.out.println("user 1 market capital"+user1.marketcap);
				String turl="redirect:/searchresult?marketcap="+user1.marketcap;
				 return turl;
			 }
		 }
		
			 user1.setMsg1(" changed");
			 savedstocks.clear();
			 model.addAttribute("savedstocks",savedstocks);
			 model.addAttribute("user",user1);
			 String query ="select * from savedstock where username ='"+user1.username+"'";
			 System.out.println(query);
			 java.util.List<java.util.Map<String, Object>> rows = jdbcTemplate.queryForList(query);

		        for (java.util.Map<String, Object> row : rows) {
		            SavedStock obj = new SavedStock();
		           
		            obj.setUsername(( (String)row.get("username")));
		            obj.setCompanyname((String) row.get("companyname"));
		            obj.setSavedStock((String) row.get("savedstock"));
		            obj.setSymbol((String) row.get("symbol"));
		         
		           
		         
		            	ts.add(obj);
		            	savedstocks.add(obj);
		            
		            
		        }
		    
		        if(!savedstocks.isEmpty())
		        {
		        	user1.msg1=" ";
		        for (SavedStock map : savedstocks) {
					//System.out.println(map.toString());
					String url="https://financialmodelingprep.com/api/v3/quote/"+map.symbol+"?apikey=620c11c196a561b03e5e6201f4970816";
					
					
					
					
					
					try {
						url2= new URL(url);
						
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					try (BufferedReader reader = new BufferedReader(new InputStreamReader(url2.openStream(), "UTF-8"))) {
						int i=0;
						Stock s1=new Stock ();
					    for (String line; (line = reader.readLine()) != null;) {
					    	
					    
					    	 if(line.contains("{")||line.contains("name")||line.contains("changesPercentage")||line.contains("change")||line.contains("}")||line.contains("dayLow")||line.contains("dayHigh")||line.contains("yearHigh")||line.contains("yearLow")||line.contains("priceAvg50")||line.contains("priceAvg200")||line.contains("avgVolume")||line.contains("exchange")||line.contains("open")||line.contains("previousClose")||line.contains("eps")||line.contains("earningsAnnouncement")||line.contains("sharesOutstanding")||line.contains("timestamp"))
					    	{
					    		continue;
					    	}
					    else if(line.contains("marketCap"))
					    	{
					    		
					    		String symbol= line.substring(16);
					    		String[] splitlines= symbol.split(",");
					    		map.marketCap=splitlines[0];
					    		//System.out.println("printing "+splitlines[0]);
					    		
					    	}
					    	else if(line.contains("price"))
					    	{
					    		
					    		String symbol= line.substring(11);
					    		String[] splitlines= symbol.split(",");
					    		map.price=splitlines[0];
					    		//System.out.println("printing "+splitlines[0]);
					    		
					    	}
					    	else if(line.contains("volume"))
					    	{
					    		
					    		String symbol= line.substring(12);
					    		String[] splitlines= symbol.split(",");
					    		map.volume=splitlines[0];
					    		//System.out.println("printing "2+splitlines[0]);
					    		
					    	}
					   
					    	
					    	
					    
					    
					    
					  }
					    
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
				
		        

			 
		 }
		}
		        else
		        {
		        	user1.msg1="You have not entered any stock";
		        }
		       
		        return "viewsavedstock";
 }
		 

}