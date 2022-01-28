package testing;

import java.util.*;
import java.util.stream.Collectors;

public class AkshatBaulanaCode {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> first = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());
        Set<Integer> second = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toSet());
        List<Integer> ans = new LinkedList<>();
        for (int i = 0; i < first.size(); i++)
            if (!second.contains(i + 1))
                ans.add(first.get(i));
        System.out.println(ans.toString());
    }
}
