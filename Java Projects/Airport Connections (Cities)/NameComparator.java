//Rahul Ranjan ID# - 111448179
package programs;

import java.util.*;

public class NameComparator implements Comparator<City>{
    public int compare(City a, City b) {
        return (a.getName().compareTo(b.getName()));
    }
}

