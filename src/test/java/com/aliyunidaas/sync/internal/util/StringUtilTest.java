package com.aliyunidaas.sync.internal.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author hatterjiang
 */
public class StringUtilTest {
    @Test
    public void testFilterNone1CodePlane() {
        Assertions.assertNull(StringUtil.filterNone1CodePlane(null));
        Assertions.assertEquals("", StringUtil.filterNone1CodePlane(""));
        Assertions.assertEquals("test", StringUtil.filterNone1CodePlane("test"));
        Assertions.assertEquals("测试", StringUtil.filterNone1CodePlane("测试"));
        Assertions.assertEquals("测试", StringUtil.filterNone1CodePlane("测试😈"));
    }

    @Test
    public void testEquals() {
        Assertions.assertTrue(StringUtil.equals(null, null));
        Assertions.assertFalse(StringUtil.equals("", null));
        Assertions.assertFalse(StringUtil.equals(null, ""));
        Assertions.assertFalse(StringUtil.equals(null, " "));
        Assertions.assertTrue(StringUtil.equals("", ""));
    }

    @Test
    public void testSplitToList() {
        Assertions.assertNull(StringUtil.splitToList(null));
        Assertions.assertNull(StringUtil.splitToList(""));
        Assertions.assertNull(StringUtil.splitToList(",,,"));
        Assertions.assertEquals(
                Arrays.asList("127.0.0.1/32", "10.0.0.0/8"),
                StringUtil.splitToList("127.0.0.1/32,  10.0.0.0/8"));
    }
}
