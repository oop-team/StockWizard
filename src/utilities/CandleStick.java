package utilities;

enum CandleType {
    NONE,
    Black_Body,
    Doji,
    Dragonfly_Doji,
    Hammer,
    Inverted_Hammer,
    Long_Upper_Shadow,
    Marubozu,
    Shaven_Head,
    White_Body,
    Gravestone_Doji,
    Hanging_Man,
    Shooting_Star,
    Long_Lower_Shadow,
    Spinning_Top,
    Shaven_Bottom
}

public class CandleStick {

    private CandleType type;

    public CandleStick() {
        type = CandleType.NONE;
    }

    public CandleStick(int open, int high, int low, int close) {
        type = CandleType.NONE;
        init(open, high, low, close);
        System.out.println(type.toString());
    }

    public void init(int open, int high, int low, int close) {
        if (approximatelyEqual(open, close)) {
            type = CandleType.Doji;
        }
        else if (open < close) {
            type = CandleType.White_Body;
        }
        else if (open > close) {
            type = CandleType.Black_Body;
        }
    }

    public CandleType getType() {
        return type;
    }

    public static boolean approximatelyEqual(float desiredValue, float actualValue) {
        return approximatelyEqual(desiredValue, actualValue, 10); // default 10% of value higher
    }

    public static boolean approximatelyEqual(float desiredValue, float actualValue, float tolerancePercentage) {
        float diff = Math.abs(desiredValue - actualValue);
        // get value to equal from value higher.
        float tolerance = (desiredValue > actualValue) ? tolerancePercentage/100 * desiredValue : tolerancePercentage/100 * actualValue;
        return diff < tolerance;
    }

}
