package com.aliyunidaas.sync.internal.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author hatterjiang
 */
public class ExceptionUtilTest {
    @Test
    public void test01() {
        String stacktrace = ExceptionUtil.printStacktrace(new RuntimeException());
        Assertions.assertEquals("java.lang.RuntimeException", stacktrace.split("\n")[0].trim());
    }
}
