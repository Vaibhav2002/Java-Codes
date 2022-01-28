package codechef;

import java.util.HashMap;
import java.util.Scanner;

public class IEMASSIGN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Character,String> full = new HashMap<>();
        full.put('A',"ACov(A)");
        full.put('B',"BCov(B)");
        full.put('C',"CCov(C)");
        full.put('D',"DCov(D)");
        full.put('E',"ECov(E)");
        full.put('F',"FCov(F)");
        HashMap<Character,String> Short = new HashMap<>();
        Short.put('A',"ACov");
        Short.put('B',"BCov");
        Short.put('C',"CCov");
        Short.put('D',"DCov");
        Short.put('E',"ECov");
        Short.put('F',"FCov");
        HashMap<Character, String> ann = new HashMap<>();
        ann.put('A',"(A)");
        ann.put('B',"(B)");
        ann.put('C',"(C)");
        ann.put('D',"(D)");
        ann.put('E',"(E)");
        ann.put('F',"(F)");
        double value = 0.0;
        String annotation="";
        String bef="";
        for (int i = 0; i < 6; i++) {
            String s = sc.nextLine();
            if(s.indexOf('(')!=-1) {
                annotation = s.substring(s.indexOf('('));
                bef=s.substring(0,s.indexOf('('));
            }
            else bef=s;
            if (full.containsValue(s)) {
                value += 1.0;
                Short.remove(s.charAt(0));
                ann.remove(s.charAt(0));
                full.remove(s.charAt(0));
            } else if (Short.containsValue(bef)) {
                value += 0.5;
                full.remove(bef.charAt(0));
                ann.remove(s.charAt(0));
                Short.remove(bef.charAt(0));
            } else if (ann.containsValue(annotation)) {
                full.remove(annotation.charAt(1));
                Short.remove(annotation.charAt(1));
                value += 0.5;
                ann.remove(annotation.charAt(1));
            }
        }
        System.out.println(value);
    }
}
