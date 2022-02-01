package cn.arros.cli.cmd;

import cn.arros.cli.component.RetrofitService;
import cn.arros.cli.rpc.Repository;
import cn.arros.common.dto.RepositoryDto;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import retrofit2.Retrofit;

/**
 * @Author Verge
 * @Date 2021/12/26 12:32
 * @Version 1.0
 */
@Command(name = "repo",
        description = "仓库相关操作"
)
public class Repo implements Runnable{

    @Command(description = "新增仓库")
    public void add(@Option(names = {"-n", "--name"}, description = "仓库名") String name,
                    @Option(names = {"-u", "--url"}, description = "仓库地址") String url) {
        RepositoryDto repo = new RepositoryDto();
        repo.setName(name);
        repo.setGitUrl(url);

        Retrofit retrofit = RetrofitService.getRetrofitInstance();
        Repository repository = retrofit.create(Repository.class);
        System.out.println(repository.add(repo));
    }

    @Override
    public void run() {

    }
}
