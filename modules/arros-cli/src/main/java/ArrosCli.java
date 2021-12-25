import org.jline.reader.EndOfFileException;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.UserInterruptException;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.io.IOException;

/**
 * @Author Verge
 * @Date 2021/12/24 19:50
 * @Version 1.0
 */
public class ArrosCli {
    public static void main(String[] args) {
        try (Terminal terminal = TerminalBuilder.builder().build()) {
            LineReader lineReader = LineReaderBuilder.builder()
                    .terminal(terminal)
                    .build();
            String prompt = "arros> ";
            while (true) {
                String line;
                try {
                    line = lineReader.readLine(prompt);
                    System.out.println(line);
                } catch (UserInterruptException e) {
                    System.out.println(e);
                } catch (EndOfFileException e) {
                    System.out.println("\nBye.");
                    return;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
