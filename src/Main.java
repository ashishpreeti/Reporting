import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");
        Path path = Paths.get("");
//        System.out.println("Path" + path.toAbsolutePath().toString());
//        System.out.println("PATH @ : " + Paths.get(".").toAbsolutePath().normalize().toString());
//
//        String workingdirectory = System.getProperty("user.dir");
//        System.out.println(workingdirectory);
        String content = new String(Files.readAllBytes(Paths.get("out/production/Reporting/school.xml")));
        System.out.println("Content: " + content);

        try (Stream<Path> stream = Files.walk(path)) {
              stream.filter(anything -> path.toFile().isDirectory())
                      .forEach(System.out::println);
        }



    }
}
