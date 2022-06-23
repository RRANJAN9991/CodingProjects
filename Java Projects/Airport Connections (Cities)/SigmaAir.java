//Rahul Ranjan ID# - 111448179
package programs;

import java.io.*;
import java.util.*;
import latlng.LatLng;

public class SigmaAir{
    
    private ArrayList<City> cities;
    public static final int MAX_CITIES = 100;
    private double[][] connections;
    private ArrayList<String> cityConnections;
    private double[][] dist;
    private int[][] next;
    
    public SigmaAir() {
        cities = new ArrayList<City>(MAX_CITIES);
        connections = new double[100][100];
        cityConnections = new ArrayList<String>(100);
        dist = new double[100][100];
        next = new int[100][100];
    }
    
    public ArrayList<String> getCities() {
        return cityConnections;
    }
    public void addCity(String city) {
        boolean exists = false;
        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i).getName().equals(city)) {
                exists = true;
                break;
            }
        }
        if (exists == true) {
            System.out.println("City already exists: ");
        }
        else {
            City newCity = new City();
            newCity.setName(city);
            newCity.geocoderCse214(city);
            newCity.setLocation();
            cities.add(newCity);
            System.out.println(city + " has been added:  (" + newCity.getLat() + " , " + newCity.getLng() + " )");
        }
    }
    public double getDistance(String cityFrom, String cityTo) {
        City cityOne = new City();
        City cityTwo = new City();
        double distance = 0.0;
        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i).getName().equals(cityFrom)) {
                cityOne = cities.get(i);
            }
            else if(cities.get(i).getName().equals(cityTo)) {
                cityTwo = cities.get(i);
            }
        }
        if (cityOne.getName() != null && cityTwo.getName() != null) {
            LatLng locationOne = cityOne.getLocation();
            LatLng locationTwo = cityTwo.getLocation();
            distance = LatLng.calculateDistance(locationOne, locationTwo);
        }
        return distance;
    }
    
    
    public double addConnection(String cityFrom, String cityTo) {
        City cityOne = new City();
        City cityTwo = new City();
        double distance = 0.0;
        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i).getName().equals(cityFrom)) {
                cityOne = cities.get(i);
            }
            else if(cities.get(i).getName().equals(cityTo)) {
                cityTwo = cities.get(i);
            }
        }
        if (cityOne.getName() != null && cityTwo.getName() != null) {
            LatLng locationOne = cityOne.getLocation();
            LatLng locationTwo = cityTwo.getLocation();
            distance = LatLng.calculateDistance(locationOne, locationTwo);
            String distanceExists = "";
            outerloop:
            for (int i = 0; i < connections.length; i++) {
                for (int j = 0; j < connections.length; j++) {
                    if (connections[i][j] == distance) {
                        distanceExists = "true";
                        break outerloop;
                    }
                }
            }
            if (distanceExists.equals("")) {
                outerloop:
                for (int i = 0; i < connections.length; i++) {
                    for (int j = 0; j < connections.length; j++) {
                        if (connections[i][j] == 0) {
                            connections[i][j] = distance;
                            break outerloop;
                        }
                    }
                }
                System.out.println(cityFrom + " --> " + cityTo + " added: " + distance);
            }
            else if (distanceExists.equals("true")) {
                System.out.println("Connection already added: " + cityFrom + " --> " + cityTo);
            }
            cityConnections.add(cityFrom + "," + cityTo);
        }
        else {
            System.out.println("Error adding connection: " + cityFrom + " --> " + cityTo);
        }
        return distance;
    }
    
    public void removeConnection(String cityFrom, String cityTo) {
        City cityOne = new City();
        City cityTwo = new City();
        double distance = 0.0;
        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i).getName().equals(cityFrom)) {
                cityOne = cities.get(i);
            }
            else if(cities.get(i).getName().equals(cityTo)) {
                cityTwo = cities.get(i);
            }
        }
        if (cityOne.getName() != null && cityTwo.getName() != null) {
            LatLng locationOne = cityOne.getLocation();
            LatLng locationTwo = cityTwo.getLocation();
            distance = LatLng.calculateDistance(locationOne, locationTwo);
            String distanceExists = "";
            outerloop:
            for (int i = 0; i < connections.length; i++) {
                for (int j = 0; j < connections.length; j++) {
                    if (connections[i][j] == distance) {
                        distanceExists = "true";
                        break outerloop;
                    }
                }
            }
            if (distanceExists.equals("true")) {
                outerloop:
                for (int i = 0; i < connections.length; i++) {
                    for (int j = 0; j < connections.length; j++) {
                        if (connections[i][j] == distance) {
                            connections[i][j] = Double.POSITIVE_INFINITY;
                            break outerloop;
                        }
                    }
                }
                System.out.println(cityFrom + " --> " + cityTo + " has been removed. ");
            }           
        }
        else {
            System.out.println("Error removing connection: " + cityFrom + " --> " + cityTo);
        }
    }
    
    public void shortestPath(String cityFrom, String cityTo) {
        
    }
    
    public void printAllCities(String comp) {
        if (comp.equals("EA")) {
            Collections.sort(cities, new NameComparator());
            for (int i = 0; i < cities.size(); i++) {
                System.out.println("Name: " + cities.get(i).getName() + "             Latitude: " + cities.get(i).getLat() + "                Longitude: " 
                        + cities.get(i).getLng());
            }
        }
        else if (comp.equals("EB")) {
            Collections.sort(cities, new LatComparator());
            for (int i = 0; i < cities.size(); i++) {
                System.out.println("Name: " + cities.get(i).getName() + "             Latitude: " + cities.get(i).getLat() + "                Longitude: " 
                        + cities.get(i).getLng());
            }
        }
        else if (comp.equals("EC")) {
            Collections.sort(cities, new LngComparator());
            for (int i = 0; i < cities.size(); i++) {
                System.out.println("Name: " + cities.get(i).getName() + "             Latitude: " + cities.get(i).getLat() + "                Longitude: " 
                        + cities.get(i).getLng());
            }
        }

    }
    
    public void printAllConnections(String cityFrom, String cityTo) {
        for (int k = 0; k < connections.length; k++) {
            for (int l = 0; l < connections.length; l++) {
                if (this.getDistance(cityFrom, cityTo) == connections[k][l]) {
                    System.out.println("Connections Route: " + cityFrom + " --> " + cityTo + "              distance: "
                            + connections[k][l]);
                }
            }
        }
    }
 
    
    public void loadAllCities(String fileName) throws Exception {
        final String dir = System.getProperty("user.dir");
        String fullPath = dir;
        fullPath += "\\" + fileName;
        FileInputStream fis = new FileInputStream(fullPath);
        InputStreamReader inStream = new InputStreamReader(fis);
        BufferedReader reader = new BufferedReader(inStream);
        String line;
        while ((line = reader.readLine()) != null) {
            String trimedLine = line.trim();
            this.addCity(trimedLine);
        }
    }
    
    public void loadAllConnections(String fileName) throws Exception {
        final String dir = System.getProperty("user.dir");
        String fullPath = dir;
        fullPath += "\\" + fileName;
        FileInputStream fis = new FileInputStream(fullPath);
        InputStreamReader inStream = new InputStreamReader(fis);
        BufferedReader reader = new BufferedReader(inStream);
        String line;
        while ((line = reader.readLine()) != null) {            
            int comma = line.indexOf(",");
            String firstCity = line.substring(0, comma);
            String secondCity = line.substring(comma + 1, line.length());
            //this.addConnection(firstCity, secondCity);
            double distance = this.addConnection(firstCity, secondCity);
        }
    }
}
