package service.impl;

import enums.Gender;
import model.Book;
import model.User;
import service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class UserServiceImpl implements UserService {
    List<User> userList = new ArrayList<>();

    @Override
    public String createUser(List<User> users) {
        userList.addAll(users);
        return "Users crated succsessfully!";
    }

    @Override
    public List<User> findAllUsers() {
        return userList;
    }

    @Override
    public User findUserById(Long id) {
        for (User user : userList) {
            if (Objects.equals(user.getId(), id)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public String removeUserByName(String name) {
        userList.removeIf(user -> user.getName().equals(name));
        return "User removed successfully!";
    }

    @Override
    public void updateUser(Long id) {


    }

    @Override
    public void groupUsersByGender() {
        System.out.println("Males: ");
        userList.stream().filter(user -> user.getGender().equals(Gender.MALE)).toList().forEach(System.out::println);
        System.out.println("~~~~~~~~~~~~~~~~~~~" + "\nFemales: ");
        userList.stream().filter(user -> user.getGender().equals(Gender.FEMALE)).toList().forEach(System.out::println);
    }

    @Override
    public String buyBooks(String name, List<Book> books) {
        for (Book book : books) {
            if (book.getName().equals(name)) {
                System.out.println("Enter user id:");
                long id = new Scanner(System.in).nextLong();
                for (User user : userList) {
                    if (Objects.equals(user.getId(), id)) {
                        user.setBooks(List.of(book));
                        return "Book pay successfully!!";
                    }
                }
            }
        }
        return null;
    }
}
