package com.aliyunidaas.sync.event.runner;

import com.aliyunidaas.sync.event.bizdata.UserInfo;
import com.aliyunidaas.sync.event.callback.UserCallback;
import com.aliyunidaas.sync.event.callback.impl.DefaultEventDataCallbackImpl;
import com.aliyunidaas.sync.event.callback.objects.EventDataResponse;
import com.aliyunidaas.sync.event.context.EventContext;
import com.aliyunidaas.sync.event.objects.ErrorResponseObject;
import com.aliyunidaas.sync.event.objects.RequestObject;
import com.aliyunidaas.sync.event.objects.ResponseObject;
import com.aliyunidaas.sync.event.objects.SuccessResponseObject;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * @author hatterjiang
 */
public class EventDataRunnerTest {
    static final String APP_ID = "app_mi2eu5kkg2onbpmsggd7hgtrzq";
    static final String ENCRYPT_KEY = "c875aa2355889a904827c6924f2faa639cac3ebadff4e619b6a33cfe223e24b6";
    static final String JWK_JSON = "{\"keys\": [{\"kty\": \"RSA\",\"e\": \"AQAB\",\"use\": \"sig\",\"kid\": "
            + "\"KEY8VxTKYXwisMyfCAyMTQsux5pSbkZgygSy\",\"n\": "
            + "\"nYiY2111hHpFoc9Td8mPgzBdvK4iHjRkMZ2LWPoQyEciBkp5FpxBg05tag-nxioVHVyRps"
            + "TXM2bvYUP-SGgVByYd5OGdF80AGFOsndv445ytEZ50j0YFmLGRuc"
            + "-rD9QPASKURxr6Suwpr2TYxxZZ0bZhxLnkZtXw4HDswzao9UAry6IY5KvTWSl4L8tVwgZ06v"
            + "y244LZSqCS8W4cZQbYi4wImDa09TzUkQwrIuL0JKNtuZ_FJyqSLK2tyierRmBKwLhqOIY0yK"
            + "cuMbNyyjea9q5sneWHNS7EMVvFtLDBZz3AyChgSTsZGfq96KPRV0MJ37oN8s6MYQCKlaRDgq"
            + "huNQ\"}]}";
    static final String EVENT1 =
            "eyJraWQiOiJLRVk4VnhUS1lYd2lzTXlmQ0F5TVRRc3V4NXBTYmtaZ3lnU3kiLCJ0eXAiOiJKV1QiLCJhbGciOiJS"
                    + "UzI1NiJ9.eyJpc3MiOiJ1cm46YWxpYmFiYTppZGFhczphcHA6ZXZlbnQiLCJzdWIiOiJpZGFhc18yd"
                    + "zR2bWZyeW54aTdhZTI1bXQ3azVlNG9waSIsImF1ZCI6ImFwcF9taTJldTVra2cyb25icG1zZ2dkN2h"
                    + "ndHJ6cSIsImV4cCI6MTY0ODYyNzUwOCwiaWF0IjoxNjQ4NjI1NzA4LCJqdGkiOiJHUlVPSVIxOXkyM"
                    + "1FfUV9jb3oxS2N3IiwiZGF0YUVuY3J5cHRlZCI6dHJ1ZSwiY2lwaGVyRGF0YSI6ImV5SmhiR2NpT2l"
                    + "Ka2FYSWlMQ0psYm1NaU9pSkJNalUyUjBOTkluMC4udmxQcFZWcFFOSklUc0pOZy5rNVpyQkY1Z2VRO"
                    + "DFBdktsQkhybWdzQ2dvTTNJWndJb2JyMG0yZDNWMTFqZThTS28xSTAxV01MVUdYcXNjNnF5VGNLU2E"
                    + "tdVpxaDRRVTRWQ3NuV0dOcDVQRjU1Ql9SRFViMi0zMEg2d1NoLWxoY05KeUZTUFNmZTBlTXR2NGFXT"
                    + "EdXZDZuSFdtRHpjWnZMNHVpWFVYM0JxbDQ4dkpnOGFSYUJhb0QtS1dhbC01ZmlqRDlIN2xxQzRsVl9"
                    + "FZUlUemtXN3JSWlZLREstV3FSbDhRU3FiaHRwNFM3Wmd2ZmNyd1p3aUx1QnZaVDQ3cWtUeE01SjFES"
                    + "npxcC1nQjZkbzdwX0NUa0IwX0hrLVpKU1FyQjFPTEJXWV9vOTlYRVZDbmhmRHQ1a1ZmWW1MelVmUTF"
                    + "YQzA1RDN4dEloMFdYTG9iMndJNldXNFFEMTNzaGdJZzIwQmwwTGlubEl2TWJ0ZkYxWE8waDhSelNMY"
                    + "25hNWNQX0l3Q0FlLU5FVzRGMXdDTG16Q0hvSXF3OTJfUmxieW1peUtvdFpTcnotaHVlX0VHTlFXbGp"
                    + "rQ1ZKMG0tTG5lTlpZb01Pczh2cUdYOHA5SXV4eE03eWsxenZ0YW5uYmcxeXg2WHAyOEUwc216VUdzX"
                    + "zFNQkhwcVNZdUxEbFJUZ1VnZlotTlFVal9zSmJpUF84R1QzYTViQVJSLkxiSUZBZ01UTHJhUnRmckx"
                    + "TNWJoZEEiLCJwbGFpbkRhdGEiOiIifQ.TLshWKNQ0D2ZlnYihPB9wCwJO1bcgPnp8SUuEieMY8Qv88"
                    + "aJ6ihwuzot1s4PsQ7MD6yc5CQIMAL8KaAgtwWwNqrA7eE9OYzfQxUS4yE5YqrS87ONl52N88h-e7TM"
                    + "lGThUW32FkAQpOuy5KfejeYsOqXB9Up3vqPAxhZEIFgcLY3kHjVze1um4CMs_4x_e9sVUuecjS-09Q"
                    + "nIucIDTPZp6roQDuII08NP8ZYZVmY9V63z6MIaNd-lHZtDpKw_ZwDy3H1yiiJ8xDC2mO7p3FgaATR-"
                    + "DdiLVDK33fs7tDAKRDw89e77mm6IIoIIAzuFRlTSoooafk30AECJdhjeMsoN_Q";
    static final String EVENT2 =
            "eyJraWQiOiJLRVk4VnhUS1lYd2lzTXlmQ0F5TVRRc3V4NXBTYmtaZ3lnU3kiLCJ0eXAiOiJKV1QiLCJhbGciOiJS"
                    + "UzI1NiJ9.eyJpc3MiOiJ1cm46YWxpYmFiYTppZGFhczphcHA6ZXZlbnQiLCJzdWIiOiJpZGFhc18yd"
                    + "zR2bWZyeW54aTdhZTI1bXQ3azVlNG9waSIsImF1ZCI6ImFwcF9taTJldTVra2cyb25icG1zZ2dkN2h"
                    + "ndHJ6cSIsImV4cCI6MTY0ODYzMjA0MywiaWF0IjoxNjQ4NjMwMjQzLCJqdGkiOiJrLWwxMF94d3hjW"
                    + "U5yQ19aeFp3LUF3IiwiZGF0YUVuY3J5cHRlZCI6dHJ1ZSwiY2lwaGVyRGF0YSI6ImV5SmhiR2NpT2l"
                    + "Ka2FYSWlMQ0psYm1NaU9pSkJNalUyUjBOTkluMC4uVU8tcHJhb2NMVHZyOTVZTy5sTTRWcDI3T0IwX"
                    + "2tPQ0g0dlJZajV1YlczVnQ1MDF0OGFYdmZvLUYwTUVMdGMzbDZtdXBJa3lkdVM1QnhIQkE4cEp4Zkl"
                    + "nNFFIdVdrcmhhdFNsbEtLcDY3YTc5YzNqdUxfTkotQVhRRVhheFNMZVIyUVdvNWd4cW8wQnNuU2hsS"
                    + "kNJNEhKaUI0dFhENFgwZ0gxaDRRRW9rMmxVODZ0YkhOMHExb01rcXhtUlVNLWh4YW50ZTBCYnJZM0t"
                    + "iZUpTVVhZTTBpZmkzN1lwekdhNE04M2lfd0xEVkh0UUN6RGF3LUZrVF9uRW9BaFhwZHMtNU1memx0U"
                    + "mFGTzJmZFJkRWluSVlJYmhmQmZMcFp4Q2dDQmlwbzlDLWotVldqVEJIQU5McjY4MUUzUEpXVTZqZTB"
                    + "kNmtqOFVsZGRsbjZTTGhRM2dId2VWZlhmRFN3Q2ZSb3ZPSjlFbUpTYWZ4MkJSVFdOcmpVOWlwdElTS"
                    + "FRDbkMzZ3drR3dSNlBobFdLeTd4ZUhZUWJwb1hvLU11bDFPc1MyNElvZVVCVWpDaVk5MWd4MEpzWUN"
                    + "RWjdvcGxYR1JlSDhpWmhjUFlwWUluc2dYcjlQMXEzS20xVlFTRURDOHpsWUxkTmthb3g3aVVlc0dlY"
                    + "nVKcXZTaEtWeWJEZHp4bkJBdUl4WFE4UW5TWUxtd1hvWldOcVdmZGVJSEtaOXBTU1RySWo5OE9PRHl"
                    + "iclM4RVgwaDFBR2haUzRJcmxGak8xUXYycmV3bG1Ua3d6VThaN05FSDR4UlV0VGE2QV9mREtrQU8tT"
                    + "WRmR0RwcnVUeHROcUx6WTQwMmFJS0FxQ1F3d08zLWdzRmhSLW5LSUZIM2tVb1J6cGZkZWFXb0Z1bXN"
                    + "VQlRrdjBlQ2pidEl5cGQzRnhKbU0wTWl6QkRMM3BfaG1PT1RXbEhQU0hMaFJoeEliT0IzdnZhYU94W"
                    + "WpZWWxIODBaZ0d0aUI1UWRYQ1BsM1ctTHB3NXB1amVhSzd5aFk2Zmg4aVhFMEJZU2NXRFNWaHdqZGx"
                    + "GbmYzOWNlQ2plUm50TzIxTlNfbTJWR2ZnQkFwZ1c5VmZOaV9uWGdUNjhGYU1FM280dUIxbHNOQ1J5b"
                    + "i1XWEoxYVVRZzFqSTBhVHBTMXJCS1A4U05jaWxldkF4OXBmZzZBU3JyMkdzTU5GVGM1WmJqd1VFRDF"
                    + "OaE80SzlNOHJYUUtXeVFXTXhqQUs4TU9oN1RCQTB0MG9VT0I5NkM4d0hOS0VpRHBEQlVwOUxEM09Eb"
                    + "WJKaTdJMHRpSEpxdjFXeVBOTjJQN0U5OV8tclBqRjlVYjlxcElYazdsY0NOTEZhNnRYc2szeWZIaml"
                    + "ORVZsV1RzM2drSDFrcFY2NkVwMXJvNUxJMFZmS01FUVphQTd1dkhDeF9sRVVtMlRyYzBTRmEzZUpkU"
                    + "lB1cHd4MW9YNEJkTE9NLTN4MktnWjlMeDFxc3ExMEZyY3lwX2RvVXhQYWczZW1VSnBKSWM2UTB2SnN"
                    + "DTWJxMmFubm5vLWw2VkpReGxFdUZpWHNoX1FWTkE2Qnh6czZzUGtHbWFia0pybERkT3ByX1kyUGtlN"
                    + "0xfMFIyem9UR1JXQ1V0dG5NQUhIX2RWQUlqZ0JfWk5PWllLSFZ4NlNmQkhOTm9UYWNFRzF2dnlGX0Q"
                    + "0YzUyMkZKUmRXUnRrTXNMaGdqdU1oQWpkWVlsSUpJell5bFMwcVE4N2VzZXF1WE9pYVJUd2hxWjFxR"
                    + "DJuVXpRenkzbUJIcERPZkFtblczcU5QLV82ZGVWZFFBUHVMSnhxbjVsU0JxT1daNERFaFhCbG5LaUV"
                    + "ZcXo3QlZUWmRWMTR1akQtSFB6SXBnWmFiN2IxRUNPaGsyYzh5TzJ4MlRXMzhmbGVBUUNOUnMzb2ZkQ"
                    + "0dzWHhhYnhhSEFfRlFyU2RrM19Mem9UVFFJbThkMXFFUTRnbUxfMEtBNmVXMENubWRjcXNRRjdCYVB"
                    + "VUTc3UVFEMHFfZVJ5WjRtUHBweklFeElpeFpHQ1ZQNnRrN0VScGdxZTRmcUJwdldpblVDbDNPSS1QY"
                    + "zd5ZEV1UkFjdXNRLmlWTkV4TW4zbGpxR0ZQLTh1Q3pQUlEiLCJwbGFpbkRhdGEiOiIifQ.I5dErpcF"
                    + "Hus_JyNKuIfLv4uRcGMIUSREiHeLQduPUzWmzJ7dbyxuqlfyUF4-KgyOa_kJUz4I0XmAj-s3IbQgDK"
                    + "6tGLOLMR1t_8w9RGUDM_3zAYQj1BoczBrsaMSsnaBgKW8ulFWgxtcPU6t6teJzDYvgx3asPw3_tBKc"
                    + "6kChMWRaK4V-J_jvAp6tFlWD47uGxisFbl3_bGl1y8zvDWDS-2vQwB91tRPvd7zLOuDcmKLBLz5Ot4"
                    + "U1_MErVjDmMSnJAsYHJcbL04_B6tmiR706E2FDWmCcZxD-U9Ch_FSg0G7vbQtRaTZH5Svx_3uizhCL"
                    + "Wt_yMGGaKEEdqTNipeLl4Q";

