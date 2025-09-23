public class Senha {
    public static void main(String[] args) {
        String senha = "12345";
        String tentativa = "12345";

        if (senha.equals(tentativa)) {
            System.out.println("Acesso permitido");
        } else {
            System.out.println("Acesso negado");
        }
    }
}
