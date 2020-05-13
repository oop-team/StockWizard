package modules;

import data.Input;
import data.Session;
import utilities.Dictionary;
import java.util.Date;

public class Liquidity extends SentenceGenerator {

    @Override
    public String example() {
        return "Cổ phiếu cuả Công ty Cổ phần Nhựa An Phát Xanh có tính thanh khoản cao có thể đầu tư lâu dài";
    }
    @Override
    public String generate() {
    return generate();
    }

    public String generate(String Stock) {
        Session[] sessions = data[1].getSessions();
        Date today = sessions[0].getDate();
        for (Session s : sessions) {
            String ticker = s.getTicker();
            float high = s.getHigh();
            float low  = s.getLow();
            int volume = s.getVolume();
            if ((s.getDate().equals(today)) && (s.getTicker().equals(Stock))) {
                if ((volume > 10000) && (((high - low) / high) < 0.1)) {
                    return String.format("Cổ phiếu cuả %s của %s có tính thanh khoản cao có thể đầu tư lâu dài", Stock, new Dictionary().getEnterpriseName(Stock));
                }   return String.format("Cổ phiếu của %s của %s có tính thanh khoản chưa cao, cần phải xem xét để có thể đầu tư", Stock, new Dictionary().getEnterpriseName(Stock));
                }
            break;
            }

        return Stock;
    }
    public static void main(String[] args) {
        Liquidity s = new Liquidity();
        System.out.println(s.generate("AAA"));
    }
}
