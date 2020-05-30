package modules;

import data.Input;
import data.Session;
import utilities.CandleStick;
import utilities.CandleType;
import utilities.Filter;

public class CountMarubozu extends SentenceGenerator{
    @Override
    public String example() {
        return "Hôm nay có 8 marubozu trong 50 cây nến";
    }

    @Override
    public String generate() {
        Filter f = new Filter();
        Session[] sessions = Input.inputData[3].getSessions();
        sessions = f.filter(sessions, sessions[0].getDate(), sessions[0].getDate());
        int count = 0;
        for (var s : sessions) {
            CandleStick candleStick = new CandleStick(s.getOpen(), s.getHigh(), s.getLow(), s.getClose());
            if (candleStick.getType() == CandleType.Marubozu) {
                count++;
            }
        }
        int countAll = sessions.length;
        return String.format("Hôm nay có %d morubozu trong %d cây nến", count, countAll);
    }
}
