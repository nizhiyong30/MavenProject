package cn.test;

import com.mogujie.service.benchmark.api.BenchmarkService;
import com.mogujie.tesla.client.api.TeslaServiceConsumerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Date;
import java.util.ServiceLoader;

/**
 * Created by nizy on 2019/1/9.
 */
public class Test {

    public static void main(String[] args) throws Exception{
        final BenchmarkService service = TeslaServiceConsumerFactory.getTeslaServiceConsumer(BenchmarkService.class);
        String result = service.echoService("hello tesla", 0);
        System.out.println(result);
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
