package modules;

import data.Session;
import utilities.Counter;
import utilities.SpecificCount;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class UpDownAndNotTrade extends SentenceGenerator {
    private Session[] sessions;
    @Override
    public String example() {
        return " Trên sàn HNX đang có 77 mã tăng giá, 33 mã giảm giá và 11 mã đứng giá.";
    }

    @Override
    public String generate() {
        SpecificCount countHNX = new SpecificCount();
        Map<String, Float> resultMapUp = new HashMap<>();
        Map<String, Float> resultMapDown = new HashMap<>();
        Map<String, Float> resultMapNotChange = new HashMap<>();
        Map<String, Float> resultMapNotTrade = new HashMap<>();

        countHNX.count(data[0].getSessions());
        resultMapUp=countHNX.getResultMapUp();
        resultMapDown=countHNX.getResultMapDown();
        resultMapNotChange=countHNX.getResultMapNotChange();
        resultMapNotTrade=countHNX.getResultMapNotTrade();

        String[] result = new String[3];
        result[0] = String.format("Toàn thị trường hiện đang có %d mã tăng giá, %d mã giảm giá và %d mã đứng giá", resultMapUp.size(), resultMapDown.size(),resultMapNotTrade.size());
        result[1] = String.format("Hiện có %d mã tăng giá, %d mã giảm giá và %d mã đứng giá trên toàn thị trường", resultMapUp.size(), resultMapDown.size(), resultMapNotTrade.size());
        result[2] = String.format("Đến thời điểm này, toàn thị trường có %d mã tăng giá, %d mã giảm giá và %d mã đứng giá", resultMapUp.size(), resultMapDown.size(), resultMapNotTrade.size());
        Random r = new Random();
        return result[r.nextInt(3)];

//    @Override
//    public String example() {
//        return "Hiện có 153 mã tăng giá, 10 mã giảm giá và 3 mã chưa có giao dịch.";
//    }
//
//    @Override
//    public String generate() {
//        Counter counter = new Counter();
//        int[] countHNX = counter.count(data[0].getSessions());
//        int[] countHSX = counter.count(data[1].getSessions());
//        int[] countUPCOM = counter.count(data[2].getSessions());
//
//        int[] count = new int[4];
//        for(int i = 0; i < 4; i++){
//
////        System.out.println(countHNX[0]);
////        System.out.println(countHSX[0]);
////        System.out.println(countUPCOM[0]);
////        int[] count = new int[3];
////        for(int i = 0; i < 3; i++){
//
//            count[i] = countHNX[i] + countHSX[i] + countUPCOM[i];
//        }
//        String[] ret = new String[3];
//        ret[0] = String.format("Hiện có %d mã tăng giá, %d mã giảm giá và %d mã chưa có giao dịch.", count[0], count[1], count[3]);
//        ret[1] = String.format("Toàn thị trường có %d mã tăng, %d mã giảm và %d mã không giao dịch", count[0], count[1], count[3]);
//        ret[2] = String.format("Số mã tăng: %d mã, số mã giảm: %d mã, số mã không giao dịch: %d mã", count[0], count[1], count[3]);
//        return ret[new Random().nextInt(3)];
   }
}