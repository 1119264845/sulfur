package com.elfop.sulfur.base.util;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @author: liu zhenming
 * @version: V1.0
 * @date: 2019/7/9  15:36
 */
@Component
public class OkHttpClientUtil {

    public static final int CONN_TIMEOUT = 20;
    public static final int READ_TIMEOUT = 20;
    public static final int WRITE_TIMEOUT = 20;

    public static final String REQUEST_POST = "POST";
    public static final OkHttpClient CLIENT = createOkHttpClient();
    public static final MediaType JSON = MediaType.parse("application/json");
    public static final MediaType FORM = MediaType.parse("application/x-www-form-urlencoded");

    private static OkHttpClient createOkHttpClient() {
        return new OkHttpClient.Builder().connectTimeout(CONN_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS).writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                .build();
    }


}
