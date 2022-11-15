package com.bridgelabz;



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class HotelMain {

    static long getWeekends(String strStartDate, String strEndDate) {
        Map<String, List<LocalDate>> map = new HashMap<>();
        List<LocalDate> weekdays = new ArrayList<>();
        List<LocalDate> weekends = new ArrayList<>();
        try {
            map.put("weekdays", weekdays);
            map.put("weekends", weekends);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");

            LocalDate startDate = LocalDate.parse(strStartDate, formatter);
            LocalDate endDate = LocalDate.parse(strEndDate, formatter);

            for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
                switch (date.getDayOfWeek()) {
                    case MONDAY:
                    case TUESDAY:
                    case WEDNESDAY:
                    case THURSDAY:
                    case FRIDAY:
                        weekdays.add(date);
                        break;
                    case SATURDAY:
                    case SUNDAY:
                        weekends.add(date);
                }
            }

        }catch (Exception e){
            return 0;
        }
        return weekends.stream().count();
    }

    static long getWeekdays(String strStartDate, String strEndDate) {


        Map<String, List<LocalDate>> map = new HashMap<>();
        List<LocalDate> weekdays = new ArrayList<>();
        try {
            List<LocalDate> weekends = new ArrayList<>();
            map.put("weekdays", weekdays);
            map.put("weekends", weekends);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
            LocalDate startDate = LocalDate.parse(strStartDate, formatter);
            LocalDate enddDate = LocalDate.parse(strEndDate, formatter);

            for (LocalDate date = startDate; !date.isAfter(enddDate); date = date.plusDays(1)) {
                switch (date.getDayOfWeek()) {
                    case MONDAY:
                    case TUESDAY:
                    case WEDNESDAY:
                    case THURSDAY:
                    case FRIDAY:
                        weekdays.add(date);
                        break;
                    case SATURDAY:
                    case SUNDAY:
                        weekends.add(date);
                }
            }


        }catch (Exception e){
            return 0;
        }
        return weekdays.stream().count();
    }

    public static void main(String[] args) {
        HotelMain user = new HotelMain();
        List<Hotel> hotelList = new ArrayList<Hotel>();
        hotelList.add(new Hotel("Lakewood",110,90,3,80,80));
        hotelList.add(new Hotel("Bridgewood",160,60,4,110,50));
        hotelList.add(new Hotel("Ridgewood",220,150,5,110,40));

        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.print("1.View Hotels\t 2.Find Best Rated and Cheaper Hotel\t 3.Add Ratings\t 4.Best rated Hotel\t 5.Exit\n");
            System.out.println("Enter a choice : ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Hotels are : ");
                    hotelList.stream().forEach(x -> System.out.println(x));
                    break;
                case 2:
                    System.out.println("Enter start date : ");
                    String checkInDate = input.next();
                    System.out.println("Enter end date : ");
                    String checkOutDate = input.next();

                    long totalWeekDays = getWeekdays(checkInDate,checkOutDate);
                    System.out.println("Total weekDays => " + totalWeekDays);
                    System.out.println();
                    long totalWeekEnds = getWeekends(checkInDate,checkOutDate);
                    System.out.println("Total weekEnds => " + totalWeekEnds);
                    System.out.println("For Regular Customer : ");
                    if(getWeekdays(checkInDate,checkOutDate) != 0 && getWeekends(checkInDate,checkOutDate) != 0) {
                        Hotel hotel1 = hotelList.get(0);
                        Hotel bestRatedAndCheaperHotel = hotelList.stream().reduce(hotel1, (a, b) -> a.totalRate(totalWeekDays, totalWeekEnds) < b.totalRate(totalWeekDays, totalWeekEnds) && a.getRating() > b.getRating() ? a : b);
                        System.out.println("Best rated and Cheaper hotel you get => " + bestRatedAndCheaperHotel.getHotelName() + " with total rate of Rs. " + bestRatedAndCheaperHotel.totalRate(totalWeekDays, totalWeekEnds) + " and rating of " + bestRatedAndCheaperHotel.getRating());
                    }
                    else {
                        System.out.println("Enter Valid Dates");
                    }
                    break;
                case 3:
                    System.out.println("Enter the Hotel name : ");
                    String hotelName = input.next();
                    hotelList.stream().filter(x -> x.getHotelName().equals(hotelName)).forEach(x -> {
                        System.out.println("Enter rating -> ");
                        double a = input.nextDouble();
                        x.setRating(a);
                    });
                    break;
                case 4:
                    Hotel hotel_1 = hotelList.get(0);
                    Hotel bestRatedHotel = hotelList.stream().reduce(hotel_1, (a, b) -> a.getRating()> b.getRating() ? a : b);
                    System.out.println("Cheaper hotel you get => " + bestRatedHotel + " with rating of  " + bestRatedHotel.getRating() );
                    break;
                case 5:
                    System.out.println("Exiting from program !!!!");
                    break;
            }
        }while (choice != 5);
    }
}
