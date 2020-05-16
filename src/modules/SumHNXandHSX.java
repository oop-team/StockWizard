package modules;

import data.Session;
import java.util.Date;
import java.util.Random;

public class SumHNXandHSX extends SentenceGenerator {

    @Override
    public String example() {
        return "Thanh khoản vào thị trường không quá thấp, HSX đạt 1.170 tỷ đồng và HNX đạt hơn 440 tỷ đồng.";
    }

    @Override
    public String generate() {
        float[] sum = new float[2];
        for (int i = 0; i < 1; i++) {
            Session[] sessions = data[i].getSessions();
            Date today = sessions[0].getDate();

            for (Session s : sessions) {
                if (s.getDate().equals(today))
                    sum[i] += s.getClose() * s.getVolume();
            }
        }
        int hnx = ((int) sum[0] + 1) / 1000000000;
        int hsx = ((int) sum[1] + 1) / 1000000000;

        String[] ret = new String[2];
        ret[0] = String.format("Hôm nay, thanh khoản vào thị trường không quá thấp, HSX đạt %d tỷ đồng và HNX đạt hơn %d tỷ đồng",
                hsx, hnx);
        ret[1] = String.format("Hết phiên giao dịch ngày hôm nay,thanh khoản vào HSX đạt %d tỷ đồng và HNX đạt hơn %d tỷ đồng",
                hsx, hnx);
        return ret[new Random().nextInt(2)];
    }
}
