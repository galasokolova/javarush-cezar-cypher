package pt.com.javarush.cypher;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class FileEncoder {


    public static void encodeFile() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please, input a path to encode your file.");
        String pathToFile = scanner.nextLine();

        StringBuilder stringBuilder = new StringBuilder();
        readText(pathToFile, stringBuilder);

        System.out.println("Please, input an integer key for encoding");
        int key = Integer.parseInt(scanner.nextLine());

        String encodedFile = CezarCypher.encoding(stringBuilder.toString(),key);

        System.out.println("Please, input a path to create a file.");
        String pathToNewFile = scanner.nextLine();

        writeToFile(pathToNewFile, encodedFile);
    }
    public static void decodeFile() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please, input a path to decode your file.");
        String pathToFile = scanner.nextLine();

        StringBuilder stringBuilder = new StringBuilder();
        readText(pathToFile, stringBuilder);

        System.out.println("Please, input an integer key for decoding");
        int key = Integer.parseInt(scanner.nextLine());

        String decodedFile = CezarCypher.decoding(stringBuilder.toString(),key);

        System.out.println("Please, input a path to create a file.");
        String pathToNewFile = scanner.nextLine();

        writeToFile(pathToNewFile, decodedFile);
    }


    private static void readText(String pathToFile, StringBuilder stringBuilder) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(pathToFile));
        if (Files.notExists(Path.of(pathToFile))){
            System.out.println("File does not exist");
        }else{
            String str;

            while ((str = br.readLine()) != null) {
                String[] arrayWords = str.split("\\s+");
                for (String s : arrayWords) {
                    stringBuilder.append(s).append(" ");
                }

            }
        }
    }

    public static void writeToFile(String pathToFile, String file) throws IOException {

        FileWriter fileWriter = new FileWriter(pathToFile);

        String[] arrayWords = file.split("\\s+");
        for (String textWords : arrayWords) {
            fileWriter.write(textWords +" ");
        }
        fileWriter.close();
    }

}
