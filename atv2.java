import java.util.Scanner;

public class atv2 {
    private String getEntradaUsuario(String mensagem) {
        System.out.println(mensagem + ": ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().toLowerCase();
    }

    private void verificar(String entrada){
        if (entrada.equals("bug")){
            System.err.println("Eu disse para você não digitar a palabra bug seu porra");
        } else {
            System.err.println("Obrigado por digitar.");
        }
    }


    public static void main(String[] args) {
        atv2 teste = new atv2();
        String entrada = teste.getEntradaUsuario("Digite algo que não seja a palabra bug");
        teste.verificar(entrada);
    }
}
