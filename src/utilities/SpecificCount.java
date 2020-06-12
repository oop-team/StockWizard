package utilities;

import data.Session;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/*
  Đếm rồi lưu tên mã tăng, giảm cùng giá trị đóng cửa tương ứng vào 2 map:
        resultMapUp: chứa tên mã tăng và giá trị đóng cửa tương ứng
        resultMapDown: chứa tên mã giảm và giá trị đóng cửa tương ứng
        resultMapNotChange
        resultMapNotTrade
 */

public class SpecificCount {

    private Map<String, Float> resultMapUp = new HashMap<>();
    private Map<String, Float> resultMapDown = new HashMap<>();
    private Map<String, Float> resultMapNotChange = new HashMap<>();
    private Map<String, Float> resultMapNotTrade = new HashMap<>();

    public Map<String, Float> getResultMapUp() {
        return resultMapUp;
    }

    public Map<String, Float> getResultMapDown() {
        return resultMapDown;
    }

    public Map<String, Float> getResultMapNotChange() {
        return resultMapNotChange;
    }

    public Map<String, Float> getResultMapNotTrade() {
        return resultMapNotTrade;
    }

    public void count(Session[] sessions) {
        SpecificCount date= new SpecificCount();
        Map<String, Float> map = new HashMap<>();

        Date today= date.FindToday(sessions);
        Date previousDay=date.FindPreDay(sessions);
        System.out.println(previousDay);
        System.out.println(today);

        for (Session s : sessions) {
            String ticker = s.getTicker();
            if (s.getDate().equals(today)) {
                map.put(ticker, s.getClose());
            } else if (s.getDate().equals(previousDay)) {
                if (map.containsKey(ticker)) {
                    float close = s.getClose();
                    float newClose = map.get(ticker);
                    if (newClose - close > 0) {
                        resultMapUp.put(ticker, newClose);
                    }else if (newClose - close < 0) {
                        resultMapDown.put(ticker, newClose);
                    }else{
                        resultMapNotChange.put(ticker, newClose);
                    }
                }
                else{
                    resultMapNotTrade.put(ticker, (float) 0);
                }
                } else {
                    break;
                }
            }
        }



    public Date FindToday(Session[] sessions){
        Date today  = sessions[0].getDate();
        return today;
    }
    public Date FindPreDay(Session[] sessions){
        SpecificCount date= new SpecificCount();
        Date previousDay = null; // Ngày giao dịch trước đó
        Date today= date.FindToday(sessions);
        // Tìm previousDay
        for (Session s : sessions){
            if (!s.getDate().equals(today)){
                previousDay = s.getDate();
                break;
            }
        }
        return previousDay;
    }
}



