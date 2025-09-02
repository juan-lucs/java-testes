import java.util.Scanner;

public class atv3 {

    private int getEntradaUsuario(String mensagem) {
        System.out.print(mensagem + ": ");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine()); // converte para int
    }

    private void contagem(int entrada) {
        int contagem = 0;
    for (; entrada > 0; entrada--){
        contagem++;
        System.out.println("Adiconando mais uma linha, contagem atual: " + contagem);
    }
    System.err.println("\n -------------------------------------------------------------------------------------------------------");
    System.err.println("\n\n\n Fim da contagem");
    }
    
    public static void main(String[] args) {
        atv3 a = new atv3();
        int entrada = a.getEntradaUsuario("Digite um número de linhas");
        a.contagem(entrada);
    }
}