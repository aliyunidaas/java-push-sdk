package com.aliyunidaas.sync.event.callback;

import com.aliyunidaas.sync.event.callback.objects.EventDataResponse;
import com.aliyunidaas.sync.event.constants.SyncEventConstants;
import com.aliyunidaas.sync.event.context.EventContext;

/**
 * 测试连接回调
 *
 * @author hatterjiang
 */
public interface TestCallback {

    /**
     * 测试连接是用户在配置完后进行测试的操作，默认返回成功
     *
     * @see SyncEventConstants#COMMON_TEST
     */
    default EventDataResponse onTest(EventContext eventContext) {
        eventContext.getLoggerOptional().ifPresent(logger ->
                logger.info("Received test event: " + eventContext.getEventData().getEventId()));
        return EventDataResponse.newSuccessEventDataResponse();
    }
}
