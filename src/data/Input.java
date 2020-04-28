package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import service.Crawler;
import service.FileHelper;

public class Input {

    /***
     * Dữ liệu sau khi được cập nhật lưu vào đây
     * inputData[0]: dữ liệu trên sàn HNX
     * inputData[1]: dữ liệu trên sàn HSX
     * inputData[2]: dữ liệu trên sàn UPCOM
     */
    public static Data[] inputData;

    public void updateDataFromWeb(String url){
        inputData = getDataFromWeb(url);
    }

    public void updateDataFromLocal(String filePath){
        inputData = getDataFromLocal(filePath);
    }

    private Data[] getDataFromWeb(String  url){
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

    private Data[] getDataFromLocal(String filePath){
        System.out.println("Loading file " + filePath + " ...");
    	FileHelper fileHelper = FileHelper.getInstance();
    	ArrayList<Data> datasFromLocal = fileHelper.scanFile(filePath);

        System.out.println("Data loaded");
        Data[] ret = new Data[datasFromLocal.size()];
        for(int i = 0; i < datasFromLocal.size(); i++){
            ret[i] = datasFromLocal.get(i);
            System.out.println(ret[i].getStockExchange());
            System.out.println(ret[i].getSessions().length + " record");
        }
        System.out.println();
        return ret;
    }

//    /***
//     *  Hàm lấy dữ liệu ảo.
//     *  Lưu ý: Dữ liệu này này chỉ ở sàn HNX
//     * @return
//     */
//    public Data getExampleData(){
//        List<Session> sessions = new ArrayList<>();
//
//        Scanner sc = null;
//        try {
//            sc = new Scanner(new File("res/Example_Data.csv"));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        assert sc != null;
//        sc.useDelimiter("\n");
//        sc.next();
//
//        sc.useDelimiter("[,\n]");
//
//        while (sc.hasNext())  //returns a boolean value
//        {
//            Session session = new Session();
//            session.setTicker(sc.next());
//
//            // e.g: "20201015" -> "2020-10-15"
//            String date = sc.next();
//            Date d = null;
//            try {
//                d = (Date) new SimpleDateFormat("yyyyMMdd").parse(date);
//                SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-mm-dd");
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//            session.setDate(d);
//
//            session.setOpen(Float.parseFloat(sc.next()));
//            session.setHigh(Float.parseFloat(sc.next()));
//            session.setLow(Float.parseFloat(sc.next()));
//            session.setClose(Float.parseFloat(sc.next()));
//            session.setVolume(Integer.parseInt(sc.next().trim()));
//
//            sessions.add(session);
//        }
//        sc.close();
//
//        Session[] ret = new Session[sessions.size()];
//        for(int i = 0; i < sessions.size(); i++){
//            ret[i] = sessions.get(i);
//        }
//
//        return new Data(StockExchange.HNX, ret);
//    }
}
