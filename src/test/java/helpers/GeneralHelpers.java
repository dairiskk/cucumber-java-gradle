package helpers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class GeneralHelpers {
    public static String[] positiveStringValues = {"is", "have", "has", "is visible"};

    public static boolean isStringTrue(String stringValue) {
        return Arrays.asList(positiveStringValues).contains(stringValue);
    }
}
