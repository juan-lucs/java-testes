import java.util.Scanner;

public class Atv {

    private int getEntradaUsuario(String mensagem) {
        System.out.print(mensagem + ": ");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine()); // converte para int
    }

    private int cargahoraria(int entrada, int saida) {
        int totalhoras;
        if (saida >= entrada) {
            totalhoras = saida - entrada;
        } else {
           totalhoras = (24 - entrada) + saida;
        }
        return totalhoras;
    }

    public static void main(String[] args) {
        Atv conta = new Atv();

        int entrada = conta.getEntradaUsuario("Digite sua hora de entrada");
        int saida = conta.getEntradaUsuario("Digite sua hora de saída");

        int horas = conta.cargahoraria(entrada, saida);
        System.out.println("Total de horas trabalhadas: " + horas);
    }
}
