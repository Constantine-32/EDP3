package Application;

import DataStructures.*;

import java.io.*;
import java.text.Normalizer;
import java.util.Scanner;

public class Main {
  // Objecte Scanner per obtenir la informacio de la consola.
  private static Scanner keyboard = new Scanner(System.in);
  // Retorna una copia de l'string pasada per parametre que tant sols conte caracters [a-z] espais i el caracter '$'.
  private static String normalizeString(final String string) {
    return Normalizer.normalize(string, Normalizer.Form.NFD).
            toLowerCase().
            replaceAll("’", " ").
            replaceAll("[^a-z $]", "");
  }
  // Main del programa.
  public static void main(String[] args) {
    TADVocabulary vocabulary = new Trie();
//    vocabulary.add("home");
//    vocabulary.add("homeworkers");
//    vocabulary.add("homework");
//    vocabulary.add("mountain");

    String filePath = "Text1.txt";
//    System.out.println("Indica el nom del fitxer:");
//    filePath = keyboard.nextLine();

    try (BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "Cp1252"))) {
      String line;
      int numPlana = 1;
      int numLinia = 1;

      while ((line = file.readLine()) != null) {
        if (line.matches("<Plana numero=\\d+>")) {
          numPlana = Integer.parseInt(line.replaceAll(".*(\\d+).*", "$1"));
          numLinia = 1;
        } else {
          line = normalizeString(line);
          Scanner scanner = new Scanner(line);
          scanner.useDelimiter(" ");
          while (scanner.hasNext()) {
            String word = scanner.next();
            if (word.charAt(0) == '$') {
              vocabulary.add(word.substring(1, word.length()));
              System.out.println(numPlana+":"+numLinia+":"+word.substring(1, word.length()));
            } else {
              if (vocabulary.contains(word)) {
                System.out.println(numPlana+":"+numLinia+":"+word);
              }
            }
          }
          numLinia++;
        }
      }
    } catch (FileNotFoundException e) {
      System.out.println("No s'ha trobat el fitxer indicat.");
    } catch (UnsupportedEncodingException e) {
      System.out.println("L'archiu utilitza una codificacio no esperada.");
    } catch (IOException e) {
      System.out.println(e.toString());
    }
  }
}
