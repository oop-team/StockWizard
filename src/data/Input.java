package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import service.Crawler;
import service.FileHelper;

public class Input {
	
    public Data[] getDataFromWeb(String  url){
        // TODO:
        Crawler crawler = Crawler.getInstance();
        FileHelper fileHelper = FileHelper.getInstance();
        ArrayList<Data> datasFromWeb = new ArrayList<Data>();
        
        ArrayList<String> downloadLinks = crawler.crawlDownloadLink(url);
        
        if(downloadLinks.size()>0) {
        	datasFromWeb = fileHelper.scanFileByUrl(downloadLinks.get(0));
        	
        }
        
        
        Data[] ret = new Data[datasFromWeb.size()];
        for(int i = 0; i < datasFromWeb.size(); i++){
            ret[i] = datasFromWeb.get(i);
        	System.out.println("TEST FOR FUN MAN ");
        	System.out.println(ret[i].getStockExchange());
        	System.out.println(ret[i].getSessions().length);
        }
        
        return ret;
        
    }

    public Data[] getDataFromLocal(String filePath){
        // TODO:
    	
    	FileHelper fileHelper = FileHelper.getInstance();
    	ArrayList<Data> datasFromLocal = fileHelper.scanFile(filePath);
        
        Data[] ret = new Data[datasFromLocal.size()];
        for(int i = 0; i < datasFromLocal.size(); i++){
            ret[i] = datasFromLocal.get(i);
        	System.out.println("TEST FOR FUN MAN ");
        	System.out.println(ret[i].getStockExchange());
        	System.out.println(ret[i].getSessions().length);
        }
    	
        return ret;
    }

    /***
     *  Hàm lấy dữ liệu ảo.
     *  Lưu ý: Dữ liệu này này chỉ ở sàn HNX
     * @return
     */
    public Data getExampleData(){
        List<Session> sessions = new ArrayList<>();

        Scanner sc = null;
        try {
            sc = new Scanner(new File("res/Example_Data.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert sc != null;
        sc.useDelimiter("\n");
        sc.next();

        sc.useDelimiter("[,\n]");
        
        while (sc.hasNext())  //returns a boolean value
        {
            Session session = new Session();
            session.setTicker(sc.next());

            // e.g: "20201015" -> "2020-10-15"
            String date = sc.next();
            Date d = null;
            try {
                d = (Date) new SimpleDateFormat("yyyyMMdd").parse(date);
                SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-mm-dd");
            } catch (ParseException e) {
                e.printStackTrace();
            }
            session.setDate(d);

            session.setOpen(Float.parseFloat(sc.next()));
            session.setHigh(Float.parseFloat(sc.next()));
            session.setLow(Float.parseFloat(sc.next()));
            session.setClose(Float.parseFloat(sc.next()));
            session.setVolume(Integer.parseInt(sc.next().trim()));

            sessions.add(session);
        }
        sc.close();

        Session[] ret = new Session[sessions.size()];
        for(int i = 0; i < sessions.size(); i++){
            ret[i] = sessions.get(i);
        }

        return new Data(StockExchange.HNX, ret);
    }
}
