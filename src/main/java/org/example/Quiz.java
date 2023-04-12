package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Quiz {
    private char starter = 'A';
    private static final String FILE_NAME = "src/main/java/HOST/users.json";

    public static void main(String[] args) {
        new Quiz().run();


    }

    public void run() {
        new UserService().authentification("src/main/java/HOST/users.json");
    }

    public void answerQuiz() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File("src/main/java/HOST/quiz.json");
            Question[] questions = objectMapper.readValue(file, Question[].class);

            Scanner scanner = new Scanner(System.in);
            int score = 0;
            for (int i = 0; i < questions.length; i++) {
                System.out.println(i + 1 + ".\t" + questions[i].getText());

                for (int j = 0; j < questions[i].getAnswers().size(); j++) {
                    char no = (char) ((char) starter + j);
                    System.out.println("\t" + no + ".\t" + questions[i].getAnswers().get(j).getText());
                }
                System.out.println("Your answer: ");
                char answer = scanner.nextLine().toUpperCase().charAt(0);

                if ((int) answer - starter > questions[i].getAnswers().size() - 1 || (int) answer - starter < 0) {
                    System.out.println("WRONG!");
                } else if (questions[i].getAnswers().get(answer - starter).getisCorrect()) {
                    score++;
                    System.out.println("RIGHT!");
                } else {
                    System.out.println("WRONG!");
                }
            }
            System.out.println("YOUR SCORE IS " + score + "/" + questions.length + " POINTS.");
            editUserTokens();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void editUserTokens() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            File file = new File(FILE_NAME);

            CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(List.class, User.class);
            List<User> users = objectMapper.readValue(file, listType);

            System.out.println("Users:");
            for (User user : users) {
                System.out.println("id="+user.getId()+" "+"tokens="+user.getTokens());
            }
            System.out.println("Enter the ID of the user to modify:");
            Scanner scanner = new Scanner(System.in);
            int userId = scanner.nextInt();
            scanner.nextLine();

            User userToModify = null;
            for (User user : users) {
                if (user.getId() == userId) {
                    userToModify = user;
                    break;
                }
            }

            if (userToModify != null) {
                System.out.println("Enter the new tokens value for " + userToModify.getUsername() + ":");
                int newTokens = scanner.nextInt();
                userToModify.setTokens(newTokens);
            } else {
                System.out.println("User not found");
            }

            objectMapper.writeValue(file, users);
            System.out.println("User tokens updated");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readUsersFile() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            File file = new File(FILE_NAME);

            CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(List.class, User.class);
            List<User> users = objectMapper.readValue(file, listType);

            System.out.println("Users:");
            for (User user : users) {
                System.out.println(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}