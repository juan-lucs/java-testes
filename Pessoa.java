public class Pessoa {
    String nome;
    int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public void exibir() {
        System.out.println("Nome: " +nome);
        System.out.println("idade: " +idade);
    }

    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa("João", 30);
        Pessoa pessoa2 = new Pessoa("Pênis", 15);
        pessoa1.exibir();
    }
}
