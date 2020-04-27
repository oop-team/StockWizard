package modules;

import data.Data;
import data.Session;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class UpDownAndNotTrade extends SentenceGenerator {
    public UpDownAndNotTrade(Data data) {
        super(data);
    }

    @Override
    public String example() {
        return "Sàn HNX hiện có 153 mã tăng giá, 10 mã giảm giá và 3 mã chưa có giao dịch.";
    }

    @Override
    public String generate() {

        String stockEx = data.getStockExchange().toString();
        int[] count = count();
        String result = new String();
        result = String.format("Sàn %s hiện có %d mã tăng giá, %d mã giảm giá và %d mã chưa có giao dịch.",stockEx, count[0], count[1], count[2]);
        return result;
    }

    private int[] count() {
        int[] ret = new int[3];

        Map<String, Float> map = new HashMap<>();

        Session[] sessions = data.getSessions();
        Date nearestDate = sessions[0].getDate();

        for (Session s : sessions) {
            // Chỉ duyệt trong 2 ngày gần nhất
            long diffTime = nearestDate.getTime() - s.getDate().getTime();
            int diffDay = (int) (diffTime / (1000 * 60 * 60 * 24));
            if (diffDay > 1) {
                break;
            }

            String ticker = s.getTicker();
            float close = s.getClose();
            if (diffDay == 0) {
                map.put(ticker, s.getClose());
            } else {
                if (map.containsKey(ticker)) {
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
        }
        return ret;
    }
}