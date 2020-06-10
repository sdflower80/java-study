package sdflower80.study.any;

import java.util.Date;

public class DateUtils {

    public static Date create(long time) {
        return new Date(time);
    }
    public static void main(String[] args) {
        Date date = create(1585692000000L);
        System.out.println(date);

        System.out.println(System.currentTimeMillis());
    }
}
