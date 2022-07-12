package Homework13;

import java.io.IOException;
import java.net.URI;

public class Main {
    private static final String URI_USERS = "https://jsonplaceholder.typicode.com/users";
    private static final String URI_SITE = "https://jsonplaceholder.typicode.com/";

    public static void main(String[] args) throws IOException, InterruptedException {

        User user = new User();
        user.setId(1);
        user.setName("Oleksiy Bikinieiev");
        user.setUserName("Alex");
        user.setEmail("Alex@gmail.com");
        user.setAddress("Street", "suite", "Kyiv", "02000", "50.4633", "30.5541");
        user.setPhone("+3812345678");
        user.setWebsite("qwerty.com");
        user.setCompany("nameCompany", "catchPhrase", "bs");

        User user1 = HttpUtil.creationNewUser(URI.create(URI_USERS), user);

        System.out.println("\nTask1.1______________\n");
        System.out.println(user1);

        System.out.println("\nTask1.2______________\n");
        user1.setName("Taras");
        User user2 = HttpUtil.updateUser(URI.create(URI_USERS), user1);
        System.out.println(user2);

        System.out.println("\nTask1.3______________\n");
        System.out.println(HttpUtil.deleteUser(URI.create(URI_USERS), user2));

        System.out.println("\n-Task1.4______________\n");
        System.out.println(HttpUtil.getAllUsers(URI.create(URI_USERS)).toString());

        System.out.println("\nTask1.5-______________\n");
        User user5 = HttpUtil.getUserWithId(URI.create(URI_USERS), 1);
        System.out.println(user5);

        System.out.println("\nTask1.6______________\n");
        System.out.println(HttpUtil.getUserWithUserName(URI.create(URI_USERS), "Bret").toString());

        System.out.println("\n-Task2______________\n");
        HttpUtil.getAllCommentsWithLastPost(URI.create(URI_SITE));

        System.out.println("\nTask3-______________\n");
        HttpUtil.printAllUserOpenTask(URI.create(URI_USERS));
    }
}
