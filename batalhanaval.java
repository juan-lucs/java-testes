import java.util.Scanner;
import java.util.ArrayList;
class GameHelper {
  public int getUserInput(String prompt) {
    System.out.print(prompt + ": ");
    Scanner scanner = new Scanner(System.in);
    return scanner.nextInt();
  }
}

class Localizacaonavios {
    ArrayList<Integer> locais; //Integer transforma int (primitivo) em um objeto
    int tentativas = 0;
    int numero;
    int acertos = 0;
    boolean jogo = true;

    void aleatorio() {
        locais = new ArrayList<>();
        numero = (int) (Math.random() * 5);
        locais.add(numero);
        locais.add(numero +1);
        locais.add(numero+2);
    }

    String verResp(int resp) {
    for (int j = 0; j < locais.size(); j++) {   // percorre os índices da lista
        if (resp == locais.get(j)) {            // pega o valor da posição j
            tentativas++;
            acertos++;
            locais.remove(j);                   // remove pelo índice
            if (acertos >= 3) {
                jogo = false;
                return "acertou o último navio! Fim de jogo. Número de tentativas: " + tentativas;
            }
            return "acertou!";
        }
    }
    tentativas++;
    return "errou!";
}
}



public class batalhanaval {
  public static void main(String[] args) {
    Localizacaonavios comecar = new Localizacaonavios();
    comecar.aleatorio();
    GameHelper helper = new GameHelper();
    while (comecar.jogo) {
      int guess = helper.getUserInput("digite um número");
      String result = comecar.verResp(guess);
      System.out.println(result);
    }
}
  }
    



