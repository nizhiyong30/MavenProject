package cn.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * @author kelai 2020-03-23 18:12
 */
public class LogEventFactory implements EventFactory<LogEvent> {

    @Override
    public LogEvent newInstance() {
        System.out.println("新建LogEvent数据.....");
        return new LogEvent();
    }
}
