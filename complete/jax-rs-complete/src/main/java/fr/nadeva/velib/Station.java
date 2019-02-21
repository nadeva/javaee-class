package fr.nadeva.velib;


import java.util.Date;

public class Station {

    private  int number;
    private  String name;
    private  String address;
    private  int bike_stands;
    private  int available_bike_stands;
    private  int available_bikes;
    private  Date last_update;

    private String contractName;

    public Station() {
    }

    public Station(int number, String name, String address, int bike_stands, int available_bike_stands, int available_bikes, long last_update) {
        this.number = number;
        this.name = name;
        this.address = address;
        this.bike_stands = bike_stands;
        this.available_bike_stands = available_bike_stands;
        this.available_bikes = available_bikes;
        this.last_update = new Date(last_update);
    }

    @Override
    public String toString() {
        return "Station{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", bike_stands=" + bike_stands +
                ", available_bike_stands=" + available_bike_stands +
                ", available_bikes=" + available_bikes +
                ", last_update=" + last_update +
                '}';
    }

    public int getNumber() {
        return number;
    }


    public String getName() {
        return name;
    }


    public String getAddress() {
        return address;
    }

    public int getBike_stands() {
        return bike_stands;
    }


    public int getAvailable_bike_stands() {
        return available_bike_stands;
    }


    public int getAvailable_bikes() {
        return available_bikes;
    }

}
