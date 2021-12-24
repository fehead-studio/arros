import picocli.CommandLine;
import picocli.CommandLine.*;

import java.util.concurrent.Callable;

/**
 * @Author Verge
 * @Date 2021/12/24 19:50
 * @Version 1.0
 */
@Command(name = "arroscli", mixinStandardHelpOptions = true, version = "1.0.0",
        description = "Arros项目cli.")
public class ArrosCli implements Callable<Integer>  {

    @Override
    public Integer call() throws Exception {
        return null;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new ArrosCli()).execute(args);
        System.exit(exitCode);
    }
}
