import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.Scanner;

public class UserLogin {
    public static void login(Scanner scanner) throws IOException {
        System.out.print("System:> Enter your username\nUser:> ");
        String username = scanner.nextLine().trim();
        System.out.print("System:> Enter password\nUser:> ");
        String password = scanner.nextLine().trim();
        String role1 = "admin";
        String role2 = "student";
        JSONArray users = FileSystem.getUsers();

        for (Object userObj : users) {
            JSONObject user = (JSONObject) userObj;
            if (user.get("username").equals(username) && user.get("password").equals(password)) {
                System.out.println("System:> Welcome " + username + "!");
                if (role1.equalsIgnoreCase((String) user.get("role"))) {
                    QuizSystem.adminMenu(scanner);
                } else if (role2.equalsIgnoreCase((String) user.get("role"))) {
                    QuizSystem.studentQuiz(scanner);
                }
                return;
            }
        }
        System.out.println("Invalid credentials. Try again.");
        login(scanner);
    }
}
