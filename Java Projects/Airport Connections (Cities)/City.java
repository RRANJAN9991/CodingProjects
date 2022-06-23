//Rahul Ranjan ID# - 111448179
package programs;

import com.cse214.geocoder.GeocodeResponse;
import com.cse214.geocoder.Geocoder;  
import latlng.LatLng;

public class City {
    
    private String name;
    private LatLng location; 
    private double lat, lng;
    private int indexPos; 
    public static int cityCount;
    
    public City() {
        indexPos = cityCount;
        cityCount++;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setLocation() {
        location = new LatLng(lat, lng);
    }
    
    public LatLng getLocation() {
        return location;
    }
    
    public void setLat(double lat) {
        this.lat = lat;
    }
    
    public double getLat() {
        return lat;
    }
    
    public void setLng(double lng) {
        this.lng = lng;
    }
    
    public double getLng() {
        return lng;
    }
    public void setIndexPos(int indexPos) {
        this.indexPos = indexPos;
    }
    
    public int getIndexPos() {
        return indexPos;
    }
    
    public void setCityCount(int cityCount) {
        this.cityCount = cityCount;
    }
    
    public int getCityCount() {
        return cityCount;
    }
    
    public void geocoderCse214(String city) {
        try {
        Geocoder geocoder = new Geocoder();
        GeocodeResponse geocodeResponse;
        String addr;
        double lat;
        double lng;

        geocodeResponse = geocoder.geocode(city);
        addr = geocodeResponse.getFormattedAddress();
        this.lat = geocodeResponse.getLat();
        this.lng = geocodeResponse.getLng();
        
        } 
        catch (Exception exp) {
            System.out.print(exp.getMessage());
        }
    }
    
}
