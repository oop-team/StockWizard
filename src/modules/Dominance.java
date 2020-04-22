package modules;

import data.Data;
import data.Session;

/***
 * Mẫu câu nói về ưu thế
 * Ví dụ: "Số mã giảm chiếm ưu thế với 102 mã, số mã tăng chỉ 74."
 */
public class Dominance extends SentenceGenerator{

    public Dominance(Session[] sessions) {
        super(sessions);
    }


    // TODO: Viết các phương thức cần thiết để xử lí dữ liệu, để xuất ra câu



    @Override
    public String example() {
        return "Số mã giảm chiếm ưu thế với 102 mã, số mã tăng chỉ 74.";
    }

    @Override
    public String generate() {
        return "Số mã giảm chiếm ưu thế với 102 mã, số mã tăng chỉ 74.";
    }
}
