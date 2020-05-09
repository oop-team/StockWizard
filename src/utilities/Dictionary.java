package utilities;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Dictionary {
    public static final String[] INDUSTRY_GROUPS = {
            "Bất động sản",
            "Cao su",
            "Chứng khoán",
            "Công nghệ viễn thông",
            "Dược phẩm - Y tế - Hoá chất",
            "Dầu khí",
            "Dịch vụ - Du lịch",
            "Dịch vụ công ích",
            "Giáo dục",
            "Hàng không",
            "Khoáng sản",
            "Ngân hàng  - Bảo hiểm",
            "Nhựa - Bao bì",
            "Năng lượng - Điện - Khí",
            "Phân bón",
            "Sản xuất - Kinh doanh",
            "Thuỷ sản",
            "Thép",
            "Thương mại",
            "Thực phẩm",
            "Vận tải - Cảng - Taxi",
            "Vật liệu xây dựng",
            "Xây dựng",
            "Đầu tư phát triển",
            "Đầu tư xây dựng",
    };

    public static final String[] STOCK_BASKETS = {
            "VN30", "HNX30", "BlueChip", "HOT", "PHÒNG THỦ"
    };

    /**
     * Tên doanh nghiệp ứng với mã cổ phiếu => Tân
     *
     * Ví dụ:
     * input: "ACB"
     * output: Ngân hàng TMCP Á Châu
     */
    public String getEnterpriseName(String ticker){
        // TODO:
        return null;
    }

    /**
     *
     * @param groupName tên nhóm ngành
     * @return danh sách mã cổ phiếu
     */
    public String[] getTickersByIndustryGroup(String groupName) {
        try{
            Scanner scanner = new Scanner(new File("res/general_information/nhomnganh/" + groupName + ".txt"));
            int numberOfTicker = Integer.parseInt(scanner.nextLine());
            String[] ret = new String[numberOfTicker];
            for(int i = 0; i < numberOfTicker; i++){
                ret[i] = scanner.nextLine();
            }
            return ret;
        }catch (FileNotFoundException e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param basketName tên rổ cổ phiếu
     * @return danh sách mã cổ phiếu trong rổ tương ứng
     */
    public String[] getTickersByStockBasket(String basketName){
        try {
            BufferedReader ReadFile= null;
            FileReader fr=null;
            fr= new FileReader("res/general_information/rổ cổ phiếu.txt");
            ReadFile= new BufferedReader(fr);
            String line= ReadFile.readLine();
            String[] tickers = null;
            while (line!=null) {
                tickers = line.split("/");
                if (basketName == tickers[0]) // tickers[0] lưu tên rổ
                    break;
                line = ReadFile.readLine();
            }
            return Arrays.copyOfRange(tickers, 1, tickers.length);

        }catch(IOException e){
            e.printStackTrace();
            return null;
        }
    }

    // Ví dụ cách sử dụng lớp Dictionary
    public static void main(String[] args) {
        Dictionary dict = new Dictionary();

        // Duyệt tất cả các rổ
        for(String basketName : STOCK_BASKETS){
            String[] tickers = dict.getTickersByStockBasket(basketName);
            System.out.println("- Rổ " + basketName + " gồm: ");
            for(var ticker : tickers){
                System.out.print(ticker + ", ");
            }
            System.out.println();
        }

        System.out.println();

        // Duyệt tất cả các nhóm ngành
        for(String groupName : INDUSTRY_GROUPS){
            String[] tickers = dict.getTickersByIndustryGroup(groupName);
            System.out.println("- Nhóm " + groupName + " gồm: ");
            for(var ticker : tickers){
                System.out.print(ticker + ", ");
            }
            System.out.println();
        }
    }
}
