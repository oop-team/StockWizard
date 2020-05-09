package utilities;

import java.io.File;
import java.util.Scanner;

public class NameStock {
    public static void main(String []args) {
        String NameStock;
        Scanner scanner = new Scanner(Paths.get("Book1.txt"));
        while(scanner.hasNext()) {
            String string = scanner.next();
            if (NameStock == string) {
                String TenDN = scanner.nextLine;
                Sistem.out.println(TenDN);
                break;
            }
            scanner.nextLine();


        }
        scanner.close;
    }
}
