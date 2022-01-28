package leetcode;

public class ExcelSheet {
    public String convertToTitle(int n) {
        String s="";
        while(n>0){
            if(n%26==0)
                s='Z'+s;
            else
                s=(char)(64+n%26)+s;
            n/=26;
            if(n==1)
                break;
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(new ExcelSheet().convertToTitle(701));
    }
}
