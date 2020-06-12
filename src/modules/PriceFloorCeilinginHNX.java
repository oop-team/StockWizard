//package modules;
//
//import data.Data;
//import data.Input;
//import data.Session;
//import data.StockExchange;
//import utilities.Counter;
//import utilities.SpecificCount;
//
//import java.util.*;
//
//public class PriceFloorCeilinginHNX extends SentenceGenerator {
//    @Override
//    public String example() {
//        return "Hôm nay sàn HNX có 30 mã giảm sàn 20 mã tăng trần";
//    }
//
//    @Override
//    public String generate() {
//        SpecificCount counter = new SpecificCount();
//        counter.count(data[0].getSessions());
//        Map<String, Float> resultUp = new HashMap<>();
//        resultUp= counter.getResultMapUp();
//        Map<String, Float> resultDown = new HashMap<>();
//        resultDown= counter.getResultMapDown();
//
//
//    }
//
//}
