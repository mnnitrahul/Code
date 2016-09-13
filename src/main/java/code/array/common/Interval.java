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
public class Interval {
    public int start; //needed public to run in interviewbit
    public int end; //needed public to run in interviewbit
    Interval() { start = 0; end = 0; }
}
