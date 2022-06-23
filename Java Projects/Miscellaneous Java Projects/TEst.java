/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programs;
import com.cse214.geocoder.GeocodeResponse;
import com.cse214.geocoder.Geocoder;  
import latlng.LatLng;
import java.io.*;
import java.util.*;


/**
 *
 * @author ranja
 */
public class TEst {
    public static void main(String[] args) {
        String x = "Use Excel and the RANDBETWEEN(1,300) function to generate: a) 100 random numbers, b) 100 samples of size 5, and c) 100 samples of size 20. For each sample in parts (b) and (c), find the sample means. Create histograms for parts (a), (b) and (c). For part (a) use the random numbers (i.e. sample size 1), for parts (b) and (c) use the sample means to create the histograms. Copy and Paste just the histograms into your homework paper. Explain the differences in the histograms. You can do this using R if you prefer.";
        String y = "Use Excel and the RANDBETWEEN(1,300) function to generate: a) 100 random numbers, b) 100 samples of size 5, and c) 100 samples of size 20. For each sample in parts (b) and (c), find the sample means. Create histograms for parts (a), (b) and (c). For part (a) use the random numbers (i.e. sample size 1), for parts (b) and (c) use the sample means to create the histograms. Copy and Paste just the histograms into your homework paper. Explain the differences in the histograms. You can do this using R if you prefer.";
        System.out.println(x.equals(y));
        ArrayList list = new ArrayList(10);
  
        System.out.println((int)Math.random() + 10);
    }
}
