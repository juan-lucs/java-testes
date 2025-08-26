// Classe Produto com encapsulamento
class Produto {
    // Variáveis privadas — não podem ser acessadas diretamente de fora da classe
    private String nome;
    private double preco;

    // GET = "pegar" o valor da variável privada
    // SET = "definir" o valor da variável privada

    // Construtor -> é util para isso: "new Produto("Camiseta", 50.0);" ai eu não preciso chamar o set depois
    Produto(String nome, double preco) {
        this.nome = nome; //this aponta para o próprio objeto que está executando o código no momento
        this.preco = preco;
    }

    // Getter para 'nome'
    String getNome() {
        // Aqui poderíamos até fazer alguma lógica antes de retornar
        return nome;
    }

    // Setter para 'nome'
    void setNome(String nome) {
        // Aqui podemos validar antes de mudar
        if (nome != null && !nome.isEmpty()) {
            this.nome = nome; //this aponta para o próprio objeto que está executando o código no momento
        } else {
            System.out.println("Nome inválido.");
        }
    }

    // Getter para 'preco'
    double getPreco() {
        return preco;
    }

    // Setter para 'preco'
    void setPreco(double preco) {
        if (preco >= 0) {
            this.preco = preco;
        } else {
            System.out.println("Preço não pode ser negativo.");
        }
    }
}

 public class exemploencapsu {
    public static void main(String[] args) {
        Produto p1 = new Produto("Camiseta", 50.0);
        Produto p2 = new Produto("Camiseta", 50.0);
        Produto p3 = p1; // p3 aponta para o MESMO objeto que p1

        // Testando == (compara se é o mesmo OBJETO na memória)
        System.out.println("p1 == p2 ? " + (p1 == p2)); // false -> objetos diferentes
        System.out.println("p1 == p3 ? " + (p1 == p3)); // true -> mesma referência

        // Testando .equals() em Strings (compara o CONTEÚDO)
        System.out.println("p1.getNome().equals(p2.getNome()) ? " + p1.getNome().equals(p2.getNome())); // true -> conteúdo igual

        // Alterando valores usando setters
        p1.setNome("Camiseta Polo");
        p1.setPreco(60.0);

        // Mostrando valores usando getters
        System.out.println("Nome do p1: " + p1.getNome());
        System.out.println("Preço do p1: " + p1.getPreco());
    }
}