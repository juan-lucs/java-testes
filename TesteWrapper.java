import java.util.ArrayList;

public class TesteWrapper {
    public static void main(String[] args) {
        // ❌ Isso NÃO compila:
        // ArrayList<int> listaErrada = new ArrayList<>(); // erro, não pode tipo primitivo

        // ✔️ Correto: usar o wrapper Integer
        ArrayList<Integer> lista = new ArrayList<>();

        // Autoboxing: o Java converte int -> Integer automaticamente
        lista.add(10); // vira new Integer(10)
        lista.add(20);
        lista.add(30);

        System.out.println("Lista: " + lista); // [10, 20, 30]

        // Unboxing: o Java converte Integer -> int
        int soma = 0;
        for (Integer valor : lista) {
            soma += valor; // aqui cada "valor" é convertido pra int automaticamente
        }

        System.out.println("Soma: " + soma);
    }
}
