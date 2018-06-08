package helpers;

/**
 * TestHelper
 */
public class TestHelper {

    public static String generate1260CharsString(){
        String heavySearchValue = "";
        String valueToAdd = "coche";
        for (int i=1; i <= 252; i++){
            heavySearchValue += valueToAdd;
        }
        return heavySearchValue;
    }


}
