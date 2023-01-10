package pt.com.javarush.cypher;

public class CezarCypher {
    public static final String ABC = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя.,\":-!? ()";


    public static String encoding(String text, int shift){
        StringBuilder cypherText = new StringBuilder();
        int reducedShift = shift % ABC.length();
        char[] inputSymbols = text.toCharArray();


        for (char symbol : inputSymbols) {
            int indexInAbc = ABC.indexOf(symbol);
            int newIndex = ((indexInAbc + reducedShift) + ABC.length()) % ABC.length();
            cypherText.append(ABC.charAt(newIndex));
        }


        return cypherText.toString();
    }
    public static String decoding (String text, int shift){

        shift = shift * (-1);
        return encoding(text, shift);
    }

}

