package rcctechz;

import java.util.Scanner;

public class Iniials2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String name[] = sc.nextLine().split(" ");
            if (name.length < 2) System.out.println("Invalid name");
            else {
                String newName = "";
                for (int j = 0; j < name.length - 1; j++) {
                    newName += Character.toUpperCase(name[j].charAt(0)) + ".";
                }
                newName += name[name.length - 1];
                System.out.println(newName);
            }
        }
    }
}
