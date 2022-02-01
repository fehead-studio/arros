package cn.arros.cli.rpc;

import cn.arros.common.common.CommonResult;
import cn.arros.common.dto.RepositoryDto;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @Author Verge
 * @Date 2021/12/26 12:32
 * @Version 1.0
 */
public interface Repository {
    @POST("/server/repository")
    CommonResult add(@Body RepositoryDto repo);
}
