class Aluno {
    private String nome;
    private int idade;

    void setNome(String nome) { // void porque não retorna nada
    if (nome != null && !nome.trim().isEmpty()) { // verifica se nome não é nulo e não está vazio e ignora espaços com .trim()
        this.nome = nome;
    } else {
        System.out.println("Nome inválido.");
    }
}

    void setIdade(int idade) {
        if (idade <= 0) {
             System.out.println("Idade inválida.");
        } else {
            this.idade = idade;
        }
    }

     int getIdade() { //não usa o void pois tem o return em baixo!!
        return idade;
    }

    String getNome() {  //não usa o void pois tem o return em baixo!!
    return nome;
    }

    // Construtor -> é util para isso: "new Aluno("carlos", 34)" ai eu não preciso chamar o set depois
    Aluno(String nome, int idade) {
    setNome(nome);   // já faz a validação de nulo/vazio
    setIdade(idade); // já faz a validação de idade
}
}




public class atvencapsu {
    public static void main(String[] args) {

    Aluno a1 = new Aluno("carlos", 34);
    Aluno a2 = new Aluno("carlos", 34);
    Aluno a3 = a1; //Apontando para o mesmo objeto que a1


    System.out.println("é pra ser false aqui: " + (a1 == a2));
    System.out.println("é pra ser true aqui: " + (a1 == a3));

    System.out.println("a1.getNome().equals(a2.getNome()) ? " + a1.getNome().equals(a2.getNome())); // true -> conteúdo igual


    a2.setNome("Eduardo");
    a2.setIdade(44);
    System.out.println("Agora o a2 tem o nome de " + a2.getNome() + " e idade de " + a2.getIdade());
    System.out.println("a1.getNome().equals(a2.getNome()) ? " + a1.getNome().equals(a2.getNome())); // false -> conteúdo mudou
}

}

    
