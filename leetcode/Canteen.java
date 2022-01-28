package leetcode;

import java.util.Stack;

public class Canteen {
    public int countStudents(int[] students, int[] sandwiches) {
        Stack<Integer> studentStack=new Stack<>();
        Stack<Integer> sandwichStack=new Stack<>();
        int no_of_students=students.length;
        for(int i:students)
            studentStack.push(i);
        for(int i:sandwiches)
            sandwichStack.push(i);
        int count=0;
        while(count!=no_of_students&&!sandwichStack.isEmpty()){
            if(studentStack.peek().equals(sandwichStack.peek())){
                studentStack.pop();
                sandwichStack.pop();
            }
            else
            {
                int x=studentStack.pop();
                studentStack.push(x);
                count++;
            }
        }
        return count;
    }
}
