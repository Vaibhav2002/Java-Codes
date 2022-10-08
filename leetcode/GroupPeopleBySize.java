package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
* <a href="https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/description/">Problem</a>
**/
public class GroupPeopleBySize {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        var map = new HashMap<Integer, List<Integer>>();
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i< groupSizes.length;i++){
            map.putIfAbsent(groupSizes[i], new ArrayList<>());
            var group = map.get(groupSizes[i]);
            group.add(i);
            if(group.size() == i){
                ans.add(group);
                map.remove(groupSizes[i]);
            }
        }
        return ans;
    }
}
