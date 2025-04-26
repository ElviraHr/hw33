import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        List<BankAccount> bankAccounts = new ArrayList<>();
        bankAccounts.add(new BankAccount(new Person("Jan", "Jankowsky", "jan@gmail.com"), "DE12121212121212121", 32533.33));
        bankAccounts.add(new BankAccount(new Person("Irina", "Svetlova", "isvet@gmail.com"), "DE56565656565655", 80288.90));
        bankAccounts.add(new BankAccount(new Person("John", "Lennon", "lennon@gmail.com"), "DE77777777777777777", 55555.00));
        bankAccounts.add(new BankAccount(new Person("Anrey", "Ivanov", "aivanov@gmail.com"), "DE88888888888888888", 22222.00));
        bankAccounts.add(new BankAccount(new Person("Sergei", "Malovski", "smalovski@gmail.com"), "DE99999999999999991", 444444));
        bankAccounts.add(new BankAccount(new Person("Olga", "Pivovarova", "opivovarova@gmail.com"), "DE33333333333333333", 999999));


        System.out.println("All emails: " + transform(bankAccounts, s -> s.getOwner().getEmail()));

        System.out.println("--------------------");

        System.out.println("All owners:" + transform(bankAccounts, s -> s.getOwner()));

        System.out.println("--------------------");

        System.out.println(transform(bankAccounts, s -> s.getOwner().lName+ " " +
                                            s.getOwner().getfName().toUpperCase(Locale.ROOT).charAt(0) +".;IBAN"+
                                            s.getIBAN()+";"+
                                            s.getOwner().getEmail()+"\n"));

    }


    public static <T, R> List<R> transform(List<T> list, Function<T, R> function) {
        List<R> result = new ArrayList<>();
        for (T element : list) {
            result.add(function.apply(element));
        }

        return result;
    }
}



/*1.
Повторить и запомнить базовые функциональные интерфейсы: Predicate, Function, Consumer, Supplier, UnaryOperator.

2.
Дан список  BankAccount {Person owner, String IBAN, double balance). Класс Person состоит из {String fName, String lName String email)

необходимо получить
List всех email
получить List всех владельцев счетов
лист строк вида “Lennon J.;IBAN: DE199988643;lennon@gmail.com”    (т.е. ФИО; счет, email)

Естественно, все необходимые операции должен реализовывать один метод. Используйте стандартные функциональные интерфейсы. Для перебора списка используйте итератор.
*/