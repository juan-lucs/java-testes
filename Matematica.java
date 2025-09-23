import java.util.Scanner;

public class Matematica {
    static int soma (int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o primeiro número: ");
        int a = sc.nextInt();
        System.out.println("Digite o segundo número: ");
        int b = sc.nextInt();
        System.out.println("A soma dos dois números é: " + Matematica.soma(a, b));
        sc.close();
    }
}
