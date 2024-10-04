# Project Title: MCQ Quiz Management System with Admin and Student Login

## Project Summary:

The **MCQ Quiz Management System** is a simple command-line-based application that enables two types of users: Admin and Student. The admin user can log in and add multiple-choice questions (MCQs) to a quiz bank, storing questions with four options and an answer key in a `quiz.json` file. Students can log in to take a quiz where 10 random questions are presented from the quiz bank. The system evaluates the student's answers and provides a score based on the number of correct answers.

Key Features:
- **Admin User:**
  - Add new MCQ questions to the quiz bank.
  - Questions are saved in JSON format with four options and an answer key.
  
- **Student User:**
  - Take a quiz with 10 random questions from the quiz bank.
  - Real-time scoring based on correct answers.
  - Feedback based on the score, ranging from "Excellent" to "Very Sorry, you are failed."
  
The system uses `users.json` to handle login credentials for both admins and students, and `quiz.json` to manage the quiz bank.

This project can be expanded for educational purposes, quizzes, or test automation.

## Required Tools & Technologies:

1. **Java JDK 17**
2. **Gradle Build Tool**
3. **Simple JSON Library**
4. **IntelliJ IDEA**

# How to Run the Whole Project in IntelliJ IDEA

1. **Clone the Repository**
2. **Open IntelliJ IDEA**
3. **Import the Project**
4. **Configure the Project SDK**
5. **Add Dependencies**
   - Add Simple json dependency in `build.gradle`
7. **Build the Project**
8. **Run the Main Class**
   - Right-click on `HomePage.java` and select `Run 'HomePage.main()'`.
9. **Interact with the Application**
   - Follow the console prompts to log in and use the application.
10. **Stop the Application**


# Whole Project Architecture

The project is divided into distinct modules (Java classes) that handle specific functionalities, such as user login,quiz management, and file handling. Each module has a specific purpose and can be modified independently. 

1. **Application Start:**
   - The application begins execution in the `HomePage` class.

2. **Loading Data:**
   - The `HomePage` class calls `FileSystem.loadUsers()` to load user data from `user.json`.
   - It then calls `FileSystem.loadQuestions()` to load quiz questions from `quiz.json`.

3. **User Authentication:**
   - The `HomePage` class invokes `UserLogin.login(scanner)` to handle user login.
   - The user is prompted to enter their username and password.

4. **User Role Verification:**
   - If the entered credentials match those in `user.json`:
     - **If the user is an Admin:**
       - The system directs them to the `QuizSystem.adminMenu(scanner)` method.
     - **If the user is a Student:**
       - The system directs them to the `QuizSystem.studentQuiz(scanner)` method.
   - If the credentials are incorrect, the user is prompted to try again.

5. **Admin Functionality:**
   - In the `adminMenu()`, the admin can create and add new quiz questions:
     - The admin inputs the question text, four options, and the correct answer key.
     - This information is saved in `quiz.json`.
     - The admin can continue adding questions or choose to quit.

6. **Student Functionality:**
   - In the `studentQuiz()`, students can take a quiz:
     - They are presented with 10 random questions selected from the quiz bank.
     - After answering, the system tallies the score based on correct answers.
     - Feedback is given based on their score (Excellent, Good, Very Poor, or Failed).

7. **Result Display:**
   - After the quiz, the student is prompted to either take the quiz again or quit the application.

8. **Data Persistence:**
   - The `FileSystem` class manages data persistence:
     - It reads user credentials from `user.json` and quiz questions from `quiz.json`.
     - When an admin adds a question, it saves the updated question bank back to `quiz.json`.

This flow illustrates how the different components of the application interact with each other to create a functional quiz system for both admins and students.

# Java Concepts Used in the Project

1. **File Handling:**
   - The project reads and writes data to JSON files (`user.json` and `quiz.json`) using `FileReader` and `FileWriter` classes.
   - This ensures data persistence across application runs.

2. **JSON Parsing and Manipulation:**
   - The `org.json.simple` library is used to parse JSON data and work with `JSONArray` and `JSONObject`.
   - JSON is used to store user credentials and quiz questions, making it easy to handle structured data.

3. **Exception Handling:**
   - The project uses `try-catch` blocks and the `throws` keyword to handle potential `IOException` and `ParseException` that might occur during file operations.
   - This ensures smooth error handling and provides feedback in case of issues.

4. **Control Flow:**
   - The program uses basic control flow constructs like `if-else` statements and loops (`for` and `while`) to direct the application logic based on user input and role (admin or student).

5. **Scanner for Input Handling:**
   - `Scanner` is used to capture user input from the console, enabling interactive login and quiz functionality.
   - It reads inputs like usernames, passwords, questions, and answers in a user-friendly manner.

6. **Method Calls and Code Modularity:**
   - The program is divided into multiple classes (`HomePage`, `UserLogin`, `QuizSystem`, and `FileSystem`), each having specific methods to handle distinct functionality (e.g., login, adding questions, taking quizzes).
   - This modular approach improves code organization and readability.

7. **Recursion:**
   - In the `UserLogin.login()` method, recursion is used to re-prompt the user for credentials in case of an incorrect login attempt.

8. **Randomization:**
   - The `Random` class is used in the `QuizSystem.studentQuiz()` method to randomly shuffle and present quiz questions to students, ensuring a varied set of questions in each quiz attempt.

9. **String Manipulation:**
   - The program frequently uses string methods (e.g., `equals()`, `trim()`, and `equalsIgnoreCase()`) to handle user inputs and compare data such as usernames, passwords, and answer keys.
  
# A Demonstration Video of How to Run the Project

A simple demonstration video of the project is added in this [link](https://drive.google.com/file/d/16Fi2ssrvgWTMUdsh8lBLYR6ETrhDxsZZ/view?usp=sharing)







