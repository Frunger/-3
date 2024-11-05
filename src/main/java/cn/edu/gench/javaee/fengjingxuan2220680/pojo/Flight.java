package cn.edu.gench.javaee.fengjingxuan2220680.pojo;

import cn.edu.gench.javaee.fengjingxuan2220680.pojo.Airport;

public class Flight {
    private int id;
    private String flightNumber;
    private String flightDuration;
    private int ticketPrice;

    private cn.edu.gench.javaee.fengjingxuan2220680.pojo.Airport departureAirport;
    private cn.edu.gench.javaee.fengjingxuan2220680.pojo.Airport arrivalAirport;

    // Getters 和 Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFlightDuration() {
        return flightDuration;
    }

    public void setFlightDuration(String flightDuration) {
        this.flightDuration = flightDuration;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }
}
