
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Enter yout name: ");
        String gamerName = teclado.nextLine();

        Entidade gamer = new Gamer(gamerName, 100, 35);
        int lugarDungeon = 0;
        boolean fimDeJogo = false;

        while (fimDeJogo == false) {
            Jogo partida = new Jogo(gamer);
            partida.IniciarJogo();
            System.out.println("Jogo iniciado");
            fimDeJogo = partida.ProximoEstagio(lugarDungeon);
            if (fimDeJogo == false) {
                if (gamer.getVida() < 50 && gamer.getVida() >= 1) {
                    gamer.ganharVida(20);
                    System.out.println("Um bônus de cura\nPressione ENTER para continuar");
                    teclado.nextLine();
                } else if (gamer.getVida() <= 0) {
                    System.out.println("Tente novamente");
                    fimDeJogo = true;
                }
                lugarDungeon++;
            }
        }

        System.out.println("Jogo finalizado");

    }
}
