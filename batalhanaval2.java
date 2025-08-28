import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BatalhaNaval2 {
    private AuxiliarJogo auxiliar = new AuxiliarJogo();
    private ArrayList<Navio> navios = new ArrayList<Navio>();
    private int numeroDeTentativas = 0;

    private void iniciarJogo() {
        Navio um = new Navio();
        um.setNome("poniez");
        Navio dois = new Navio();
        dois.setNome("hacqi");
        Navio tres = new Navio();
        tres.setNome("cabista");

        navios.add(um);
        navios.add(dois);
        navios.add(tres);

        System.out.println("Seu objetivo é afundar três navios.");
        System.out.println("poniez  hacqi  cabista");
        System.out.println("Tente afundar todos com o menor número de tentativas.");

        for (Navio navio : navios) {
            ArrayList<String> novaLocalizacao = auxiliar.posicionarNavio(3);
            navio.setLocalizacao(novaLocalizacao);
        }
    }

    private void jogar() {
        while (!navios.isEmpty()) {
            String palpiteUsuario = auxiliar.getEntradaUsuario("Digite sua tentativa");
            verificarPalpite(palpiteUsuario);
        }
        finalizarJogo();
    }

    private void verificarPalpite(String palpiteUsuario) {
        numeroDeTentativas++;
        String resultado = "erro";

        for (Navio navio : navios) {
            resultado = navio.verificarAcerto(palpiteUsuario);

            if (resultado.equals("acerto")) {
                break;
            }
            if (resultado.equals("afundou")) {
                navios.remove(navio);
                break;
            }
        }
        System.out.println(resultado);
    }

    private void finalizarJogo() {
        System.out.println("Todos os navios foram derrotados! Você venceu!");
        if (numeroDeTentativas <= 18) {
            System.out.println("Você precisou de apenas " + numeroDeTentativas + " tentativas.");
            System.out.println("Você saiu antes que seus navios afundassem.");
        } else {
            System.out.println("Demorou demais. " + numeroDeTentativas + " tentativas.");
            System.out.println("Os peixes estão dançando com seus navios.");
        }
    }

    public static void main(String[] args) {
        BatalhaNaval2 jogo = new BatalhaNaval2();
        jogo.iniciarJogo();
        jogo.jogar();
    }
}


class Navio {
    private ArrayList<String> localizacao;
    private String nome;

    public void setLocalizacao(ArrayList<String> loc) {
        localizacao = loc;
    }

    public void setNome(String n) {
        nome = n;
    }

    public String verificarAcerto(String entradaUsuario) {
        String resultado = "erro";
        int indice = localizacao.indexOf(entradaUsuario);
        if (indice >= 0) {
            localizacao.remove(indice);

            if (localizacao.isEmpty()) {
                resultado = "afundou";
                System.out.println("Você afundou o navio " + nome + "!");
            } else {
                resultado = "acerto";
            }
        }
        return resultado;
    }
}


class AuxiliarJogo {
    
    // private = é só acessível dentro de AuxiliarJogo, outras classes não podem mexer nele diretamente.
    // final = significa que o valor não pode ser alterado depois de inicializado
    // static = Todos os objetos compartilham o mesmo valor.

    // Letras das colunas (0 → 'a', 1 → 'b', ..., 6 → 'g')
    private static final String ALFABETO = "abcdefg";

    // A grade é 7x7, logo tem 49 casas numeradas de 0 até 48
    private static final int TAMANHO_GRADE = 7;
    private static final int TAMANHO_TOTAL = 49;

    // Quantas tentativas no máximo para encontrar uma posição válida para o navio
    private static final int MAX_TENTATIVAS = 200;

    // Incrementos usados para posicionar navios na horizontal ou vertical
    static final int INCREMENTO_HORIZONTAL = 1;       // anda +1 (lado a lado)
    static final int INCREMENTO_VERTICAL = TAMANHO_GRADE; // anda +7 (linha de baixo)

    // Representa a grade: 0 = vazio, 1 = ocupado
    private final int[] grade = new int[TAMANHO_TOTAL];

    // Gerador de números aleatórios
    private final Random random = new Random();

    // Conta quantos navios já foram posicionados
    private int contadorNavios = 0;

