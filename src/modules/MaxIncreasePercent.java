package modules;

import data.Data;
import data.Session;
import data.StockExchange;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MaxIncreasePercent extends SentenceGenerator{

    @Override
    public String example() {
        return "Hôm nay, mã ABC tăng mạnh nhất với 15%";
    }

    @Override
    public String generate() {
        String maxTicker = "";
        Float maxPercent = 0f;

        // Duyệt trên cả 3 sàn, tìm ra mã có phần trăm tăng cao nhất
        for(int i = 0; i < 3; i++){
            Map<String, Float> map = new HashMap<>();

            Session[] sessions = data[i].getSessions();
            Date nearestDate = sessions[0].getDate(); // Ngày gần nhất

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
        }

        return String.format("Hôm nay, mã %s tăng mạnh nhất với %f %%", maxTicker, maxPercent);
    }


}
