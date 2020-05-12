package cn.disruptor;

import com.lmax.disruptor.EventHandler;

/**
 * @author kelai 2020-03-23 18:18
 */
public class LogEventConsumer3 implements EventHandler<LogEvent> {


    private String data;


    public LogEventConsumer3() {
        this.data = "test";
    }

    @Override
    public void onEvent(LogEvent logEvent, long l, boolean b) throws Exception {
        System.out.println("消费者3-seq:" + l + ",bool:" + b + ",logEvent:" + logEvent.toString());
    }
}
