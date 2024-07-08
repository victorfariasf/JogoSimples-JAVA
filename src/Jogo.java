
import java.util.Scanner;

public class Jogo {

    private Tabuleiro tabuleiro;
    private Entidade gamer;
    private int lugarDungeon = 0;

    public Jogo(Entidade gamer) {
        this.gamer = gamer;
    }

    public void IniciarJogo() {
        tabuleiro = new Tabuleiro(gamer);
        tabuleiro.PreencherTabuleiro();
    }

    public boolean ProximoEstagio(int lugarDungeon) {
        Scanner teclado = new Scanner(System.in);
        Entidade inimigo = tabuleiro.AndarNoTabuleiro(gamer);

        if (inimigo.name.equals("Boss Final")) {
            System.out.println("Um inimigo está adianta");
            System.out.println("***" + inimigo.name + "***");
            int jogadorAtual = 0;
            while (gamer.vida == 0 || inimigo.vida == 0) {

                Batalha batalha = new Batalha(gamer, inimigo);
                jogadorAtual = batalha.MenuBatalha(jogadorAtual, lugarDungeon);

                boolean comoEstaPartida = SituacaoBatalha(gamer, inimigo);
                if (comoEstaPartida == true) {
                    System.out.println("Fim de jogo");

                    teclado.nextLine();
                    ClearConsole c = new ClearConsole();
                    c.ClearConsole();
                    return true;
                }
                ClearConsole c = new ClearConsole();
                c.ClearConsole();
            }
        } else {
            System.out.println("Um inimigo está adianta");
            System.out.println("***" + inimigo.name + "***");
            int jogadorAtual = 0;
            while (gamer.vida != 0 || inimigo.vida != 0) {

                Batalha batalha = new Batalha(gamer, inimigo);
                jogadorAtual = batalha.MenuBatalha(jogadorAtual, lugarDungeon);
                boolean comoEstaPartida = SituacaoBatalha(gamer, inimigo);

                if (comoEstaPartida == true) {
                    System.out.println("Fim da batalha");

                    teclado.nextLine();
                    ClearConsole c = new ClearConsole();
                    c.ClearConsole();
                    return false;
                }
                System.out.println("Pressione ENTER para continuar");
                teclado.nextLine();
                ClearConsole c = new ClearConsole();
                c.ClearConsole();
            }
        }
        teclado.close();
        return false;
    }

    public boolean SituacaoBatalha(Entidade gamer, Entidade inimigo) {
        if (gamer.getVida() <= 0) {
            System.out.println(gamer.name + " morreu!");
            return true;
        } else if (inimigo.getVida() <= 0) {
            System.out.println(inimigo.name + " foi derrotado");
            return true;
        } else {
            return false;
        }
    }
}
