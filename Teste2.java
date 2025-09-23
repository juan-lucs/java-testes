class Aluno2 {
    int nome = 5;

    public String toString() {
        return "Aluno: " + nome;
    }
}
public class Teste2 {
    public static void main(String[] args) {
        Aluno2 a = new Aluno2();
        System.out.println(a.toString());
    }
}
