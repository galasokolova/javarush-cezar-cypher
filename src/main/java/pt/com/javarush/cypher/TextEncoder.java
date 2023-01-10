package pt.com.javarush.cypher;

import java.util.Scanner;

public class TextEncoder {
    static Scanner scanner = new Scanner(System.in);

    public static void encodeText(){

        System.out.println("Please, input a text pattern");
        String textPattern = scanner.nextLine();

        System.out.println("Please, input an integer key");
        int key = Integer.parseInt(scanner.nextLine());

        System.out.println(CezarCypher.encoding(textPattern, key));
    }

    public static void decodeText(){

        System.out.println("Please, input a text pattern");
        String textPattern = scanner.nextLine();

        System.out.println("Please, input an integer key");
        int key = scanner.nextInt();

        System.out.println(CezarCypher.decoding(textPattern, key));
    }


}
