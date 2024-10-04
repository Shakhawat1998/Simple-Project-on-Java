import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import  org.json.simple.JSONObject;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class FileSystem {
    private static JSONArray users;
    private static JSONArray questions;
    private static final String users_file = "./src/main/resources/user.json";
    private static final String quiz_file = "./src/main/resources/quiz.json";



    public static void loadUsers() throws IOException, ParseException {
        FileReader reader = new FileReader(users_file);
        JSONParser jsonParser = new JSONParser();
        users = (JSONArray) jsonParser.parse(reader);
    }





    public static void loadQuestions() throws IOException, ParseException {
        FileReader reader = new FileReader(quiz_file);
        JSONParser jsonParser = new JSONParser();
        questions = (JSONArray) jsonParser.parse(reader);

        if (questions == null) {
            questions = new JSONArray();
        }
    }

    public static JSONArray getUsers() {
        return users;
    }

    public static JSONArray getQuestions() {
        return questions;
    }

    public static void addQuestion(JSONObject question) throws IOException {
        questions.add(question);
        saveQuestions();
    }




    public static void saveQuestions() throws IOException {
        FileWriter file = new FileWriter(quiz_file);
        file.write(questions.toJSONString());
        file.flush();
    }


}
