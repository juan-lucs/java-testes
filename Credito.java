public class Credito {
    double credito = 1000;
    double debito;
    double saldo = 500;

    private void setdebito(double deb) {
        if (deb > 0) {
        debito = deb;
    } else {
        System.out.println("Debito insuficiente.");
    }
    }

    private void descontar() {
        boolean avisoCreditoMostrado = false;
        while (saldo >= debito || credito >= debito) {
            if (saldo >= debito){
            saldo = saldo - debito;
            System.out.println("Debito realizado com sucesso, seu saldo atual é: " + saldo);
            } 
            else {
                if (!avisoCreditoMostrado) { 
                    System.out.println("\n\nSaldo insuficiente, utilizando o crédito para pagar.\n\n");
                    avisoCreditoMostrado = true; // mostra só na primeira vez
                }
            credito = credito + saldo;
            saldo = 0;
            credito = credito - debito;
            System.out.println("Debito realizado com sucesso, seu credito atual é: " + credito);
        }
        } 
         System.out.println("--------------------------------------------------------- \n\n");
        System.out.println("Impossível realizar o debito, saldo e credito insuficientes \n\n");
    }
    public static void main(String[] args) {
        Credito conta = new Credito();
        conta.setdebito(56.6);
        conta.descontar();
    }
  
}

