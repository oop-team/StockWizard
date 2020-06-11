package modules;

import data.Data;
import data.Input;
import data.Session;

import java.text.NumberFormat;
import java.util.Date;

import java.util.Locale;

/**
 * Tóm tắt tình hình của CTCP Sơn Địa Ốc (AAV)
 *
 * @author Hieu
 */
public class SummaryAAV extends SentenceGenerator {
    @Override
    public String example() {
        return "So với ngày hôm qua, giá cổ phiếu  tăng: 15%, tổng số tiền giao dịch: 150.000 VNĐ, tổng khối lượng giao dịch: 200 cổ phiếu";
    }

    @Override
    public String generate() {
        double[] result = calc(Input.inputData[3].getSessions());
        NumberFormat numberFormat = NumberFormat.getInstance(new Locale("vi", "VI"));
        String res = "";
        if (result[0] > 0) {
            res = String.format("So với ngày hôm qua, giá cổ phiếu AAV tăng: %.2f%%, tổng số tiền giao dịch: %s VNĐ, " +
                    "tổng khối lượng giao dịch: %d cổ phiếu", result[0], numberFormat.format(result[2]), (long) result[1]);
        } else if (result[0] < 0) {
            res = String.format("So với ngày hôm qua, giá cổ phiếu AAV giảm: %.2f%%, tổng số tiền giao dịch: %s VNĐ, " +
                    "tổng khối lượng giao dịch: %d cổ phiếu", -result[0], numberFormat.format(result[2]), (long) result[1]);
        } else {
            res = String.format("So với ngày hôm qua, giá cổ phiếu AAV không đổi, tổng số tiền giao dịch: %s VNĐ, " +
                    "tổng khối lượng giao dịch: %d cổ phiếu", numberFormat.format(result[2]), (long) result[1]);
        }
        return res;
    }

    private double[] calc(Session[] sessions) {
        double[] result = new double[3];
        Date Today = sessions[0].getDate();
        Date Tomorrow = null;

        // Tìm ngày hôm qua
        for (Session s : sessions) {
            if (!Today.equals(s.getDate())) {
                Tomorrow = s.getDate();
                break;
            }
        }
        /* Tính toán: result[0]: % tăng giảm
                      result[1]: khối lượng giao dịch
                      result[2]: tổng tiền
         */
        for (Session s : sessions) {
            if (s.getTicker().equals("AAV")) {
                if (s.getDate().equals(Today)) {
                    if (s.getClose() == 0) break; // nếu ngày hôm qua ko giao dịch thì break
                    result[0] = s.getClose();
                    result[1] = s.getVolume();
                    result[2] = result[0] * result[1];
                } else if (s.getDate().equals(Tomorrow)) {
                    result[0] = (result[0] - s.getClose()) / result[0] * 100;
                    break;
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        Input.updateDataFromLocal("res/sample/data/CafeF.SolieuGD.Upto27042020.zip");
        System.out.println(new SummaryAAV().generate());
    }
}
