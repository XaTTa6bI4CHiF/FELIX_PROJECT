import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Стараюсь понять как это работает");
    boolean BooleanVariable = true;
    byte byteVariable = 127;

    char charVariable = '%';
    short felix = 158;
    int intVariable = 3231312;
    long longVariable = 321321312L;
    float floatVariable = 312.32f;
    double doubleVariable = 31231231.67d;

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