package leetcode;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++)
            if (isPossible(i, i, 0, gas, cost, true)) return i;
        return -1;
    }

    public boolean isPossible(int index, int start, int curGas, int[] gas, int[] cost, boolean isStart) {
        if (!isStart && index == start) return true;
        curGas += gas[index] - cost[index];
        if (curGas < 0) return false;
        return isPossible((index + 1) % gas.length, start, curGas, gas, cost, false);
    }
}