    @Test
    public void test01() {
        EventDataRunner eventDataRunner = new EventDataRunner();
        eventDataRunner.setJwkJson(JWK_JSON);
        eventDataRunner.setAppId(APP_ID);
        eventDataRunner.setEncryptKey(ENCRYPT_KEY);
        eventDataRunner.setEventDataCallback(new DefaultEventDataCallbackImpl());

        RequestObject requestObject = new RequestObject();
        requestObject.setEvent(EVENT1);
        ResponseObject responseObject = eventDataRunner.dispatchEventData(requestObject);
        Assertions.assertEquals(ErrorResponseObject.class, responseObject.getClass());
        Assertions.assertEquals("bad_request", ((ErrorResponseObject)responseObject).getError());
    }

    @Test
    public void test02() {
        EventDataRunner eventDataRunner = createJwtValidatorsDisabledEventRunner();
        eventDataRunner.setJwkJson(JWK_JSON);
        eventDataRunner.setAppId(APP_ID);
        eventDataRunner.setEncryptKey(ENCRYPT_KEY);
        eventDataRunner.setEventDataCallback(new DefaultEventDataCallbackImpl());

        RequestObject requestObject = new RequestObject();
        requestObject.setEvent(EVENT1);
        ResponseObject responseObject = eventDataRunner.dispatchEventData(requestObject);
        Assertions.assertEquals(SuccessResponseObject.class, responseObject.getClass());
        SuccessResponseObject successResponseObject = (SuccessResponseObject)responseObject;
        Assertions.assertTrue(successResponseObject.getSuccessEvents().isEmpty());
        Assertions.assertTrue(successResponseObject.getRetriedEvents().isEmpty());
        Assertions.assertTrue(successResponseObject.getFailedEvents().isEmpty());
        Assertions.assertEquals(1, successResponseObject.getSkippedEvents().size());
        Assertions.assertEquals("evnt_aaaac76zx6x3lxfwgp2f2vm4kvhiv2gi33kqc7q", successResponseObject.getSkippedEvents().get(0).getEventId());
        Assertions.assertEquals("auto_skipped", successResponseObject.getSkippedEvents().get(0).getEventCode());
    }

