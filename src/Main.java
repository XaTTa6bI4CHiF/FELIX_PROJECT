import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Стараюсь понять как это работает");
    Scanner scanner = new Scanner(System.in);
    String vuvidNaEkran = "Veddit 1 chuslo";
    System.out.println(vuvidNaEkran);
    int a = scanner.nextInt();
    System.out.println("Veddit 2 chuslo");
    int b = scanner.nextInt();
    System.out.println("Summa = ");
    System.out.println(a+b);
    }
}