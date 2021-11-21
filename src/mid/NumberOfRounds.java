package mid;

/**
 * Created by luozhenzhao on 2021/9/2
 * description:
 */
public class NumberOfRounds {
    public static void main(String[] args) {
        System.out.println(numberOfRounds("00:06", "00:11"));
    }

//    public static int numberOfRounds(String startTime, String finishTime) {
//        String[] start = startTime.split(":");
//        int startHour = new Integer(start[0]);
//        int startMin = new Integer(start[1]);
//        String[] finish = finishTime.split(":");
//        int finishHour = new Integer(finish[0]);
//        int finishMin = new Integer(finish[1]);
//        int minsub = finishMin - startMin;
//        if (startHour == finishHour && minsub > 0 && minsub < 15) {
//            return 0;
//        }
//        if (startMin > 45) {
//            startMin = 0;
//            startHour += 1;
//        } else if (startMin > 30) {
//            startMin = 45;
//        } else if (startMin > 15) {
//            startMin = 30;
//        } else if (startMin > 0){
//            startMin = 15;
//        }
//
//        if (finishMin < 15) {
//            finishMin = 0;
//        } else if (finishMin < 30) {
//            finishMin = 15;
//        } else if (finishMin < 45) {
//            finishMin = 30;
//        } else {
//            finishMin = 45;
//        }
//
//        int sumTail = (60 - startMin) / 15 + finishMin / 15;
//        int addHour = startHour == finishHour ? (startMin > finishMin ? 24 : 0) : (startHour > finishHour ? 24 : 0);
//        int sumMain = (addHour + finishHour - startHour - 1) * 4;
//        return sumMain + sumTail;
//    }

    public static int numberOfRounds(String startTime, String finishTime) {
        // startTime和finishTime距离00:00的分钟数
        int start = new Integer(startTime.split(":")[0]) * 60 + new Integer(startTime.split(":")[1]);
        int finish = new Integer(finishTime.split(":")[0]) * 60 + new Integer(finishTime.split(":")[1]);

        if (finish < start) {
            finish = finish + 60 * 24;
        }
        finish = finish / 15 * 15;
        int round = (finish - start) / 15;
        return Math.max(round, 0);
    }
}
