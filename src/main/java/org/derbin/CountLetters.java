package org.derbin;
import java.util.*;

public class CountLetters {
    public static void main(String[] args) {
        String phrase = Arrays.toString(args);
        getPhrase(phrase);
    }

    private static void getPhrase(String s) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Put your phrase, please:");
        String phrase = scanner.nextLine();
        if (phrase.isEmpty() || s.isEmpty()) { //check if input isn't empty
            System.out.println("I'm so sorry but you entered empty string");
        } else {
            countLetters(phrase);
            countLetters(s);
        }
    }

    private static void countLetters(String s) {
        Map<Character, Integer> map = new HashMap<>(); //create map to store char - value
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); //get first char and so on in provided string
            if (c == ' ' || c == ',' || c == '.' || c == '[' || c == ']') continue; //counter doesn't include spaces
            if (map.containsKey(c)) { //check if specific char already appear
                map.put(c, map.get(c) + 1); //char already appear so increase counter value by 1
            } else {
                map.put(c, 1); //char doesn't appear so put it in map and set value to 1
            }
        }
        TreeMap<Character,Integer> treeMap = new TreeMap<>(map); //create treemap from map to sort it
        Iterator iterator = treeMap.keySet().iterator(); //iterate through key in this situation is a char
        while (iterator.hasNext()){ //if there is any key
            Character character=(Character) iterator.next(); //get this char and print it below
            System.out.println(character + " = " + map.get(character)); //printed value will be in alphabetical order
        }
        System.out.println("-----");
    }
}
