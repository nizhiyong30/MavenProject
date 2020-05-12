package cn.disruptor;

import com.lmax.disruptor.EventHandler;

/**
 * @author kelai 2020-03-23 18:19
 */
public class LogEventConsumer4 implements EventHandler<LogEvent> {

    @Override
    public void onEvent(LogEvent logEvent, long l, boolean b) throws Exception {
        System.out.println("消费者4-seq:" + l + ",bool:" + b + ",logEvent:" + logEvent.toString());
    }
}
