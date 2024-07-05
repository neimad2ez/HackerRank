import java.io.*;
import java.util.*;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while (scan.hasNextLine()) {
            String string = ""; //Final substring to be outputted
            list.clear(); //Clears the list so that old results won't be stored
            String str = scan.nextLine(); //Finds string
            String[] arr = str.split(";"); //Splits by ";"
            if (arr[0].equals("S")) {
                if (arr[1].equals("M")) {
                    for (int i = 0; i < arr[2].length(); i++) { //Loops through whole of arr[2]
                        if (Character.isUpperCase(arr[2].charAt(i))) { //If upper case
                            String first = arr[2].substring(0, i); //adds first part of phrase e.g plastic
                            list.add(first);
                            arr[2] = arr[2].substring(i, arr[2].length()); //Deletes first string and arr[2] is now only arr[2] without first string
                        }
                    }
                    arr[2] = arr[2].substring(0, arr[2].length() - 2); //Removes "()"
                    arr[2] = arr[2].toLowerCase(); //Makes all of arr[2] lowercase
                    list.add(arr[2]); //Adds remainder of string into list e.g cup
                } else if (arr[1].equals("C")) {
                    for (int i = 1; i < arr[2].length(); i++) { //Loops through whole string except first character as it would make a substring between 0 and first letter
                        if (Character.isUpperCase(arr[2].charAt(i))) { //If uppercase
                            String first = arr[2].substring(0, i); //first substring e.g Large
                            first = first.toLowerCase(); //Make lowercase e.g large
                            list.add(first); //Add to list
                            arr[2] = arr[2].substring(i, arr[2].length()); //Deletes first string and arr[2] is now only arr[2] without first string
                        }
                    }
                    arr[2] = arr[2].toLowerCase(); //Makes last string lower case
                    list.add(arr[2]);
                } else if (arr[1].equals("V")) { 
                    for (int i = 0; i < arr[2].length(); i++) { //Loops through whole string
                        if (Character.isUpperCase(arr[2].charAt(i))) { //If uppercase
                            String first = arr[2].substring(0, i); //first substring e.g picture
                            list.add(first); //Add to list
                            arr[2] = arr[2].substring(i, arr[2].length()); //Deletes first string and arr[2] is now only arr[2] without first string e.g Frame
                        }
                    }
                    arr[2] = arr[2].toLowerCase(); //Makes lowercase e.g frame
                    list.add(arr[2]); //Adds to list
                }
                for (int i = 0; i < list.size(); i++) { //Loops through list
                    string = string + list.get(i) + " "; //As S, it means they have a space in between
                }
                System.out.println(string);
            } else if (arr[0].equals("C")) {
                if (arr[1].equals("V")) {
                    String[] split = arr[2].split(" "); //Split into seperate words as they are seperated by a space
                    list.add(split[0]); //Adds first substring e.g mobile
                    for (int i = 1; i < split.length; i++) { //For all substrings after
                        split[i] = split[i].substring(0, 1).toUpperCase() + split[i].substring(1, split[i].length()); //Capatalises first letter and adds the rest of the substring after e.g phone -> Phone
                        list.add(split[i]);//Add to list
                    }
                } else if (arr[1].equals("C")) {
                    String[] split = arr[2].split(" "); //Split into seperate words as they are seperated by a space
                    for (int i = 0; i < split.length; i++) { //For all substrings
                        split[i] = split[i].substring(0, 1).toUpperCase() + split[i].substring(1, split[i].length()); //Makes all substrings first letters capatalised e.g coffee machine -> CoffeeMachine
                        list.add(split[i]);
                    }
                } else if (arr[1].equals("M")) {
                    String[] split = arr[2].split(" "); //Split into seperate words as they are seperated by a space
                    list.add(split[0]); //Add first element to list e.g white
                    for (int i = 1; i < split.length; i++) { //For each element after first
                        split[i] = split[i].substring(0, 1).toUpperCase() + split[i].substring(1, split[i].length()); //Make first letter capital letter
                        list.add(split[i]); //Add to list
                    }
                    list.add("()"); //Add "()" to the end of the string
                }
                for (int i = 0; i < list.size(); i++) { //Loops through list
                    string = string + list.get(i); //As "C" means to combine it combines word
                }
                System.out.println(string);
            }
        
        }
    }
}