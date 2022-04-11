package com.aliyunidaas.sync.internal.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

/**
 * @author hatterjiang
 */
public class HexUtilTest {
    @Test
    public void test01() {
        try {
            HexUtil.decodeHex("x");
            Assertions.fail();
        } catch (RuntimeException e) {
            Assertions.assertEquals("Odd number of characters.", e.getMessage());
        }
    }

    @Test
    public void test02() {
        try {
            HexUtil.decodeHex("xx");
            Assertions.fail();
        } catch (RuntimeException e) {
            Assertions.assertEquals("Illegal hexadecimal character x at index 0", e.getMessage());
        }
    }

    @Test
    public void test03() {
        byte[] decoded = HexUtil.decodeHex("68656c6c6f20776f726c64");
        Assertions.assertEquals("hello world", new String(decoded, StandardCharsets.UTF_8));
    }
}
