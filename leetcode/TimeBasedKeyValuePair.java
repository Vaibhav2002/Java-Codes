package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class TimeBasedKeyValuePair {

    private static class Data {
        String value;
        int timeStamp;

        public Data(String value, int timeStamp) {
            this.value = value;
            this.timeStamp = timeStamp;
        }
    }

    HashMap<String, ArrayList<Data>> map;

    public TimeBasedKeyValuePair() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Data(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        return floor(map.get(key), timestamp).value;
    }

    private Data floor(ArrayList<Data> list, int target){
        int l = 0, u = list.size() - 1;
        while(l<u){
            int mid = l+(u-l)/2;
            if(list.get(mid).timeStamp <= target) return list.get(mid);
            if(list.get(mid).timeStamp < target) l = mid;
            else u = mid-1;
        }
        return list.get(l);
    }
}
