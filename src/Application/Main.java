package Application;

import DataStructures.*;

import java.io.*;
import java.text.Normalizer;
import java.util.Collections;
import java.util.LinkedList;
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
  // Metode que s'asegura d'obtenir un int de consola i el retorna.
  private static int getOption(int options) {
    int option = -1;
    boolean valid = false;

    while (!valid) {
      try {
        option = Integer.parseInt(keyboard.nextLine());
        if (1 <= option && option <= options) valid = true;
        else System.out.println("Opcio no valida!");
      } catch (NumberFormatException e) {
        System.out.println("Opcio no valida!");
      }
    }
    return option;
  }
  // Main del programa.
  public static void main(String[] args) {
    // Estructura per guardar la informacio final.
    LinkedList<Node> output = new LinkedList<>();

    // Inicialitza el TAD.
    System.out.println("Indica el TAD a utilitzar:");
    System.out.println("\t1. Taula de dispersio");
    System.out.println("\t2. Arbre tipus trie");
    ADTVocabulary vocabulary;
    if (getOption(2) == 1) vocabulary = new Hash();
    else vocabulary = new Trie();

    // Llegeix el nom del fitxer.
    System.out.println("Indica el nom del fitxer:");
    String filePath = keyboard.nextLine();

    // Algorisme principal.
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
              word = word.substring(1, word.length());
              vocabulary.add(word);
              Node aux = new Node(word);
              aux.addInfo(numPlana+":"+numLinia);
              output.add(aux);
            } else if (vocabulary.contains(word)) {
              int index = output.indexOf(new Node(word));
              if (index >= 0 && index < output.size()) {
                output.get(index).addInfo(numPlana+":"+numLinia);
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

    // Imprimeix el resultat per consola.
    Collections.sort(output);
    for (Node node : output) {
      System.out.println(node);
    }
  }
}
