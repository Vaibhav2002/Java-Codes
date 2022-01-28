package DP;

public class CountSortedVowelString {

    char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u'};

    public int countVowelStrings(int n) {
        return count(n, "");
    }
    public int count(int n, String s){
        if(n==0) return 1;
        char ending = s.charAt(s.length()-1);
        int startIndex = 0;
        if(ending == 'e') startIndex = 1;
        else if(ending == 'i') startIndex = 2;
        else if(ending == 'o') startIndex = 3;
        else startIndex = 4;
        int sum = 0;
        for(int i=startIndex;i<vowels.length;i++){
            sum+=count(n-1, s+vowels[i]);
        }
        return sum;
    }
}
