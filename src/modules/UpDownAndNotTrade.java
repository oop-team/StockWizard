package modules;

import data.Data;
import data.Session;
import utilities.Counter;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class UpDownAndNotTrade extends SentenceGenerator {

    private Session[] sessions;
    @Override
    public String example() {
        return "Hiện có 153 mã tăng giá, 10 mã giảm giá và 3 mã chưa có giao dịch.";
    }

    @Override
    public String generate() {
        Counter counter = new Counter(this.sessions);
        int[] countHNX = counter.countUpDownAndNotTrade(data[0]);
        int[] countHSX = counter.countUpDownAndNotTrade(data[1]);
        int[] countUPCOM = counter.countUpDownAndNotTrade(data[2]);

        int[] count = new int[3];
        for(int i = 0; i < 3; i++){
            count[i] = countHNX[i] + countHSX[i] + countUPCOM[i];
        }
        return String.format("Hiện có %d mã tăng giá, %d mã giảm giá và %d mã chưa có giao dịch.", count[0], count[1], count[2]);
    }
}