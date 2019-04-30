package cn.test;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by nizy on 2019/1/9.
 */
public class Test {

    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - 1);
        Date statisticDate = calendar.getTime();
        System.out.println(statisticDate);

    }

    public static boolean isPrime(Long num) {
        Long i;
        for (i = 2l; i < num - 1; i++) {
            if (num % i == 0) {
                break;
            }
        }
        if ((i == num - 1) || (num == 2)) {
            return true;
        } else {
            return false;
        }
    }





}
