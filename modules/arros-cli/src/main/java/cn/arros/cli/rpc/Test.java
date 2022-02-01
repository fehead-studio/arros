package cn.arros.cli.rpc;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @Author Verge
 * @Date 2021/12/25 23:18
 * @Version 1.0
 */
public interface Test {
    @GET("/ping/{message}")
    Call<String> ping(@Path("message") String message);
}
