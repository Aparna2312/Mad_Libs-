package madLibs;
import java.io.*;
import java.util.*;

public class MadLibs {

    public static void main(String[] args) throws FileNotFoundException {
        boolean playGame = true;
        Scanner console = new Scanner(System.in);


        System.out.println("Welcome to the game of MadLibs.");
        System.out.println("I will ask you to provide various words ");
        System.out.println("and phrases to fill a story.");
        System.out.println("The result will be written to an output file.");

        while (playGame == true) {
            playGame = menu(console);
        }

        System.out.println("Thanks for playing!");

    }

    public static boolean menu(Scanner console) throws FileNotFoundException {

        System.out.println("(C)reate mad-lib, (V)iew mad-lib, (Q)uit?");
        String answer = console.next();
        if (answer.charAt(0) == 'c' || answer.charAt(0) == 'C') {
            create(console);
            return true;
        }
        if (answer.charAt(0) == 'v' || answer.charAt(0) == 'V') {
            view(console);
            return true;
        }
        if (answer.charAt(0) == 'q' || answer.charAt(0) == 'Q') {
            return false;
        } else {
            System.out.println("Invalid answer. Please try again.");
            return true;
        }
    }

    public static void create(Scanner console) throws FileNotFoundException {

        System.out.println("Input file name: ");
        String nameIn = console.next();
        File f1 = new File(nameIn);
        while (!f1.exists()) {
            System.out.println("File not found. Try again: ");
            nameIn = console.next();
            //f1 = new File(nameIn);
        }
        System.out.println("Output file name: ");
        String nameOut = console.next();
        File out = new File(nameOut);
        PrintStream output = new PrintStream(out);

        Scanner input = new Scanner(f1);

        while (input.hasNextLine()) {
            String text = input.next();

            //System.out.print(text);
            //processLine(console, f1, nameOut);
            if (text.startsWith("<") && text.endsWith(">")) {
                //String x = input.next();
                char a = text.charAt(1);
                String anora = aOrAn(a);
                text = text.replace('<', ' ');
                text = text.replace('>', ' ');
                text = text.replace('-', ' ');
                System.out.println("Please type" + anora + text);
                String in = console.next();
                output.print(" " + in + " ");
            } else {
                output.print(" " + text + " ");
            }
        }

    }


    public static void view(Scanner console) throws FileNotFoundException {
        Scanner input = new Scanner(new File("simple.txt"));
        while (input.hasNextLine()) {
            String text = input.nextLine();
            //System.out.println(text);
            //processLine(text);

        }
        System.out.println();
    }
}
