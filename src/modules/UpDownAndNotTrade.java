package modules;

import data.Data;
import data.Session;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class UpDownAndNotTrade extends SentenceGenerator {

    @Override
    public String example() {
        return "Hiện có 153 mã tăng giá, 10 mã giảm giá và 3 mã chưa có giao dịch.";
    }

    @Override
    public String generate() {
        int[] countHNX = count(data[0]);
        int[] countHSX = count(data[1]);
        int[] countUPCOM = count(data[2]);

        int[] count = new int[3];
        for(int i = 0; i < 3; i++){
            count[i] = countHNX[i] + countHSX[i] + countUPCOM[i];
        }
        return String.format("Hiện có %d mã tăng giá, %d mã giảm giá và %d mã chưa có giao dịch.", count[0], count[1], count[2]);
    }

    private int[] count(Data data) {
        int[] ret = new int[3];

        Map<String, Float> map = new HashMap<>();// Lưu mã cổ phiếu và giá đóng cửa

        Session[] sessions = data.getSessions();// Lưu giữ liệu các phiên giao dịch vào sessions
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
}