
import java.util.Random;

public class Bonus {

    private int bonusNumber;

    public void giveBonus() {
        Random random = new Random();
        bonusNumber = random.nextInt(1);

        if (bonusNumber == 0) {

        }
    }
}
