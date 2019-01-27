import controller.ConverterControllerImpl;
import model.TIDConverterImpl;

import java.io.InputStreamReader;

/**
 * Class for the main method
 */
public final class ConverterMain {
    /**
     * The main method. Arguments must be phrased as "G7TID 'int'", "TID 'int' G7TID 'int'"
     * or as "G7TID 'int' TID 'int'".
     *
     * @param args the input from the user.
     */
    public static void main(String[] args) {
        if (args.length == 2) {
            if ("G7TID".equals(args[0])
                    && isInteger(args[1])) {
                new ConverterControllerImpl(new InputStreamReader(System.in), System.out).play(
                        new TIDConverterImpl(Integer.parseInt(args[1])));
            } else {
                throw new IllegalArgumentException("Invalid input.");
            }
        } else if (args.length == 4
                && isInteger(args[1])
                && isInteger(args[3])) {
            if ("G7TID".equals(args[0])
                    && "TID".equals(args[2])) {
                new ConverterControllerImpl(new InputStreamReader(System.in), System.out).play(
                        new TIDConverterImpl(Integer.parseInt(args[1]), Integer.parseInt(args[3])));
            } else if ("G7TID".equals(args[2])
                    && "TID".equals(args[0])) {
                new ConverterControllerImpl(new InputStreamReader(System.in), System.out).play(
                        new TIDConverterImpl(Integer.parseInt(args[3]), Integer.parseInt(args[1])));
            } else {
                throw new IllegalArgumentException("Invalid input.");
            }
        }
    }

    /**
     * Helper method for checking if an argument in args[] can be parsed as an integer. Useful in
     * cleaning up my if statements and catching the Exceptions.
     *
     * @param s Element of the String array args[] to be parsed as an Integer.
     * @return true or false depending on whether it is an integer or not, depending on succesfull
     * parsing.
     */
    private static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (Exception e) {
            return false;
        }
        // only reach here if we didn't catch an exception
        return true;
    }
}
