package sohaibwork;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FlightSchedule implements Closeable {

    // Initialize the flight schedule
    public FlightSchedule(City from, City to, String departTime,
            String arrivalTime, int flightNumber, Aircraft aircraft, int flyerPoints) {
        this.from = from;
        this.to = to;
        this.departTime = departTime;
        this.arrivalTime = arrivalTime;
        this.flightNumber = flightNumber;
        this.aircraft = aircraft;
        this.flyerPoints = flyerPoints;
    }

    // Remove the aircraft associated with the flight
    public final void close() {
        if (this.aircraft != null) {
            this.aircraft.close();
        }
    }

    // Access to the city attribute
    public final City getFromCity() {
        return this.from;
    }

    // Access to the to attribute
    public final City getToCity() {
        return this.to;
    }

    // Access to the aircraft attribute
    public final Aircraft getAircraft() {
        return this.aircraft;
    }

    // Access to the departure time
    public final String getDepartTime() {
        return this.departTime;
    }

    // Access to the arrival time
    public final String getArrivalTime() {
        return this.arrivalTime;
    }

    // Access to the flyer points
    public final int getFlyerPoints() {
        return this.flyerPoints;
    }

    // Access to the flight number property
    public final int getFlightNumber() {
        return this.flightNumber;
    }

    private City from; // we going call get from city to return the city object
    private City to;
    private String departTime;
    private String arrivalTime;
    private int flightNumber;
    private Aircraft aircraft;
    private int flyerPoints;

// Display a string representatin of the flight schedule
    @Override
    public String toString() {
        return "Flight Number  : " + this.getFlightNumber() + "\n"
                    + "Origin         : " + this.getFromCity().getCode() + "\n"
                    + "Destination    : " + this.getToCity().getCode() + "\n"
                    + "Departure Time : " + this.getDepartTime() + "\n"
                    + "Arrival Time   : " + this.getArrivalTime() + "\n"
                    + "Flyer Points   : " + this.getFlyerPoints() + "\n"
                    + "Plane Type     : " + this.getAircraft().getName();
    }
}
