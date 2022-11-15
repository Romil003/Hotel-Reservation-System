package com.bridgelabz;

public class Hotel {

    private String hotelName ;

    private int regularCustomerWeekdayRates;

    private int regularCustomerWeekEndRates;

    private double rating ;

    private int rewardCustomerWeekdayRates;

    private int rewardCustomerWeekEndRates;


    public Hotel() {
    }

    public Hotel(String hotelName, int regularCustomerWeekdayRates, int regularCustomerWeekEndRates, double rating, int rewardCustomerWeekdayRates, int rewardCustomerWeekEndRates) {
        this.hotelName = hotelName;
        this.regularCustomerWeekdayRates = regularCustomerWeekdayRates ;
        this.regularCustomerWeekEndRates = regularCustomerWeekEndRates;
        this.rating = rating;
        this.rewardCustomerWeekdayRates = rewardCustomerWeekdayRates;
        this.rewardCustomerWeekEndRates = rewardCustomerWeekEndRates;
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
        this.regularCustomerWeekdayRates = regularCustomerWeekdayRates ;
    }

    public int getRegularCustomerWeekEndRates() {
        return regularCustomerWeekEndRates;
    }

    public void setRegularCustomerWeekEndRates(int regularCustomerWeekEndRates) {
        this.regularCustomerWeekEndRates = regularCustomerWeekEndRates;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getRewardCustomerWeekdayRates() {
        return rewardCustomerWeekdayRates;
    }

    public void setRewardCustomerWeekdayRates(int rewardCustomerWeekdayRates) {
        this.rewardCustomerWeekdayRates = rewardCustomerWeekdayRates;
    }

    public int getRewardCustomerWeekEndRates() {
        return rewardCustomerWeekEndRates;
    }

    public void setRewardCustomerWeekEndRates(int rewardCustomerWeekEndRates) {
        this.rewardCustomerWeekEndRates = rewardCustomerWeekEndRates;
    }

    public long totalRate(long weekDayCount , long weekEndCount){
        long weekDayRate = weekDayCount*getRegularCustomerWeekdayRates();
        long weekEndRate = weekEndCount*getRegularCustomerWeekEndRates();
        long totalRate = weekDayRate + weekEndRate ;
        return totalRate ;
    }


    public long totalRateForRewardCustomer(long weekDayCount , long weekEndCount) {
        long weekDayRate = weekDayCount*getRewardCustomerWeekdayRates();
        long weekEndRate = weekEndCount*getRewardCustomerWeekEndRates();
        long totalRateForRewardC = weekDayRate + weekEndRate;
        return totalRateForRewardC;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelName='" + hotelName + '\'' +
                ", regularCustomerWeekdayRates=" + regularCustomerWeekdayRates +
                ", regularCustomerWeekEndRates=" + regularCustomerWeekEndRates +
                ", rating=" + rating +
                ", rewardCustomerWeekdayRates=" + rewardCustomerWeekdayRates +
                ", rewardCustomerWeekEndRates=" + rewardCustomerWeekEndRates +
                '}';
    }
}
