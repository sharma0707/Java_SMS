package sms_main_class;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;

public class Main_class {
	
	public static void sendSMS(String msg, String number) {
//		System.out.println(msg);
//		System.out.println(number);
		
		try {
			
		
		String apikey = "YNGkCuZemq5IogRJj29hzQWnPXFvs7L46lKyawDtS031xprdOMda03hRoXYytgEizwMZ9spO7VxGek5J";
		String sendID ="FSTSMS";
		String lang = "English";
		String route = "p"; // p stand for promotional message and we can use "t", for transactional
				
		String url ="https://www.fast2sms.com/dev/bulkV2?authorization="+ 
		apikey+"&variables_values"+sendID+"&route=p"+number;
		
		//sending get request using java
		
		URL myurl = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) myurl.openConnection();
		
		con.setRequestMethod("GET");
		con.setRequestProperty("user-Agent", "Chrome/6.0");
		con.setRequestProperty("cache-control","no-cache");
		System.out.println("wait..............");
		
		int server_code =con.getResponseCode();
		System.out.println(server_code);
		
		StringBuffer sb = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
				while(true) {
					String line = br.readLine();
					if(line == null) {
						break;
					}				
		sb.append(line);
				}
		System.out.println(sb);
		
		
		
		
		
		  msg = URLEncoder.encode(msg, "UTF-8");
//		  System.out.println(msg);  for orginal message print
		  }
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		Main_class.sendSMS("this message sent by java code....."+ new Date().toLocaleString(), "7530946454");
	}

}
