package DP;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(List.of(1));
        if (numRows == 1) return list;
        list.add(List.of(1, 1));
        if (numRows == 2) return list;
        fill(2, numRows, list);
        return list;
    }

    public void fill(int rowNum, int max, List<List<Integer>> val) {
        if (rowNum >= max) return;
        val.add(new ArrayList<>());
        for (int i = 0; i <= rowNum; i++) {
            int sum = 0;
            if (i - 1 >= 0) sum += val.get(rowNum - 1).get(i - 1);
            if (i < val.get(rowNum - 1).size()) sum += val.get(rowNum - 1).get(i);
            val.get(rowNum).add(sum);
        }
        fill(rowNum + 1, max, val);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PascalTriangle ob = new PascalTriangle();
        System.out.println(ob.generate(30).toString());
    }
}
