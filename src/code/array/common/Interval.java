package code.array.common;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Created by rahul.ka on 12/09/16.
 */

@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Interval implements Comparable<Interval>{
    public Integer start; //needed public to run in interviewbit
    public Integer end; //needed public to run in interviewbit
    Interval() { start = 0; end = 0; }

    @Override
    public int compareTo(Interval o) {
        return start.compareTo(o.start);
    }
}
