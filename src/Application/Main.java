package Application;

import DataStructures.*;

import java.io.*;
import java.util.Scanner;

public class Main {
  // Objecte Scanner per obtenir la informacio de la consola.
  private static Scanner keyboard = new Scanner(System.in);
  //
  private static TADVocabulary vocabulary;

  // Main del programa.
  public static void main(String[] args) {
    vocabulary = new Trie();

    Main.vocabulary.add("home");
    Main.vocabulary.add("homeworkers");
    Main.vocabulary.add("homework");
    Main.vocabulary.add("mountain");

    BufferedReader file = null;
    String filePath;
    boolean valid = false;
    while (!valid) {
//      System.out.println("Indica el nom del fitxer:");
//      filePath = keyboard.nextLine();
      filePath = "Text1.txt";
      try {
        file = new BufferedReader(new FileReader(new File(filePath)));
        valid = true;
      } catch (FileNotFoundException e) {
        System.out.println("No s'ha trobat el fitxer indicat.");
      }
    }

    String line;
    try {
      while ((line = file.readLine()) != null) {
        if (line.matches("<Plana numero=\\d+>")) {
          System.out.println(line);
        }
      }
      file.close();
    } catch (IOException e) {
      System.out.println(e.toString());
    }
  }
}
