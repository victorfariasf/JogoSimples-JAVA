
public abstract class Entidade {

    public String name;
    public int vida;
    public int ataque;

    public Entidade(String name, int vida, int ataque) {
        this.name = name;
        this.vida = vida;
        this.ataque = ataque;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void receberDano(int dano) {
        this.vida -= dano;
    }

    public void ganharVida(int bonusDeVida) {
        this.vida += bonusDeVida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

}
