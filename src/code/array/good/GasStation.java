package code.array.good;

import java.util.List;

/**
 * Created by rahul.ka on 16/10/16.
 */
public class GasStation {
    public int canCompleteCircuit(final List<Integer> gas, final List<Integer> cost) {
        int size = gas.size();
        if (size == 1) {
            if (gas.get(0)-cost.get(0) >= 0) return 0;
            return -1;
        }
        int start = 0;
        int end = 1;

        int petrol = gas.get(0)-cost.get(0);
        while (!(start == end && petrol >= 0)) {
            while (petrol <0  && start != end) {
                petrol -= gas.get(start)-cost.get(start);
                start = (start+1)%size;
                if (start == 0) return -1;
            }
            petrol += gas.get(end)-cost.get(end);
            end = (end+1)%size;
        }
        return start;

    }
}
