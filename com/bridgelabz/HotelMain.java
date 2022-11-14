package com.bridgelabz;



import java.util.*;

public class HotelMain {

    public static void main(String[] args) {
        HotelMain user = new HotelMain();
        List<Hotel> hotels = new ArrayList<Hotel>();
        hotels.add(new Hotel("Lakewood",110,90));
        hotels.add(new Hotel("Bridgewood",160,60));
        hotels.add(new Hotel("Ridgewood",220,150));

        hotels.stream().forEach(x -> System.out.println(x));






    }
}