    @Test
    public void test03() {
        EventDataRunner eventDataRunner = createJwtValidatorsDisabledEventRunner();
        eventDataRunner.setJwkJson(JWK_JSON);
        eventDataRunner.setAppId(APP_ID);
        eventDataRunner.setEncryptKey(ENCRYPT_KEY);
        DefaultEventDataCallbackImpl defaultEventDataCallback = new DefaultEventDataCallbackImpl();
        eventDataRunner.setEventDataCallback(defaultEventDataCallback);

        defaultEventDataCallback.registerUserCallback(new UserCallback() {
            @Override
            public EventDataResponse onUserDelete(EventContext eventContext, UserInfo userInfo) {
                throw new RuntimeException("Delete user error!");
            }
        });

        RequestObject requestObject = new RequestObject();
        requestObject.setEvent(EVENT1);
        ResponseObject responseObject = eventDataRunner.dispatchEventData(requestObject);
        Assertions.assertEquals(SuccessResponseObject.class, responseObject.getClass());
        SuccessResponseObject successResponseObject = (SuccessResponseObject)responseObject;
        Assertions.assertTrue(successResponseObject.getSuccessEvents().isEmpty());
        Assertions.assertTrue(successResponseObject.getSkippedEvents().isEmpty());
        Assertions.assertTrue(successResponseObject.getFailedEvents().isEmpty());
        Assertions.assertEquals(1, successResponseObject.getRetriedEvents().size());
        Assertions.assertEquals("evnt_aaaac76zx6x3lxfwgp2f2vm4kvhiv2gi33kqc7q", successResponseObject.getRetriedEvents().get(0).getEventId());
        Assertions.assertEquals("exception", successResponseObject.getRetriedEvents().get(0).getEventCode());
    }

