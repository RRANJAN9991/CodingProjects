//Rahul Ranjan ID# - 111448179
package programs;

import java.util.*;

public class LatComparator implements Comparator<City>{
    public int compare(City a, City b) {
        if (a.getLat() == b.getLat()) {
            return 0;
        }
        else if (a.getLat() > b.getLat()) {
            return 1;
        }
        else {
            return -1;
        }
    }
}
