class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // int totalGas = Arrays.stream(gas).sum();
        // int totalCost = Arrays.stream(cost).sum();

        // if (totalCost > totalGas) return -1;

        // int tank = 0;
        // int result = 0;

        // for (int i = 0; i < gas.length; i++) {
        //     tank += (gas[i] - cost[i]);

        //     if (tank < 0) {
        //         tank = 0;
        //         result = i + 1;
        //     }
        // }

        // return result;        

        int size = gas.length - 1;
        int start = size;
        int end = 0;

        int tank = gas[start] - cost[start];
        while (start > end) {
            if (tank < 0) {
                start--;
                tank += gas[start] - cost[start];
            } else {
                tank += gas[end] - cost[end];
                end++;
            }
        }

        return tank >= 0 ? start : -1;
    }
}
