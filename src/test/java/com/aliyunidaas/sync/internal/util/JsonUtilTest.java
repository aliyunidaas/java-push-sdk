package com.aliyunidaas.sync.internal.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author hatterjiang
 */
public class JsonUtilTest {
    static class TestStruct {
        private int a;
        private long b;
        private Integer c;
        private Long d;
        private String e;
    }

    @Test
    public void testFromJson01() {
        TestStruct testStruct = JsonUtil.fromJson("", TestStruct.class);
        Assertions.assertNull(testStruct);
    }

    @Test
    public void testFromJson02() {
        TestStruct testStruct = JsonUtil.fromJson("{}", TestStruct.class);
        Assertions.assertNotNull(testStruct);
        Assertions.assertEquals(0, testStruct.a);
        Assertions.assertEquals(0, testStruct.b);
        Assertions.assertNull(testStruct.c);
        Assertions.assertNull(testStruct.d);
        Assertions.assertNull(testStruct.e);
    }

    @Test
    public void testFromJson03() {
        TestStruct testStruct = JsonUtil.fromJson("{\"a\": 1, \"b\": 2, \"c\": 3, \"d\": 4, \"e\": \"hello world\"}", TestStruct.class);
        Assertions.assertNotNull(testStruct);
        Assertions.assertEquals(1, testStruct.a);
        Assertions.assertEquals(2, testStruct.b);
        Assertions.assertEquals(3, testStruct.c);
        Assertions.assertEquals(4, testStruct.d);
        Assertions.assertEquals("hello world", testStruct.e);
    }
}
