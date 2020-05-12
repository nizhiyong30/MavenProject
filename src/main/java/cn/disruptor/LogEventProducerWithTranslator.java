package cn.disruptor;

import com.lmax.disruptor.EventTranslatorVararg;
import com.lmax.disruptor.RingBuffer;

import java.util.Date;

/**
 * @author kelai 2020-03-23 18:13
 */
public class LogEventProducerWithTranslator {
    private EventTranslatorVararg eventTranslatorVararg = new EventTranslatorVararg<LogEvent>() {

        @Override
        public void translateTo(LogEvent logEvent, long l, Object... objects) {
            logEvent.setLogId((Long) objects[0]);
            logEvent.setContent((String)objects[1]);
            logEvent.setDate((Date)objects[2]);
        }
    };

    private RingBuffer<LogEvent> ringBuffer;

    public LogEventProducerWithTranslator(RingBuffer<LogEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void onData(long logId, String content, Date date){
        ringBuffer.publishEvent(eventTranslatorVararg,logId,content,date);
    }
}
