package utilities;

import data.Session;

/**
 * Đếm số mã tăng, giảm, đứng giá, không giao dịch => Nhật
 * <p>
 * input: Data
 * output: số mã tăng, giảm, đứng giá, không giao dịch trong ngày gần nhất
 * </p>
 */
public class Counter {
    private Session[] sessions;
    private int[] result;


    public Counter(Session[] sessions) {
        this.sessions = sessions;
    }

    public int[] getResult() {
        return result;
    }

    public void count() {
        //TODO: result = ...
    }


}
