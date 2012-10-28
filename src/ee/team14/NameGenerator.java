package ee.team14;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: taivo
 * Date: 10/28/12
 * Time: 11:37 AM
 * To change this template use File | Settings | File Templates.
 */
public class NameGenerator {

    private static String[] NAMES = {"Richard", "Gerrie", "Rikkert",
            "Robbie", "Barrie", "Manuela", "Henk", "Cop Adrie", "Deborah", "Corrie", "Down", "Dave"};

    public static String generate(){
        Random random = new Random();
        int randomNum = random.nextInt(NAMES.length);
        return NAMES[randomNum];
    }

}
