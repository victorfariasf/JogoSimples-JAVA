
import java.util.Random;

public class Tabuleiro {

    private Entidade[] tabuleiro = new Entidade[5];
    private Entidade gamer;
    private Entidade goblin;
    private Entidade minotauro;
    private Entidade bossFinal;
    private int i = 0;

    public Tabuleiro(Entidade gamer) {
        this.gamer = gamer;
    }

    public void PreencherTabuleiro() {
        Random random = new Random();

        for (int i = 0; i < tabuleiro.length; i++) {
            int qualInimigo = random.nextInt(2) + 1;
            if (qualInimigo == 1) {
                goblin = new Goblin("Goblin", 100, 20);
                tabuleiro[i] = goblin;
            } else {
                minotauro = new Minotauro("Minotauro", 100, 35);
                tabuleiro[i] = minotauro;
            }
        }

        bossFinal = new Boss("Boss Final", 100, 40);
        tabuleiro[tabuleiro.length - 1] = bossFinal;

    }

    public Entidade AndarNoTabuleiro(Entidade gamer) {

        for (i = 0; i < tabuleiro.length;) {
            if (i == tabuleiro.length - 1) {
                System.out.println("Partida Final");
                if (tabuleiro[i] != null) {
                    i++;
                    return tabuleiro[i];
                }
            } else {
                if (tabuleiro[i] != null) {
                    i++;
                    return tabuleiro[i];
                }
            }
        }

        System.out.println("Nenhum mob encontrado");
        return null;
    }

}
