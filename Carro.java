public class Carro {
    String marca;
    String cor;
    String modelo;
    String placa;
    String nomeCliente;

    public Carro (String marca, String cor, String modelo, String placa, String nomeCliente) {
        this.marca = marca;
        this.cor = cor;
        this.modelo = modelo;
        this.placa = placa;
        this.nomeCliente = nomeCliente;
    }
    public void Exibitinfo(){
        System.out.println("marca: " + marca);
        System.out.println("cor: " + cor);
        System.out.println("modelo: " + modelo);
        System.out.println("placa: " + placa);
        System.out.println("nome do dono: " + nomeCliente);
    }

    public static void main(String[] args) {
        Carro c = new Carro("fiesta","vermelho","2012","AUC5505","Pênis");
        Carro b = new Carro("pejout","vermelho","2012","AUC5505","Pênis");
        Carro d = new Carro("mustang","vermelho","2012","AUC5505","Pênis");
        Carro e = new Carro("touro","vermelho","2012","AUC5505","Pênis");
        c.Exibitinfo();
        b.Exibitinfo();
        d.Exibitinfo();
        e.Exibitinfo();
    }
}