    @Test
    public void test04() {
        EventDataRunner eventDataRunner = createJwtValidatorsDisabledEventRunner();
        eventDataRunner.setJwkJson(JWK_JSON);
        eventDataRunner.setAppId(APP_ID);
        eventDataRunner.setEncryptKey(ENCRYPT_KEY);
        DefaultEventDataCallbackImpl defaultEventDataCallback = new DefaultEventDataCallbackImpl();
        eventDataRunner.setEventDataCallback(defaultEventDataCallback);

        defaultEventDataCallback.registerUserCallback(new UserCallback() {
            @Override
            public EventDataResponse onUserDelete(EventContext eventContext, UserInfo userInfo) {
                return EventDataResponse.newNeedRetryEventDataResponse("temp_error", "test message");
            }
        });

        RequestObject requestObject = new RequestObject();
        requestObject.setEvent(EVENT1);
        ResponseObject responseObject = eventDataRunner.dispatchEventData(requestObject);
        Assertions.assertEquals(SuccessResponseObject.class, responseObject.getClass());
        SuccessResponseObject successResponseObject = (SuccessResponseObject)responseObject;
        Assertions.assertTrue(successResponseObject.getSuccessEvents().isEmpty());
        Assertions.assertTrue(successResponseObject.getSkippedEvents().isEmpty());
        Assertions.assertTrue(successResponseObject.getFailedEvents().isEmpty());
        Assertions.assertEquals(1, successResponseObject.getRetriedEvents().size());
        Assertions.assertEquals("evnt_aaaac76zx6x3lxfwgp2f2vm4kvhiv2gi33kqc7q", successResponseObject.getRetriedEvents().get(0).getEventId());
        Assertions.assertEquals("temp_error", successResponseObject.getRetriedEvents().get(0).getEventCode());
    }

