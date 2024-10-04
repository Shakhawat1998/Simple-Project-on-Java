import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Scanner;

public class HomePage {
    public static void main(String[] args) throws IOException, ParseException {
        Scanner scanner = new Scanner(System.in);
        FileSystem.loadUsers();
        FileSystem.loadQuestions();
        UserLogin.login(scanner);
        scanner.close();
    }
}
