

class Carro {
    String modelo;
    String marca;
    int anolançamento;
    int vel;

    void freiar (int freiar) {
        vel -= freiar;
        System.out.println("A velocidade atual é " + vel);
    }

    void acelerar (int aceleracao) {
        vel += aceleracao;
        System.out.println("A velocidade atual é " + vel);
    }
}

public class exemplopoo {
    public static void main(String[] args) {
        Carro c1 = new Carro();
        

        c1.modelo = "Uno";
        c1.marca = "Fiat";
        c1.anolançamento = 1983;
        c1.vel = 40;

        c1.freiar(20);
        c1.acelerar(90);
    }
}