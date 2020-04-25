package service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channel;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import data.Data;
import data.Session;
import data.StockExchange;


public class Crawler {
	
	private static Crawler signletonInstanceCrawler ;
	
	private Crawler() {
		
	}
	
	private void log(String str) {
		System.out.println(str);
	}
	
	public static Crawler getInstance() {
		if(signletonInstanceCrawler == null) {
			return new Crawler();
		}
		
		return signletonInstanceCrawler;
	}
	
	
	private void downloadFile (String urlString , String fileNameString ) {
		try {
			
			this.log("chay vo day roi ma ");
			ReadableByteChannel readableByteChannel = Channels.newChannel(new URL(urlString).openStream());
			
			FileOutputStream fileOutputStream = new FileOutputStream(fileNameString);
			FileChannel fileChannel = fileOutputStream.getChannel();
			
			this.log("chay vo day roi ma 22222");
			fileChannel
			  .transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
			
			this.log("chay vo day roi ma 33333");
			
			fileOutputStream.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	public Data crawlDatafromLink(String url) {
		
		List<Session> sessions = new ArrayList<Session>();
		
        Session[] ret = new Session[sessions.size()];
        for(int i = 0; i < sessions.size(); i++){
            ret[i] = sessions.get(i);
        }
        
        this.log("This is link : "+ url);
        
        Document doc;
		try {
			doc = Jsoup.connect(url).get();
			this.log("title ne : "  + doc.title());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		
		this.downloadFile("http://images1.cafef.vn/data/20200424/CafeF.SolieuGD.Raw.Upto24042020.zip", "CafeF.SolieuGD.Raw.Upto24042020.zip");
        
        
		
		return new Data(StockExchange.HNX, ret);
	}

}
