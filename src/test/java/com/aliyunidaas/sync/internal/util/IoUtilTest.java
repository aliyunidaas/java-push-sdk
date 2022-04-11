package com.aliyunidaas.sync.internal.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author hatterjiang
 */
public class IoUtilTest {
    @Test
    public void test01() throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(new String("hello world").getBytes(StandardCharsets.UTF_8));
        byte[] bs = IoUtil.readAll(bais);
        Assertions.assertEquals("hello world", new String(bs, StandardCharsets.UTF_8));
    }
}
