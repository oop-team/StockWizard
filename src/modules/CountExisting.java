package modules;

import utilities.Counter;

import java.util.Random;

public class CountExisting extends SentenceGenerator{
    @Override
    public String example() {
        return "Tính đến thời điểm này toàn thị trường có 135 mã giảm trong khi chỉ có 130 mã tăng và hơn 130 mã đứng giá.";
    }

    @Override
    public String generate() {
        Counter counter = new Counter();
        int[] countHNX = counter.count(data[0].getSessions());
        int[] countHSX = counter.count(data[1].getSessions());
        int[] countUPCOM = counter.count(data[2].getSessions());

        int[] count = new int[3];
        for(int i = 0; i < 3; i++){
            count[i] = countHNX[i] + countHSX[i] + countUPCOM[i];
        }


        String[] result = new String[3];
        result[0] = String.format("Tính đến thời điểm này toàn thị trường có %d mã giảm trong khi chỉ có %d mã tăng và hơn %d mã đứng giá.", count[1], count[0], count[2]);
        result[1] = String.format("Tính đến thời điểm này chỉ có %d mã tăng và hơn %d mã đứng giá, còn lại là %d mã giảm.", count[0], count[2], count[1]);
        result[2] = String.format("Trong khi có hơn %d mã đứng giá thì chỉ có %d mã tăng giá và %d mã giảm giá ở thời điểm này", count[2], count[0], count[1]);
        Random r = new Random();
        return result[r.nextInt(3)];
    }
}
