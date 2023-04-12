package org.example;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {

    private List<User> userList = new ArrayList<>();
    public void authentification(String pathName) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(pathName);
            User[] users = objectMapper.readValue(file, User[].class);
            Scanner scanner = new Scanner(System.in);
            System.out.println("Insert username");
            String username = scanner.nextLine();
            System.out.println("Insert password");
            String password = scanner.nextLine();
            boolean flag = false;
            for (int i = 0; i < users.length; i++) {
                if ((username.equals(users[i].getUsername())) && password.equals(users[i].getPassword())) {
                    System.out.println("Authentication successful");
                    Quiz quiz = new Quiz();
                    quiz.answerQuiz();
                    break;
                } else {
                    flag = true;
                }
            }
            if (flag) {
                System.out.println("Authentication failed");
            }
        } catch (StreamReadException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
