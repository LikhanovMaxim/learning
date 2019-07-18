package learning.libs.ApacheCommonsLang;

import org.apache.commons.lang3.ArrayUtils;

public class App {
    public static void main(String[] args) {

        Integer[] pEmailDuplicates = null;
        if (!ArrayUtils.isEmpty(pEmailDuplicates)
                && pEmailDuplicates[0].equals(1)) {
            System.out.println("is not empty");
        } else {
            System.out.println("is empty");
        }
    }
}
