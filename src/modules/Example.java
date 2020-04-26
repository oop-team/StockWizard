package modules;

import data.Data;
import data.Session;
import data.StockExchange;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Example extends SentenceGenerator{
    public Example(Data data) {
        super(data);
    }

    @Override
    public String example() {
        return "Hôm nay tại sàn HNX, mã XYZ tăng mạnh nhất với 15%";
    }

    @Override
    public String generate() {
        Map<String, Float> map = new HashMap<>();

        Session[] sessions = data.getSessions();
        Date nearestDate = sessions[0].getDate(); // Ngày gần nhất

        String maxTicker = sessions[0].getTicker();
        Float maxPercent = 0f;

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
            } else { //diffDay = 1
                if (map.containsKey(ticker)){
                    float newClose = map.get(ticker);
                    if (newClose > close){
                        float percent = (newClose - close) / close;
                        if (percent > maxPercent){
                            maxTicker = ticker;
                            maxPercent = percent;
                        }
                    }
                }
            }
        }

        StockExchange stockExchange = data.getStockExchange();

        return String.format("Hôm nay tại sàn %s, mã %s tăng mạnh nhất với %f %%", stockExchange, maxTicker, maxPercent);
    }
}