    @Test
    public void test05() {
        EventDataRunner eventDataRunner = createJwtValidatorsDisabledEventRunner();
        eventDataRunner.setJwkJson(JWK_JSON);
        eventDataRunner.setAppId(APP_ID);
        eventDataRunner.setEncryptKey(ENCRYPT_KEY);
        DefaultEventDataCallbackImpl defaultEventDataCallback = new DefaultEventDataCallbackImpl();
        eventDataRunner.setEventDataCallback(defaultEventDataCallback);

        defaultEventDataCallback.registerUserCallback(new UserCallback() {
            @Override
            public EventDataResponse onUserDelete(EventContext eventContext, UserInfo userInfo) {
                return EventDataResponse.newSkippedEventDataResponse("just_skipped", "test message");
            }
        });

        RequestObject requestObject = new RequestObject();
        requestObject.setEvent(EVENT1);
        ResponseObject responseObject = eventDataRunner.dispatchEventData(requestObject);
        Assertions.assertEquals(SuccessResponseObject.class, responseObject.getClass());
        SuccessResponseObject successResponseObject = (SuccessResponseObject)responseObject;
        Assertions.assertTrue(successResponseObject.getSuccessEvents().isEmpty());
        Assertions.assertTrue(successResponseObject.getRetriedEvents().isEmpty());
        Assertions.assertTrue(successResponseObject.getFailedEvents().isEmpty());
        Assertions.assertEquals(1, successResponseObject.getSkippedEvents().size());
        Assertions.assertEquals("evnt_aaaac76zx6x3lxfwgp2f2vm4kvhiv2gi33kqc7q", successResponseObject.getSkippedEvents().get(0).getEventId());
        Assertions.assertEquals("just_skipped", successResponseObject.getSkippedEvents().get(0).getEventCode());
    }

