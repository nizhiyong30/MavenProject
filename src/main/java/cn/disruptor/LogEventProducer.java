package cn.disruptor;

import com.lmax.disruptor.RingBuffer;

import java.util.Date;

/**
 * @author kelai 2020-03-23 18:12
 */
public class LogEventProducer {
    private RingBuffer<LogEvent> ringBuffer;

    public LogEventProducer(RingBuffer<LogEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void onData(long logId, String content, Date date){
        //RingBuffer类似一个队列，获取下一个空闲的序号
        long seq = ringBuffer.next();
        LogEvent logEvent = ringBuffer.get(seq);
        logEvent.setLogId(logId);
        logEvent.setContent(content);
        logEvent.setDate(date);
        //发布事件
        System.out.println("发布事件:");
        ringBuffer.publish(seq);
    }
}
