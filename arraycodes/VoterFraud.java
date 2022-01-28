package arraycodes;

import java.util.HashSet;

public class VoterFraud {
    public boolean solve(int[][] votes) {
        HashSet<Integer> set=new HashSet<>();
        for(int i[]:votes){
            int voter_id=i[1];
            if(set.contains(voter_id))
                return true;
            set.add(voter_id);
        }
        return false;
    }
}