    @Test
    public void test06() {
        EventDataRunner eventDataRunner = createJwtValidatorsDisabledEventRunner();
        eventDataRunner.setJwkJson(JWK_JSON);
        eventDataRunner.setAppId(APP_ID);
        eventDataRunner.setEncryptKey(ENCRYPT_KEY);
        DefaultEventDataCallbackImpl defaultEventDataCallback = new DefaultEventDataCallbackImpl();
        eventDataRunner.setEventDataCallback(defaultEventDataCallback);

        defaultEventDataCallback.registerUserCallback(new UserCallback() {
            @Override
            public EventDataResponse onUserDelete(EventContext eventContext, UserInfo userInfo) {
                return EventDataResponse.newFailedEventDataResponse("just_failed", "test message");
            }
        });

        RequestObject requestObject = new RequestObject();
        requestObject.setEvent(EVENT1);
        ResponseObject responseObject = eventDataRunner.dispatchEventData(requestObject);
        Assertions.assertEquals(SuccessResponseObject.class, responseObject.getClass());
        SuccessResponseObject successResponseObject = (SuccessResponseObject)responseObject;
        Assertions.assertTrue(successResponseObject.getSkippedEvents().isEmpty());
        Assertions.assertTrue(successResponseObject.getRetriedEvents().isEmpty());
        Assertions.assertTrue(successResponseObject.getSuccessEvents().isEmpty());
        Assertions.assertEquals(1, successResponseObject.getFailedEvents().size());
        Assertions.assertEquals("evnt_aaaac76zx6x3lxfwgp2f2vm4kvhiv2gi33kqc7q", successResponseObject.getFailedEvents().get(0).getEventId());
        Assertions.assertEquals("just_failed", successResponseObject.getFailedEvents().get(0).getEventCode());
    }

