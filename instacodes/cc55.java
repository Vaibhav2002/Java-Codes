package instacodes;

import java.util.HashMap;
import java.util.Scanner;

public class cc55 {
    HashMap<String,Integer> house;
    static int n;
    Scanner sc=new Scanner(System.in);

    public cc55() {
        house =new HashMap<>();
        n=0;
    }
    public void addArmy(String houseName,int size)
    {
        Integer army=house.get(houseName);
        house.put(houseName,army==null?size:army+size);
    }
    public void attackOrJoin(String house1,String house2,boolean attackOrjoin)
    {
        Integer army1=house.get(house1),army2=house.get(house2);
        if(army1>army2) {
            if(attackOrjoin) house.put(house1,army1*2/3);
            else house.put(house1,army1+army2);
            house.remove(house2);
        }
        else{
            if(attackOrjoin) house.put(house2,army2*2/3);
            else house.put(house2,army1+army2);
            house.remove(house1);
        }
    }
    public void getWinner()
    {
        String winner="";
        if(house.size()==1){
            for(String s: house.keySet())
                winner=s;
        }
        if(!winner.equals(""))
        {
            System.out.println("Winner : "+winner);
            System.out.println("Enter 1 to play again or 0 to exit");
            n=sc.nextInt();
        }

    }
    public static void main(String[] args)
    {
        cc55 ob=new cc55();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter 1 to start game");
        n=sc.nextInt();
        while(n==1)
        {
            System.out.println("Enter 1 to attack\nEnter 2 to add army\nEnter 3 to join houses");
            int x=sc.nextInt();
            switch(x){
                case 1:
                    System.out.println("Enter team names");
                    ob.attackOrJoin(sc.next(),sc.next(),true);
                    ob.getWinner();
                    break;
                case 2:
                    System.out.println("Enter team name and army");
                    ob.addArmy(sc.next(),sc.nextInt());
                    break;
                case 3:
                    System.out.println("Enter team names");
                    ob.attackOrJoin(sc.next(),sc.next(),false);
                    ob.getWinner();
                    break;
            }
        }
    }

}
