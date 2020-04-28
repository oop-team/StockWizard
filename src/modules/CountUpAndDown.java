package modules;

import data.Data;
import data.Session;
import data.StockExchange;

import java.util.*;

/***
 * Đếm số mã tăng, mã giảm và mã đứng giá trên toàn thị trường
 * Ý tưởng thực hiện:
 * Duyệt các phiên giao dịch trong 2 ngày gần nhất.
 * So sánh giá đóng cửa (CLOSE) của cùng một mã cổ phiếu trong 2 ngày đó, xem nó tăng hay giảm, rồi đếm vào kết quả.
 */
public class CountUpAndDown extends SentenceGenerator{

    @Override
    public String example() {
        return "Toàn thị trường hiện đang có 77 mã tăng giá, 33 mã giảm giá và 11 mã đứng giá.";
    }

    @Override
    public String generate() {
        int[] countHNX = count(data[0]);
        int[] countHSX = count(data[1]);
        int[] countUPCOM = count(data[2]);

        int[] count = new int[3];
        for(int i = 0; i < 3; i++){
            count[i] = countHNX[i] + countHSX[i] + countUPCOM[i];
        }

        String[] result = new String[3];
        result[0] = String.format("Toàn thị trường hiện đang có %d mã tăng giá, %d mã giảm giá và %d mã đứng giá", count[0], count[1], count[2]);
        result[1] = String.format("Hiện có %d mã tăng giá, %d mã giảm giá và %d mã đứng giá trên toàn thị trường", count[0], count[1], count[2]);
        result[2] = String.format("Đến thời điểm này, toàn thị trường có %d mã tăng giá, %d mã giảm giá và %d mã đứng giá", count[0], count[1], count[2]);
        Random r = new Random();
        return result[r.nextInt(3)];
    }

    /***
     *
     * @return [countUp, countDown, countStand]
     */
    private int[] count(Data data) {
        int[] ret = new int[3]; // Lưu kết quả return

        Map<String, Float> map = new HashMap<>(); // Lưu danh sách các mã cổ phiếu

        Session[] sessions = data.getSessions();
        Date nearestDate = sessions[0].getDate(); // Ngày gần nhất

        for (Session s : sessions) {
            // Chỉ duyệt trong 2 ngày gần nhất
            long diffTime = nearestDate.getTime() - s.getDate().getTime();
            int diffDay = (int) (diffTime / (1000 * 60 * 60 * 24));
            if (diffDay > 1) {
                break;
            }

            // Xử lí tính toán
            String ticker = s.getTicker();
            float close = s.getClose();
            if (diffDay == 0) {
                map.put(ticker, s.getClose());
            } else {
                if (map.containsKey(ticker)) {
                    float newClose = map.get(ticker);
                    if (newClose - close > 0) {
                        ret[0] += 1;
                    } else if (newClose - close < 0) {
                        ret[1] += 1;
                    } else {
                        ret[2] += 1;
                    }
                }
            }
        }

        return ret;
    }


}