import java.util.ArrayList;
import java.util.Scanner;


public class Crud {
    Scanner sc = new Scanner(System.in);
    public ArrayList<String> nomes = new ArrayList<>();
    public ArrayList<Integer> id = new ArrayList<>();
    public ArrayList<String> senhas = new ArrayList<>();


    private void Criar() {
        System.out.println("Digite seu nome: ");
        String nome = sc.nextLine();
        System.out.println("Digite sua senha: ");
        String senha = sc.nextLine();
        boolean a = nomes.contains(nome);
        if (a == true) {
            System.out.println("Já existem usuários com esse nome!");
        } else {
            if (id.isEmpty() == true) {
                id.add(0);
            } 
            int u = id.get(id.size() - 1);
            id.add(u + 1);
            nomes.add(nome);
            senhas.add(senha);
            Dentro(nome, senha);
            }
    }


    private void Entrar() { 
        System.out.println("Digite seu nome: ");
        String nome = sc.nextLine();
        System.out.println("Digite sua senha: ");
        String senha = sc.nextLine();
        boolean a = nomes.contains(nome);
        boolean b = senhas.contains(senha);
        if (a == true && b == true) {
            Dentro(nome, senha);
        } else {
            System.out.println("Nome ou senha incorretos");
        }
    }

    private void Dentro(String nome, String senha) {
        System.out.println("Entrou com sucesso! \n\n Caso queria sair aperte 1, caso queira alterar seu nome ou senha aperte 2 e caso querira deletar a conta aperte 3.");
            int h = sc.nextInt();
            if (h == 1) {
                Fechar();
            } else if (h == 2) {
                Alterar(nome, senha);
            } else if (h == 3){
                Deletar(nome, senha);
            } else{
                System.out.println("Digite um numerp correto seu filha da puta");
            }
    }


    private void Deletar(String nome, String senha) {
       int a = nomes.lastIndexOf(nome);
       id.remove(a); // remove o id na mesma posção que o nome (ambos são criados juntos)
       nomes.remove(nome);
       senhas.remove(senha);
    }

    private void Alterar(String nome, String senha) {
        int a = nomes.lastIndexOf(nome);
        System.out.println("Digite seu novo nome: ");
        String teste = sc.nextLine();
        nomes.set(a, teste);
        System.out.println("Digite sua nova senha: ");
        String teste2 = sc.nextLine();
        senhas.set(a, teste2);
        System.out.println("Seu novo nome é: " + teste + " e sua nova senha é " + teste2);
    }

    private void Fechar() {
        System.exit(0);
    }

    private void Inicio() {
        System.out.println("Digite 1 caso queira entrar na sua conta. \n\n Digite 2 para se registrar \n\n Digite 3 para sair.");
        int i = sc.nextInt();
        
        if (i == 1){
            Entrar();
        } else if (i == 2){
            Criar();
        } else if (i == 3) {
            Fechar();
        }
        sc.close();
    }
    

    public static void main(String[] args) {
        Crud e = new Crud();
        e.Inicio();
}
}
