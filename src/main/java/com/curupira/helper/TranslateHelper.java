package com.curupira.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TranslateHelper {
	
	private final String USER_AGENT = "Mozilla/5.0";
	
	private static String[] i18nSymbols=new String[]{"am","az","be","bg","bn","ca","crs","cs","da","de","el","es","et","fa","fi","fr","hi","hr","hu","hy","id","is","it","iw","ja","ka","kh","kk","ko","kri","lo","lr","lt","lv","mg","mk","mn","ms","mt","my","ne","nl","no","ny","pl","ps","pt_BR","pt","ro","ru","si","sk","sl","so","sq","sr_ME","sr","st","sv","sw","tg","th","tk","tl","tn","to","tr","uk","ur","uz","vi","zh_CN"};
	
	public String getTranslation(String inString, String languageFrom, String languageTo) throws IOException{
		String urlStr = "http://translate.google.com/translate_a/t?client=j&text="+inString+"&hl=en&sl="+languageFrom+"&tl="+languageTo;
		try {
			URL url = new URL(urlStr);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			
			//con.setRequestProperty("User-Agent", USER_AGENT);
			
			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);
			
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			
			String inputLine;
			
			StringBuffer response = new StringBuffer();
			
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			
			in.close();
			
			System.out.println(response.toString());
			
			
			
		} catch (MalformedURLException e) {
			throw new RuntimeException("Wrong URL!");
		} catch (IOException e) {
			throw new IOException();
		}
		
		
		return "";
	}
	

}
