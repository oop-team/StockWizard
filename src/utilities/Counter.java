package utilities;

import data.Data;
import data.Session;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Đếm số mã tăng, giảm, đứng giá, không giao dịch => Nhật
 * <p>
 * input: Data
 * output: số mã tăng, giảm, đứng giá, không giao dịch trong ngày gần nhất
 * </p>
 */
public class Counter {
    private Session[] sessions;
    private int[] result;

    public Counter(Session[] sessions) {
        this.sessions = sessions;
    }

    public int[] getResult() {
        return result;
    }

    public int[] countUpDownAndNotTrade(Data data) {
        int[] ret = new int[3];

        Map<String, Float> map = new HashMap<>();

        Session[] sessions = data.getSessions();
        Date today = sessions[0].getDate();
        Date previousDay = null; // Ngày giao dịch trước đó

        // Tìm previousDay
        for (Session s : sessions){
            if (!s.getDate().equals(today)){
                previousDay = s.getDate();
                break;
            }
        }

        for (Session s : sessions) {
            String ticker = s.getTicker();
            if(s.getDate().equals(today)){
                map.put(ticker, s.getClose());
            }
            else if (s.getDate().equals(previousDay)){
                if (map.containsKey(ticker)) {
                    float close = s.getClose();
                    float newClose = map.get(ticker);
                    if (newClose - close > 0) {
                        ret[0] +=1;
                    } else if (newClose - close < 0) {
                        ret[1] +=1;
                    }
                }
                else{
                    ret[2] += 1;
                }
            }
            else{
                break;
            }
        }
        return ret;
    }
    /***
     *
     * @return [countUp, countDown, countStand]
     */
    public int[] countUpAndDown(Data data) {
        int[] ret = new int[3];

        Map<String, Float> map = new HashMap<>();

        Session[] sessions = data.getSessions();
        Date today = sessions[0].getDate();
        Date previousDay = null; // Ngày giao dịch trước đó

        // Tìm previousDay
        for (Session s : sessions){
            if (!s.getDate().equals(today)){
                previousDay = s.getDate();
                break;
            }
        }

        for (Session s : sessions) {
            String ticker = s.getTicker();
            if(s.getDate().equals(today)){
                map.put(ticker, s.getClose());
            }
            else if (s.getDate().equals(previousDay)){
                if (map.containsKey(ticker)) {
                    float close = s.getClose();
                    float newClose = map.get(ticker);
                    if (newClose - close > 0) {
                        ret[0] +=1;
                    } else if (newClose - close < 0) {
                        ret[1] +=1;
                    } else if (newClose - close == 0) {
                        ret[2] +=1;
                    }
                }
            }
            else{
                break;
            }
        }
        return ret;
    }


}
