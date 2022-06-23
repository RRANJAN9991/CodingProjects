//Rahul Ranjan ID# - 111448179
package programs;

import java.util.*;

public class LngComparator implements Comparator<City>{
    public int compare(City a, City b) {
        if (a.getLng() == b.getLng()) {
            return 0;
        }
        else if (a.getLng() > b.getLng()) {
            return 1;
        }
        else {
            return -1;
        }
    }
}