package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Dictionary {
    /**
     * Tên doanh nghiệp ứng với mã cổ phiếu => Tân
     *
     * Ví dụ:
     * input: "ACB"
     * output: Ngân hàng TMCP Á Châu
     */
    public String getEnterpriseName(String ticker){
        try{
            Scanner scanner = new Scanner(new File("res/general_information/enterprise name.txt"));
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] str = line.split("\t", 2);
                if (str[0].equals(ticker)){
                    return str[1];
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Mã cổ phiếu không tồn tại");
        return null;
    }

    /**
     * Input:
     * Tên rổ:
     * VN30, VN100, VNIndex, BlueChip, FTSE_ETF, VNM_ETF
     * (từ khoá: search từ "rổ" trong file classified.txt của thầy để tìm các rổ)
     *
     * Hoặc tìm ra các mã cổ phiếu theo nhóm ngành:
     * "Dầu khí", "Viễn thông", ...
     *
     * Output:
     * Danh sách các mã cổ phiếu tương ứng
     *
     */
    public String[] getTickerBy(String group){
        return null;
    }

    public static void main(String[] args) {
        Dictionary d = new Dictionary();
        System.out.println(d.getEnterpriseName("AAM"));
    }
}
