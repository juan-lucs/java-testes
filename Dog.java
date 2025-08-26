class Dog {
    String name;

    public static void main(String[] args) {
        // Cria um objeto Dog e o acessa
        Dog dog1 = new Dog();
        dog1.bark();
        dog1.name = "Bart";

        // Agora cria um array Dog
        Dog[] myDogs = new Dog[3]; //o 3 é a quantidade que vai ter no array
        // Insere alguns dogs nele
        myDogs[0] = new Dog();
        myDogs[1] = new Dog();
        myDogs[2] = dog1;

        // Agora acessa Dogs usando as referências do array
        myDogs[0].name = "Fred"; // nomeia as referencias do array
        myDogs[1].name = "Marge";

        // Hmmmm... qual é o nome de Dogs[2]?
        System.out.print("last dog's name is ");
        System.out.println(myDogs[2].name); //é o mesmo do dog 1 lá do começo

        // Agora itera com um loop o array
        // e instrui dogs a latir (bark)
        int x = 0;
        while (x < myDogs.length) {
            myDogs[x].bark();
            x = x + 1;
        }
    }

    public void bark() {
        System.out.println(name + " says Ruff!");
    }

    public void eat() { //exemplo
    }

    public void chaseCat() { //exemplo
    }
}
