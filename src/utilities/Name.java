package utilities;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Name {

    public static void main(String[] args) throws IOException {
        String NameStock = "AAM";
        System.out.print(NameStock);

        for(Scanner scanner = new Scanner(Paths.get("C:\\Users\\Admin\\IdeaProjects\\Book1.txt")); scanner.hasNextLine(); scanner.nextLine()) {
            String s = scanner.next();
            if (NameStock.equals(s)) {
                String TenDN = scanner.nextLine();
                System.out.println(TenDN);
            }
            scanner.nextLine();
        }

    }
}

