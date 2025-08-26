class Dog {
    int size;
    String breed;
    String name;

    void bark() {
        System.out.println("Ruff! Ruff!" + size);
    }
}


public class exemplopag36 {
    public static void main(String[] args) {
        Dog doo = new Dog();     // Cria um objeto Dog
        doo.size = 40;           // Usa o operador ponto (.) para definir o tamanho de Dog
        doo.bark();              // E chama seu método bark()
    }
}

