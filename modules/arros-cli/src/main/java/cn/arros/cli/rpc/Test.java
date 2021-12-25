package cn.arros.cli.rpc;

import feign.Param;
import feign.RequestLine;

/**
 * @Author Verge
 * @Date 2021/12/25 23:18
 * @Version 1.0
 */
public interface Test {
    @RequestLine("GET /ping/{message}")
    String ping(@Param("message") String message);
}
