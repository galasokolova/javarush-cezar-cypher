package pt.com.javarush.cypher;

import java.io.IOException;
import java.util.Scanner;

public class RunCypherApplication {
    static String optionChoice;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Please, input\n   \"E\" for encoding\n   \"D\" for decoding");
            optionChoice = scanner.nextLine();
            try {
                if (optionChoice.equalsIgnoreCase("E")) {
                    System.out.println("Please, input:\n  \"F\" to encode a text file\n  \"T\" to encode a text in console");
                    optionChoice = scanner.nextLine();

                    chooseEncodingMode();
                    break;

                } else if (optionChoice.equalsIgnoreCase("D")) {

                    System.out.println("Please, input:\n  \"F\" to decode a text file with Cezar Cypher\n  \"T\" to decode a text in console with Cezar Cypher\n   \"B\" decode with Brute Force.");
                    optionChoice = scanner.nextLine();

                    chooseDecodingMode(scanner);
                    break;
                }
            } catch (Exception e) {
                System.err.println("Your answer is not valid :(");
                break;
            }

        }

    }

    private static void chooseDecodingMode(Scanner scanner) throws IOException {
        if (optionChoice.equalsIgnoreCase("F")) {
            FileEncoder.decodeFile();

        }else if (optionChoice.equalsIgnoreCase("T")){
            TextEncoder.decodeText();

        } else if (optionChoice.equalsIgnoreCase("B")){
            BruteForceMethod.guessPass();

        } else {
            System.out.println("Your answer is not valid :(");
        }
    }

    private static void chooseEncodingMode() throws IOException {
        if (optionChoice.equalsIgnoreCase("F")) {
            FileEncoder.encodeFile();

        } else if (optionChoice.equalsIgnoreCase("T")) {
            TextEncoder.encodeText();

        } else {
            System.err.println("Your answer is not valid :( ");
        }
    }
}
