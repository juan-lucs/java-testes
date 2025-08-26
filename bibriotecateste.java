import java.util.Scanner;

public class bibriotecateste {
   public static void main(String[] args) {
    livro livro1 = new livro();
    livro livro2 = new livro();
    livro1.titulo = "It a coisa";
    livro1.autor ="Sthepen king";
    livro1.disponivel = true;
    livro2.titulo = "O exorcista";
    livro2.autor = "wiliam peter blatty";
    livro2.disponivel = false;

    Scanner scanner = new Scanner(System.in);

    System.out.print("Digite seu livro: ");
    String nome = scanner.nextLine();  // lê uma linha (texto)
    
    if (nome.equalsIgnoreCase(livro1.titulo)) {
            livro1.exibirDetalhes();
        } else if (nome.equalsIgnoreCase(livro2.titulo)) {
            livro2.exibirDetalhes();
        } else {
            System.out.println("Livro não encontrado no sistema.");
        }

    scanner.close();
   } 
}
class livro {
    String titulo;
    String autor;
    boolean disponivel;
    
    void exibirDetalhes() {
        System.out.println("Título: " +titulo);
        System.err.println("Autor: "+autor);
        if (disponivel) {
            System.out.println("Disponível para alugar.");
        } else {
            System.out.println("Já alugado, tente novamente em alguns dias. ");
        }
    }
}

