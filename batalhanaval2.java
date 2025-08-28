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
    private static final String ALFABETO = "abcdefg";
    private static final int TAMANHO_GRADE = 7;
    private static final int TAMANHO_TOTAL = 49;
    private static final int MAX_TENTATIVAS = 200;
    static final int INCREMENTO_HORIZONTAL = 1;
    static final int INCREMENTO_VERTICAL = TAMANHO_GRADE;

    private final int[] grade = new int[TAMANHO_TOTAL];
    private final Random random = new Random();
    private int contadorNavios = 0;

    public String getEntradaUsuario(String mensagem) {
        System.out.println(mensagem + ": ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().toLowerCase();
    }

    public ArrayList<String> posicionarNavio(int tamanhoNavio) {
        int[] coordenadasNavio = new int[tamanhoNavio];
        int tentativas = 0;
        boolean sucesso = false;
        contadorNavios++;
        int incremento = getIncremento();

        while (!sucesso && tentativas++ < MAX_TENTATIVAS) {
            int localizacao = random.nextInt(TAMANHO_TOTAL);

            for (int i = 0; i < coordenadasNavio.length; i++) {
                coordenadasNavio[i] = localizacao;
                localizacao += incremento;
            }
            if (navioCabe(coordenadasNavio, incremento)) {
                sucesso = posicaoDisponivel(coordenadasNavio);
            }
        }
        salvarNaGrade(coordenadasNavio);
        ArrayList<String> celulasAlpha = converterCoordenadas(coordenadasNavio);
        return celulasAlpha;
    }

    private boolean navioCabe(int[] coordenadasNavio, int incremento) {
        int ultimaLocalizacao = coordenadasNavio[coordenadasNavio.length - 1];
        if (incremento == INCREMENTO_HORIZONTAL) {
            return calcularLinha(coordenadasNavio[0]) == calcularLinha(ultimaLocalizacao);
        } else {
            return ultimaLocalizacao < TAMANHO_TOTAL;
        }
    }

    private boolean posicaoDisponivel(int[] coordenadasNavio) {
        for (int coord : coordenadasNavio) {
            if (grade[coord] != 0) {
                return false;
            }
        }
        return true;
    }

    private void salvarNaGrade(int[] coordenadasNavio) {
        for (int indice : coordenadasNavio) {
            grade[indice] = 1;
        }
    }

    private ArrayList<String> converterCoordenadas(int[] coordenadasNavio) {
        ArrayList<String> celulasAlpha = new ArrayList<String>();
        for (int indice : coordenadasNavio) {
            String coordenadaAlpha = getCoordenadaAlpha(indice);
            celulasAlpha.add(coordenadaAlpha);
        }
        return celulasAlpha;
    }

    private String getCoordenadaAlpha(int indice) {
        int linha = calcularLinha(indice);
        int coluna = indice % TAMANHO_GRADE;
        String letra = ALFABETO.substring(coluna, coluna + 1);
        return letra + linha;
    }

    private int calcularLinha(int indice) {
        return indice / TAMANHO_GRADE;
    }

    private int getIncremento() {
        if (contadorNavios % 2 == 0) {
            return INCREMENTO_HORIZONTAL;
        } else {
            return INCREMENTO_VERTICAL;
        }
    }
}
