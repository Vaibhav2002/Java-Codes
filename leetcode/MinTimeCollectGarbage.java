package leetcode;

/**
* <a href="https://leetcode.com/problems/minimum-amount-of-time-to-collect-garbage/description/">Problem</a>
**/
public class MinTimeCollectGarbage{

    public int garbageCollection(String[] garbage, int[] travel) {

        for(int i = 1;i<travel.length;i++) travel[i]+=travel[i-1];

        int mIndex = 0, gIndex = 0, pIndex = 0;
        int mFreq = 0, gFreq = 0, pFreq = 0;

        for(int i = 0;i<garbage.length;i++) {
            int curMFreq = 0, curGFreq = 0, curPFreq = 0;
            for (char c : garbage[i].toCharArray()) {
                switch (c) {
                    case 'M' -> curMFreq++;
                    case 'G' -> curGFreq++;
                    case 'P' -> curPFreq++;
                }
                if(curMFreq != 0){
                    mFreq+=curMFreq;
                    mIndex = i;
                }
                if(curGFreq != 0){
                    gFreq+=curGFreq;
                    gIndex = i;
                }
                if(curPFreq != 0){
                    pFreq+=curPFreq;
                    pIndex = i;
                }
            }
        }
        int sum = ((mIndex == 0)? 0: travel[mIndex-1]) + mFreq;
        sum+= ((gIndex == 0)? 0: travel[gIndex-1]) + gFreq;
        sum+= ((pIndex == 0)? 0: travel[pIndex-1]) + pFreq;
        return sum;
    }
}