    @Test
    public void test07() {
        EventDataRunner eventDataRunner = createJwtValidatorsDisabledEventRunner();
        eventDataRunner.setJwkJson(JWK_JSON);
        eventDataRunner.setAppId(APP_ID);
        eventDataRunner.setEncryptKey(ENCRYPT_KEY);
        DefaultEventDataCallbackImpl defaultEventDataCallback = new DefaultEventDataCallbackImpl();
        eventDataRunner.setEventDataCallback(defaultEventDataCallback);

        defaultEventDataCallback.registerUserCallback(new UserCallback() {
            @Override
            public EventDataResponse onUserDelete(EventContext eventContext, UserInfo userInfo) {
                return EventDataResponse.newSuccessEventDataResponse();
            }
        });

        RequestObject requestObject = new RequestObject();
        requestObject.setEvent(EVENT1);
        ResponseObject responseObject = eventDataRunner.dispatchEventData(requestObject);
        Assertions.assertEquals(SuccessResponseObject.class, responseObject.getClass());
        SuccessResponseObject successResponseObject = (SuccessResponseObject)responseObject;
        Assertions.assertTrue(successResponseObject.getSkippedEvents().isEmpty());
        Assertions.assertTrue(successResponseObject.getRetriedEvents().isEmpty());
        Assertions.assertTrue(successResponseObject.getFailedEvents().isEmpty());
        Assertions.assertEquals(1, successResponseObject.getSuccessEvents().size());
        Assertions.assertEquals("evnt_aaaac76zx6x3lxfwgp2f2vm4kvhiv2gi33kqc7q", successResponseObject.getSuccessEvents().get(0).getEventId());
        Assertions.assertEquals("SUCCESS", successResponseObject.getSuccessEvents().get(0).getEventCode());
    }

    @Test
    public void test12() {
        EventDataRunner eventDataRunner = new EventDataRunner();
        eventDataRunner.setJwkJson(JWK_JSON);
        eventDataRunner.setAppId(APP_ID);
        eventDataRunner.setEncryptKey(ENCRYPT_KEY);
        eventDataRunner.setEventDataCallback(new DefaultEventDataCallbackImpl());

        RequestObject requestObject = new RequestObject();
        requestObject.setEvent(EVENT2);
        ResponseObject responseObject = eventDataRunner.dispatchEventData(requestObject);
        Assertions.assertEquals(ErrorResponseObject.class, responseObject.getClass());
        Assertions.assertEquals("bad_request", ((ErrorResponseObject)responseObject).getError());
    }

    @Test
    public void test13() {
        EventDataRunner eventDataRunner = createJwtValidatorsDisabledEventRunner();
        eventDataRunner.setJwkJson(JWK_JSON);
        eventDataRunner.setAppId(APP_ID);
        eventDataRunner.setEncryptKey(ENCRYPT_KEY);
        DefaultEventDataCallbackImpl defaultEventDataCallback = new DefaultEventDataCallbackImpl();
        eventDataRunner.setEventDataCallback(defaultEventDataCallback);
        defaultEventDataCallback.registerUserCallback(new UserCallback() {
            @Override
            public EventDataResponse onUserCreate(EventContext eventContext, UserInfo userInfo) {
                return EventDataResponse.newSuccessEventDataResponse();
            }
        });

        RequestObject requestObject = new RequestObject();
        requestObject.setEvent(EVENT2);
        ResponseObject responseObject = eventDataRunner.dispatchEventData(requestObject);
        Assertions.assertEquals(SuccessResponseObject.class, responseObject.getClass());
        SuccessResponseObject successResponseObject = (SuccessResponseObject)responseObject;
        Assertions.assertTrue(successResponseObject.getSkippedEvents().isEmpty());
        Assertions.assertTrue(successResponseObject.getRetriedEvents().isEmpty());
        Assertions.assertTrue(successResponseObject.getFailedEvents().isEmpty());
        Assertions.assertEquals(1, successResponseObject.getSuccessEvents().size());
        Assertions.assertEquals("evnt_aaaac762aumdlbg5h4afvnsm2hhc3sug4tyqcui", successResponseObject.getSuccessEvents().get(0).getEventId());
        Assertions.assertEquals("SUCCESS", successResponseObject.getSuccessEvents().get(0).getEventCode());
    }

    private EventDataRunner createJwtValidatorsDisabledEventRunner() {
        return new EventDataRunner() {
            @Override
            protected JwtConsumer createJwtConsumer() {
                try {
                    // DISABLE validators for test case
                    final JwtConsumer jwtConsumer = super.createJwtConsumer();
                    final Field validatorsField = JwtConsumer.class.getDeclaredField("validators");
                    validatorsField.setAccessible(true);
                    validatorsField.set(jwtConsumer, new ArrayList<>());
                    return jwtConsumer;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }
}
