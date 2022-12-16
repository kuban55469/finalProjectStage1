import enums.Gender;
import enums.Genre;
import enums.Language;
import model.Book;
import model.User;
import service.impl.BookServicrImpl;
import service.impl.UserServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Бардык Id лер уникальный болуш керек. Эгер уникальный болбосо озубуз тузгон UniqueConstraintException класс ыргытсын.
        // User дин email адресси уникальный болуш керек жана @ болуусу керек. Эгер уникальный болбосо UniqueConstraintException класс,
        // @ болбосо озубуз тузгон BadRequestException класс ыргытсын.
        // User дин телефон номери +996 дан башталып 13 символдон турсун. Болбосо BadRequestException класс ыргытсын.
        // Китептин баасы терс сан болбошу керек. Болбосо NegativeNumberException ыргытсын.
        // Китептин чыккан жылы келечек убакыт болбошу керек.Болбосо DateTimeException ыргытсын.
        // Китептин автору бош болбошу керек. Болбосо EmptyStackException ыргытсын.


        List<User> users = new ArrayList<>(List.of(
                new User(1L,"Kuban","Kelsinbekov","kubanmuit@gmail.com","+996708281398", Gender.MALE, BigDecimal.valueOf(5000),null),
                new User(2L,"Asan","Azimov","asan@gmail.com","+996999888777", Gender.MALE, BigDecimal.valueOf(5000),null),
                new User(3L,"Janysh","Akbalaev","janysh@gmail.com","+996888000999", Gender.MALE, BigDecimal.valueOf(5000),null),
                new User(4L,"Asel","Ilimov","asel@gmail.com","+996098765333", Gender.FEMALE, BigDecimal.valueOf(5000),null),
                new User(5L,"Masha","Sergeevna","masha@gmail.com","+996444555666", Gender.FEMALE, BigDecimal.valueOf(5000),null)
        ));
        List<Book> books = new ArrayList<>(List.of(
                new Book(1L,"Omyr", Genre.ROMANCE,BigDecimal.valueOf(1000),"Alykyl Osmonov", Language.KYRGYZ, LocalDate.of(2001,10,22)),
                new Book(2L,"Robot", Genre.FANTASY,BigDecimal.valueOf(2000),"Fred Alan", Language.ENGLISH, LocalDate.of(1999,10,22)),
                new Book(3L,"Toolor", Genre.FANTASY,BigDecimal.valueOf(500),"Chyngyz Aitmatov", Language.KYRGYZ, LocalDate.of(1985,10,22)),
                new Book(4L,"Rameo i Julietta", Genre.ROMANCE,BigDecimal.valueOf(800),"Uilliam Shekspir", Language.ENGLISH, LocalDate.of(1879,10,22)),
                new Book(5L,"Taras Bulba", Genre.HISTORICAL,BigDecimal.valueOf(600),"Lev Tolstoi", Language.RUSSIAN, LocalDate.of(1886,10,22))
        ));

        UserServiceImpl userService = new UserServiceImpl();
        BookServicrImpl bookServicr = new BookServicrImpl();

        System.out.println(userService.createUser(users));

        System.out.println(userService.findAllUsers());
//
//        System.out.println("Enter user ID: ");
//        System.out.println(userService.findUserById(new Scanner(System.in).nextLong()));
//
//        System.out.println("Enter user name: ");
//        System.out.println(userService.removeUserByName(new Scanner(System.in).nextLine()));

        userService.groupUsersByGender();

//        System.out.println("Enter book name: ");
//        System.out.println(userService.buyBooks(new Scanner(System.in).nextLine(), books));

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

//        System.out.println(bookServicr.createBooks(books));
//        System.out.println(bookServicr.getAllBooks());
//
//        System.out.println("Enter book id: ");
//        System.out.println(bookServicr.removeBookById(new Scanner(System.in).nextLong()));
//
//        System.out.println(bookServicr.sortBooksByPriceInDescendingOrder());
//
//        System.out.println("Enter genre: ");
//        System.out.println(bookServicr.getBooksByGenre(new Scanner(System.in).nextLine()));
//
//        System.out.println(bookServicr.getBookByInitialLetter());
//
//        System.out.println(bookServicr.maxPriceBook());

    }
}