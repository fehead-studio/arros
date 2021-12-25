package cn.arros.cli.cmd;

import cn.arros.cli.rpc.Test;
import feign.Feign;
import feign.gson.GsonDecoder;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

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
        // TODO：考虑使用工厂模式重构
        Test test = Feign.builder()
                        .decoder(new GsonDecoder())
                        .target(Test.class, "http://localhost:4567");

        System.out.println(test.ping(message));
    }
}
