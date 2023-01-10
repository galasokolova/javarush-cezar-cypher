package pt.com.javarush.cypher;

import java.util.ArrayList;

import static pt.com.javarush.cypher.TextEncoder.scanner;


public class BruteForceMethod {
    public static void guessPass(){
        System.out.println("Please, input an ORIGINAL PASSWORD to match");
        String originalPassword = scanner.nextLine();

        System.out.println("Please, input an encoded password.");
        String password = scanner.nextLine();

        String result = "";
        ArrayList<String> optionalPass = new ArrayList<>();
        for (int i = 0; i < CezarCypher.ABC.length(); i++) {

            optionalPass.add(CezarCypher.decoding(password, i));
            if (originalPassword.equalsIgnoreCase(optionalPass.get(i))) {
                result= originalPassword;
            }
        }
        System.out.println("The best match is:\n" + result);

    }

}
