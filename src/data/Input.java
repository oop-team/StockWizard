package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Input {
    public Data getDataFromWeb(){
        // TODO:
        return null;
    }

    public Data getDataFromLocal(){
        // TODO:
        return null;
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
