package cn.arros.cli.component;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Author Verge
 * @Date 2022/1/5 13:01
 * @Version 1.0
 */
public class RetrofitService {
    private static final String API_URL = "http://localhost:4567";

    private static final Retrofit retrofit = new Retrofit.Builder()
                                                .baseUrl(API_URL)
                                                .addConverterFactory(GsonConverterFactory.create())
                                                .build();

    private RetrofitService() {
    }

    public static Retrofit getRetrofitInstance() {
        return retrofit;
    }
}