    // -------------------------------------------------------------------
    // Lê a entrada do usuário no console e devolve como string minúscula
    // -------------------------------------------------------------------
    public String getEntradaUsuario(String mensagem) {
        System.out.println(mensagem + ": ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().toLowerCase();
    }

    // -------------------------------------------------------------------
    // Tenta posicionar um navio de "tamanhoNavio" casas na grade.
    // Devolve as posições no formato "a3", "b4", etc.
    // -------------------------------------------------------------------
    public ArrayList<String> posicionarNavio(int tamanhoNavio) {
        int[] coordenadasNavio = new int[tamanhoNavio]; // guarda os índices numéricos do navio
        int tentativas = 0; // quantas tentativas já foram feitas
        boolean sucesso = false; // já conseguiu posicionar?

        contadorNavios++; // aumenta contador (usado para alternar orientação)
        int incremento = getIncremento(); // define se será horizontal (1) ou vertical (7)

        // tenta até achar posição válida ou estourar o limite de tentativas
        while (!sucesso && tentativas++ < MAX_TENTATIVAS) {
            // escolhe aleatoriamente a primeira casa
            int localizacao = random.nextInt(TAMANHO_TOTAL);

            // gera as casas seguintes do navio somando o incremento
            for (int i = 0; i < coordenadasNavio.length; i++) {
                coordenadasNavio[i] = localizacao;
                localizacao += incremento;
            }

            // verifica se cabe na grade e se as casas estão livres
            if (navioCabe(coordenadasNavio, incremento)) {
                sucesso = posicaoDisponivel(coordenadasNavio);
            }
        }

        // marca as casas na grade como ocupadas
        salvarNaGrade(coordenadasNavio);

        // converte os índices numéricos para coordenadas tipo "a3"
        ArrayList<String> celulasAlpha = converterCoordenadas(coordenadasNavio);
        return celulasAlpha;
    }

    // -------------------------------------------------------------------
    // Verifica se o navio cabe dentro da grade
    // -------------------------------------------------------------------
    private boolean navioCabe(int[] coordenadasNavio, int incremento) {
        int ultimaLocalizacao = coordenadasNavio[coordenadasNavio.length - 1];

        if (incremento == INCREMENTO_HORIZONTAL) {
            // Se for horizontal, a primeira e a última casa devem estar na mesma linha
            return calcularLinha(coordenadasNavio[0]) == calcularLinha(ultimaLocalizacao);
        } else {
            // Se for vertical, a última posição deve ser menor que 49 (não saiu da grade)
            return ultimaLocalizacao < TAMANHO_TOTAL;
        }
    }

    // -------------------------------------------------------------------
    // Verifica se todas as casas estão livres (sem outro navio)
    // -------------------------------------------------------------------
    private boolean posicaoDisponivel(int[] coordenadasNavio) {
        for (int coord : coordenadasNavio) {
            if (grade[coord] != 0) { // já ocupado?
                return false;
            }
        }
        return true;
    }

    // -------------------------------------------------------------------
    // Marca na grade as casas ocupadas pelo navio
    // -------------------------------------------------------------------
    private void salvarNaGrade(int[] coordenadasNavio) {
        for (int indice : coordenadasNavio) {
            grade[indice] = 1;
        }
    }

    // -------------------------------------------------------------------
    // Converte índices numéricos (ex.: 15) para coordenadas legíveis (ex.: "b2")
    // -------------------------------------------------------------------
    private ArrayList<String> converterCoordenadas(int[] coordenadasNavio) {
        ArrayList<String> celulasAlpha = new ArrayList<String>();
        for (int indice : coordenadasNavio) {
            String coordenadaAlpha = getCoordenadaAlpha(indice);
            celulasAlpha.add(coordenadaAlpha);
        }
        return celulasAlpha;
    }

    // -------------------------------------------------------------------
    // Converte UM índice (0..48) em coordenada tipo "a0", "b3" etc.
    // -------------------------------------------------------------------
    private String getCoordenadaAlpha(int indice) {
        int linha = calcularLinha(indice);          // linha = divisão inteira por 7
        int coluna = indice % TAMANHO_GRADE;        // coluna = resto da divisão por 7
        String letra = ALFABETO.substring(coluna, coluna + 1); // pega a letra da coluna
        return letra + linha;                       // junta letra + número da linha
    }

    // -------------------------------------------------------------------
    // Calcula a linha correspondente a um índice (0..48)
    // -------------------------------------------------------------------
    private int calcularLinha(int indice) {
        return indice / TAMANHO_GRADE; // ex: índice 15 → linha 2
    }

    // -------------------------------------------------------------------
    // Define a orientação do próximo navio
    // Alterna: 1º vertical, 2º horizontal, 3º vertical, ...
    // -------------------------------------------------------------------
    private int getIncremento() {
        if (contadorNavios % 2 == 0) {
            return INCREMENTO_HORIZONTAL;
        } else {
            return INCREMENTO_VERTICAL;
        }
    }
}
