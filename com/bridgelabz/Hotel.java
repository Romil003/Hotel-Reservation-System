package com.bridgelabz;

public class Hotel {

    private String hotelName ;

    private int regularCustomerWeekdayRates;

    private int regularCustomerWeekEndRates;


    public Hotel() {
    }

    public Hotel(String hotelName, int regularCustomerWeekdayRates, int regularCustomerWeekEndRates) {
        this.hotelName = hotelName;
        this.regularCustomerWeekdayRates = regularCustomerWeekdayRates ;
        this.regularCustomerWeekEndRates = regularCustomerWeekEndRates;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName ;
    }

    public int getRegularCustomerWeekdayRates() {
        return regularCustomerWeekdayRates;
    }

    public void setRegularCustomerWeekdayRates(int regularCustomerWeekdayRates) {
        this.regularCustomerWeekdayRates = regularCustomerWeekdayRates;
    }

    public int getRegularCustomerWeekEndRates() {
        return regularCustomerWeekEndRates;
    }

    public void setRegularCustomerWeekEndRates(int regularCustomerWeekEndRates) {
        this.regularCustomerWeekEndRates = regularCustomerWeekEndRates;
    }

    public long totalRate(long weekDayCount , long weekEndCount){
        long weekDayRate = weekDayCount*getRegularCustomerWeekdayRates();
        long weekEndRate = weekEndCount*getRegularCustomerWeekEndRates();
        long totalRate = weekDayRate + weekDayRate;
        return totalRate;
    }
    @Override
    public String toString() {
        return "Hotel{" +
                "hotelName='" + hotelName + '\'' +
                ", regularCustomerWeekdayRates=" + regularCustomerWeekdayRates +
                ", regularCustomerWeekEndRates=" + regularCustomerWeekEndRates +
                '}';
    }

}
