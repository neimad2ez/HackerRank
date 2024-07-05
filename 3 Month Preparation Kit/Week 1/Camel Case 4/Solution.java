import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while (scan.hasNextLine()) {
            String string = "";
            list.clear();
            String str = scan.nextLine();
            String[] arr = str.split(";");
            if (arr[0].equals("S")) {
                if (arr[1].equals("M")) {
                    for (int i = 0; i < arr[2].length(); i++) {
                        if (Character.isUpperCase(arr[2].charAt(i))) {
                            String first = arr[2].substring(0, i);
                            list.add(first);
                            arr[2] = arr[2].substring(i, arr[2].length());
                        }
                    }
                    arr[2] = arr[2].substring(0, arr[2].length() - 2);
                    arr[2] = arr[2].toLowerCase();
                    list.add(arr[2]);
                } else if (arr[1].equals("C")) {
                    for (int i = 1; i < arr[2].length(); i++) {
                        if (Character.isUpperCase(arr[2].charAt(i))) {
                            String first = arr[2].substring(0, i);
                            first = first.toLowerCase();
                            list.add(first);
                            arr[2] = arr[2].substring(i, arr[2].length());
                        }
                    }
                    arr[2] = arr[2].toLowerCase();
                    list.add(arr[2]);
                } else if (arr[1].equals("V")) {
                    for (int i = 0; i < arr[2].length(); i++) {
                        if (Character.isUpperCase(arr[2].charAt(i))) {
                            String first = arr[2].substring(0, i);
                            list.add(first);
                            arr[2] = arr[2].substring(i, arr[2].length());
                        }
                    }
                    arr[2] = arr[2].toLowerCase();
                    list.add(arr[2]);
                }
                for (int i = 0; i < list.size(); i++) {
                    string = string + list.get(i) + " ";
                }
                System.out.println(string);
            } else if (arr[0].equals("C")) {
                if (arr[1].equals("V")) {
                    String[] split = arr[2].split(" ");
                    list.add(split[0]);
                    for (int i = 1; i < split.length; i++) {
                        split[i] = split[i].substring(0, 1).toUpperCase() + split[i].substring(1, split[i].length());
                        list.add(split[i]);
                    }
                } else if (arr[1].equals("C")) {
                    String[] split = arr[2].split(" ");
                    for (int i = 0; i < split.length; i++) {
                        split[i] = split[i].substring(0, 1).toUpperCase() + split[i].substring(1, split[i].length());
                        list.add(split[i]);
                    }
                } else if (arr[1].equals("M")) {
                    String[] split = arr[2].split(" ");
                    list.add(split[0]);
                    for (int i = 1; i < split.length; i++) {
                        split[i] = split[i].substring(0, 1).toUpperCase() + split[i].substring(1, split[i].length());
                        list.add(split[i]);
                    }
                    list.add("()");
                }
                for (int i = 0; i < list.size(); i++) {
                    string = string + list.get(i);
                }
                System.out.println(string);
            }
        
        }
    }
}