package one;

import java.sql.SQLOutput;
import java.util.Scanner;

public class PersonInfo {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Podaj imię");
        String firstName = scan.nextLine();
        System.out.println("Podaj nazwisko");
        String lastName = scan.nextLine();
        System.out.println("Podaj wiek");
        int age = scan.nextInt();
        System.out.println("Podaj pesel");
        String pesel = scan.nextLine();
        scan.nextLine();

        Person person1 = null;

        try {
            person1 = new Person(firstName, lastName, age, pesel);
        } catch (NameUndefinedException e) {
            e.printStackTrace();
            System.out.println("Złe imię bądź nazwisko");
        } catch (IncorrectAgeException e) {
            e.printStackTrace();
            System.out.println("Wiek nie może być mniejszy niż 0");
        }

        person1.showInfo();

    }

}
