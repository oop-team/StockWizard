package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
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
    public String[] getTickerBy(String group) throws FileNotFoundException {
        return getTicker("Nhomnganh\\" + group + ".txt");
    }

    public String[] getTicker(String fileString) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileString));
        int numberOfTicker = Integer.parseInt(scanner.nextLine());
        String[] ret = new String[numberOfTicker];
        for(int i = 0; i < numberOfTicker; i++){
            ret[i] = scanner.nextLine();
        }
        return ret;
    }

    public static void main(String[] args) throws IOException{
        Dictionary dictionary = new Dictionary();
        String[] ret = dictionary.getTickerBy("Công nghệ viễn thông");
        for(String s : ret){
            System.out.println(s);
        }
    }

}
