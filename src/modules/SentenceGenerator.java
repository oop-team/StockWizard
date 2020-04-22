package modules;

import data.Data;
import data.Session;

public abstract class SentenceGenerator {

    protected Data data;

    public SentenceGenerator(Data data){
        this.data = data;
    }

    /***
     *
     * @return Câu mẫu (để người dùng chọn)
     */
    public String example(){
        return "Đây là câu mẫu";
    }

    /***
     *
     * @return Tạo ra câu theo mẫu, dựa vào dữ liệu đã có
     */
    public String generate(){
        return "Đây là câu được tạo ra";
    }
}
