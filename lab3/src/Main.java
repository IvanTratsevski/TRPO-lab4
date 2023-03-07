import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("F(x)=x*x-5*x+4");
        Scanner inp = new Scanner(System.in);
        System.out.println("Введите левую границу");
        double l = inp.nextDouble();
        System.out.println("Введите правую границу");
        double r = inp.nextDouble();
        System.out.println("Введите эпсилон");
        double eps = inp.nextDouble();
        System.out.println(TernarySearch.Search(l, r, eps));
    }
}