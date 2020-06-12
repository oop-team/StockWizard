package modules;

import data.Data;
import data.Session;
import data.StockExchange;
import utilities.Counter;
import utilities.SpecificCount;

import java.util.*;
public class CountUpAndDownInHSX extends SentenceGenerator{
    private Session[] sessions;
    @Override
    public String example() {
        return " Trên sàn HSX đang có 77 mã tăng giá, 33 mã giảm giá và 11 mã đứng giá.";
    }

    @Override
    public String generate() {
        SpecificCount countHSX = new SpecificCount();
        Map<String, Float> resultMapUp = new HashMap<>();
        Map<String, Float> resultMapDown = new HashMap<>();
        Map<String, Float> resultMapNotChange = new HashMap<>();
        Map<String, Float> resultMapNotTrade = new HashMap<>();

        countHSX.count(data[1].getSessions());
        resultMapUp=countHSX.getResultMapUp();
        resultMapDown=countHSX.getResultMapDown();
        resultMapNotChange=countHSX.getResultMapNotChange();
        resultMapNotTrade=countHSX.getResultMapNotTrade();

        String[] result = new String[3];
        result[0] = String.format("Toàn thị trường hiện đang có %d mã tăng giá, %d mã giảm giá và %d mã đứng giá", resultMapUp.size(), resultMapDown.size(),resultMapNotChange.size());
        result[1] = String.format("Hiện có %d mã tăng giá, %d mã giảm giá và %d mã đứng giá trên toàn thị trường", resultMapUp.size(), resultMapDown.size(), resultMapNotChange.size());
        result[2] = String.format("Đến thời điểm này, toàn thị trường có %d mã tăng giá, %d mã giảm giá và %d mã đứng giá", resultMapUp.size(), resultMapDown.size(), resultMapNotChange.size());
        Random r = new Random();
        return result[r.nextInt(3)];


    }

}
