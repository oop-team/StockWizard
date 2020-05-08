package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Dictionary {
    public static final String[] industryGroups = {
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

    public static final String[] stockBasket = {
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
}
