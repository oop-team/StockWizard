package modules;

import data.Data;
import data.Session;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.CheckBox;

import java.util.*;

/***
 * Đếm số mã tăng, mã giảm và mã đứng giá trên một sàn
 * Ý tưởng thực hiện:
 * Duyệt các phiên giao dịch trong 2 ngày gần nhất.
 * So sánh giá đóng cửa (CLOSE) của cùng một mã cổ phiếu trong 2 ngày đó, xem nó tăng hay giảm, rồi đếm vào kết quả.
 */
public class CountUpAndDown extends SentenceGenerator {

    private final SimpleStringProperty sentence = new SimpleStringProperty("Sàn HNX hiện đang có 77 mã tăng giá, 33 mã giảm giá và 11 mã đứng");
    private CheckBox select = new CheckBox();

    public String getSentence() {
        return sentence.get();
    }

    public CheckBox getSelect() {
        return select;
    }

    public void setSelect(CheckBox checkBox) {
        this.select = checkBox;
    }


    public CountUpAndDown(Data data) {
        super(data);
    }

    @Override
    public String example() {
        return "Sàn HNX hiện đang có 77 mã tăng giá, 33 mã giảm giá và 11 mã đứng giá.";
    }

    @Override
    public String generate() {
        String stockEx = data.getStockExchange().toString();
        int[] count = count();
        String[] result = new String[3];
        result[0] = String.format("Sàn %s hiện đang có %d mã tăng giá, %d mã giảm giá và %d mã đứng giá", stockEx, count[0], count[1], count[2]);
        result[1] = String.format("Hiện có %d mã tăng giá, %d mã giảm giá và %d mã đứng giá trên sàn %s", count[0], count[1], count[2], stockEx);
        result[2] = String.format("Đến thời điểm này, sàn %s có %d mã tăng giá, %d mã giảm giá và %d mã đứng giá", stockEx, count[0], count[1], count[2]);
        Random r = new Random();
        return result[r.nextInt(3)];
    }

    /***
     *
     * @return [countUp, countDown, countStand]
     */
    private int[] count() {
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