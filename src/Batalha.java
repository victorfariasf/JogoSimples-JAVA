
import java.util.Random;
import java.util.Scanner;

public class Batalha {

    private final Entidade gamer;
    private final Entidade inimigo;

    public Batalha(Entidade gamer, Entidade inimigo) {
        this.gamer = gamer;
        this.inimigo = inimigo;
    }

    public int MenuBatalha(int jogadorAtual, int lugarDungeon) {

        if (jogadorAtual == 0) {

            System.out.println("1. Atacar\t2. Curar");
            System.out.println("3. Golpe Especial");
            Hud(gamer, inimigo, lugarDungeon);
            Scanner teclado = new Scanner(System.in);
            int Jogada = teclado.nextInt();
            switch (Jogada) {
                case 1 -> {
                    Atacar(gamer, inimigo, jogadorAtual);
                    //Hud(gamer, inimigo, lugarDungeon);
                }
                case 2 -> {
                    Curar(gamer, inimigo, jogadorAtual);
                    //Hud(gamer, inimigo, lugarDungeon);
                }
                case 3 -> {
                    System.out.println(gamer.name + " irá usar a jogada especial");
                    boolean esquivou = JogadaEspecial(gamer, inimigo);
                    Atacar(gamer, inimigo, esquivou, jogadorAtual);
                    //Hud(gamer, inimigo, lugarDungeon);
                }
                default ->
                    throw new AssertionError();
            }
            return 1;
        } else {
            Random random = new Random();
            int jogadaDoInimigo = random.nextInt(3) + 1;
            Hud(gamer, inimigo, lugarDungeon);
            switch (jogadaDoInimigo) {
                case 1 -> {
                    Atacar(gamer, inimigo, jogadorAtual);
                    //Hud(gamer, inimigo, lugarDungeon);
                }
                case 2 -> {
                    Curar(gamer, inimigo, jogadorAtual);
                    //Hud(gamer, inimigo, lugarDungeon);
                }
                case 3 -> {
                    System.out.println(inimigo.name + " irá usar a jogada especial");
                    boolean esquivou = JogadaEspecial(gamer, inimigo);
                    Atacar(gamer, inimigo, esquivou, jogadorAtual);
                    //Hud(gamer, inimigo, lugarDungeon);

                }
                default ->
                    throw new AssertionError();
            }
            return 0;
        }
    }

    public void Atacar(Entidade gamer, Entidade inimigo, int jogadorAtual) {

        if (jogadorAtual == 0) {
            inimigo.receberDano(gamer.getAtaque());
            System.out.println(inimigo.getName() + " recebeu " + gamer.getAtaque() + " de dano");
        } else if (jogadorAtual == 1) {
            gamer.receberDano(inimigo.getAtaque());
            System.out.println(gamer.getName() + " recebeu " + inimigo.getAtaque() + " de dano");
        }
    }

    public void Atacar(Entidade gamer, Entidade inimigo, boolean especial, int jogadorAtual) {
        if (especial == true) {
            if (jogadorAtual == 0) {
                inimigo.receberDano(gamer.getAtaque() + 10);
                System.out.println(inimigo.getName() + " recebeu " + (gamer.getAtaque() + 10) + " de dano");
            } else if (jogadorAtual == 1) {
                gamer.receberDano(inimigo.getAtaque() + 10);
                System.out.println(gamer.getName() + " recebeu " + (inimigo.getAtaque() + 10) + " de dano");
            }
        }
        if (especial == false) {
            if (jogadorAtual == 0) {
                inimigo.receberDano(gamer.getAtaque() - 10);
                System.out.println(inimigo.getName() + " recebeu " + (gamer.getAtaque() - 10) + " de dano");
            } else if (jogadorAtual == 1) {
                gamer.receberDano(inimigo.getAtaque() - 10);
                System.out.println(gamer.getName() + " recebeu " + (inimigo.getAtaque() - 10) + " de dano");
            }
        }

    }

    public void Curar(Entidade gamer, Entidade inimigo, int jogadorAtual) {
        if (jogadorAtual == 0) {
            gamer.vida += (inimigo.ataque / 2);
            System.out.println(gamer.name + " curou " + inimigo.ataque / 2);
        } else {
            inimigo.vida += (gamer.ataque / 2);
            System.out.println(inimigo.name + " curou " + inimigo.ataque / 2);
        }
    }

    public boolean JogadaEspecial(Entidade gamer, Entidade inimigo) {
        int[] numerosDaSorte = new int[3];
        Random random = new Random();
        for (int i = 0; i < numerosDaSorte.length; i++) {
            numerosDaSorte[i] = random.nextInt(10);
        }
        int numeroSorteado = random.nextInt(10);
        for (int i = 0; i < numerosDaSorte.length; i++) {
            if (numeroSorteado == numerosDaSorte[i]) {
                System.out.println("Ataque especial ativado");
                return true;
            }
        }
        System.out.println("Ataque especial falhou");
        return false;
    }

    public void Hud(Entidade gamer, Entidade inimigo, int lugarDungeon) {
        System.out.println("--------------------------------------------------------------------------");
        System.out.println(gamer.getName() + "\nVida: " + gamer.getVida());
        System.out.println(inimigo.getName() + "\nVida: " + inimigo.getVida());
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Você está no " + lugarDungeon + " andar");

        /*Scanner teclado = new Scanner(System.in);
        teclado.nextLine();*/
    }

}
