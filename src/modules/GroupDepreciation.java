package modules;

import data.Input;
import data.Session;
import utilities.Dictionary;
import utilities.Filter;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GroupDepreciation extends SentenceGenerator{

    @Override
    public String example() {
        return "Dầu khí trên sàn UPCOM, những mã dầu khí như OIL, BSR đồng loạt giảm sâu trong phiên hôm nay.";
    }

    @Override
    public String generate() {
        Random r = new Random();
        String randomGroup = Dictionary.INDUSTRY_GROUPS[r.nextInt(Dictionary.INDUSTRY_GROUPS.length)];
        int randomStockExchange = r.nextInt(4);
        return generate(randomStockExchange, randomGroup);
    }

    /***
     * Sinh ra câu có những mã giảm trên sàn stockExchange thuộc nhóm ngành group
     */
    public String generate(int stockExchange, String group) {
        Filter filter = new Filter();
        Session[] sessions = filter.filter(Input.inputData[stockExchange].getSessions(), group);
        String[] tickers = new String[400];
        int numberOfTickers = 0;
        Map<String, Float> map = new HashMap<>();

        Date today = sessions[0].getDate();
        Date previousDay = null; // Ngày giao dịch trước đó

        // Tìm previousDay
        for (Session s : sessions){
            if (!s.getDate().equals(today)){
                previousDay = s.getDate();
                break;
            }
        }

        // Tìm danh sách những mã giảm
        for (Session s : sessions) {
            String ticker = s.getTicker();
            if(s.getDate().equals(today)){
                map.put(ticker, s.getClose());
            }
            else if (s.getDate().equals(previousDay)){
                    if (map.containsKey(ticker)) {
                        float close = s.getClose();
                        float newClose = map.get(ticker);
                        if (newClose - close < 0) {
                            tickers[numberOfTickers++] = ticker;
                        }
                    }
            }
            else{
                break;
            }
        }


        String s = group + " trên ";
        switch (stockExchange){
            case 0: s += "sàn HNX"; break;
            case 1: s += "sàn HSX"; break;
            case 2: s += "sàn UPCOM"; break;
            case 3: s += "cả ba sàn";
        }
        s += ", những mã dầu khí như ";
        for(int i = 0; i < numberOfTickers - 1; i++){
            s += tickers[i] + ", ";
        }
        s += tickers[numberOfTickers-1] + " đồng loạt giảm sâu trong phiên hôm nay.";
        return s;
    }

    public static void main(String[] args) {
        Input.updateDataFromLocal("res/sample/data/CafeF.SolieuGD.Upto27042020.zip");
        GroupDepreciation s = new GroupDepreciation();
        System.out.println(s.generate(0, "Dầu khí"));
    }
}
