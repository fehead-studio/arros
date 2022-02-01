package cn.arros.cli.cmd;

import cn.arros.cli.component.RetrofitService;
import cn.arros.cli.rpc.Test;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import retrofit2.Retrofit;

import java.io.IOException;

/**
 * @Author Verge
 * @Date 2021/12/25 23:26
 * @Version 1.0
 */

@Command(name = "ping",
        description = {"测试客户端与服务端的连通性"},
        mixinStandardHelpOptions = true
)
public class Ping implements Runnable{
    @Option(names = {"-m", "--message"}, description = "任意消息")
    private String message = "pong";

    @Override
    public void run() {
        Retrofit retrofit = RetrofitService.getRetrofitInstance();
        Test test = retrofit.create(Test.class);

        try {
            System.out.println(test.ping(message).execute().body());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
