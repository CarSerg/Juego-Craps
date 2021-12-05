package juegoCraps;

import java.util.Random;

/**
 * Class Dado generate a random value beween 1 and 6
 * @author Sergio Carmona 2042622
 * @version v1.0.0 date 30/11/21
 */
public class Dado {
    private int cara;

    /**
     * Method that generate an random value to cara
     * @return number between (1,6)
     */
    public int getCara() {
        Random aleatorio = new Random();
        cara = aleatorio.nextInt(6)+1;
        return cara;
    }
}
