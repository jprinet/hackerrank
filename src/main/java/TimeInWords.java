import java.util.HashMap;

class TimeInWords {

    static java.util.Map<Integer, String> TRANSLATIONS = new HashMap<>();
    static String ONE_MINUTE_TO = "one minute to ";
    static String ONE_MINUTE_PAST = "one minute past ";
    static String QUARTER_TO = "quarter to ";
    static String QUARTER_PAST = "quarter past ";
    static String HALF_PAST = "half past ";
    static String MINUTES_TO = " minutes to ";
    static String MINUTES_PAST = " minutes past ";
    static String O_CLOCK = " o' clock";

    static String timeInWords(int h, int m) {
        String timeAsStr = "";

        init();

        if (m == 0) {
            timeAsStr = TRANSLATIONS.get(h) + O_CLOCK;
        } else if (m == 30) {
            timeAsStr = HALF_PAST + TRANSLATIONS.get(h);
        } else if (m > 30) {
            if (m != 59) {
                if (m == 45) {
                    timeAsStr = QUARTER_TO + TRANSLATIONS.get(h + 1);
                } else {
                    timeAsStr = TRANSLATIONS.get(60 - m) + MINUTES_TO + TRANSLATIONS.get(h + 1);
                }
            } else {
                timeAsStr = ONE_MINUTE_TO + TRANSLATIONS.get(h + 1);
            }
        } else {
            if (m != 1) {
                if (m == 15) {
                    timeAsStr = QUARTER_PAST + TRANSLATIONS.get(h);
                } else {
                    timeAsStr = TRANSLATIONS.get(m) + MINUTES_PAST + TRANSLATIONS.get(h);
                }
            } else {
                timeAsStr = ONE_MINUTE_PAST + TRANSLATIONS.get(h);
            }
        }

        return timeAsStr;
    }

    static void init() {
        TRANSLATIONS.put(1, "one");
        TRANSLATIONS.put(2, "two");
        TRANSLATIONS.put(3, "three");
        TRANSLATIONS.put(4, "four");
        TRANSLATIONS.put(5, "five");
        TRANSLATIONS.put(6, "six");
        TRANSLATIONS.put(7, "seven");
        TRANSLATIONS.put(8, "eight");
        TRANSLATIONS.put(9, "nine");
        TRANSLATIONS.put(10, "ten");
        TRANSLATIONS.put(11, "eleven");
        TRANSLATIONS.put(12, "twelve");
        TRANSLATIONS.put(13, "thirteen");
        TRANSLATIONS.put(14, "fourteen");
        TRANSLATIONS.put(15, "fiveteen");
        TRANSLATIONS.put(16, "sixteen");
        TRANSLATIONS.put(17, "seventeen");
        TRANSLATIONS.put(18, "eighteen");
        TRANSLATIONS.put(19, "nineteen");
        TRANSLATIONS.put(20, "twenty");
        TRANSLATIONS.put(21, "twenty one");
        TRANSLATIONS.put(22, "twenty two");
        TRANSLATIONS.put(23, "twenty three");
        TRANSLATIONS.put(24, "twenty four");
        TRANSLATIONS.put(25, "twenty five");
        TRANSLATIONS.put(26, "twenty six");
        TRANSLATIONS.put(27, "twenty seven");
        TRANSLATIONS.put(28, "twenty eight");
        TRANSLATIONS.put(29, "twenty nine");
    }
}
