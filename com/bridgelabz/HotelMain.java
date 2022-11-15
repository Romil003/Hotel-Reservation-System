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
            return weekends.stream().count();
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

            return weekdays.stream().count();
        }catch (Exception e){
            return weekdays.stream().count();
        }

    }

    public static void main(String[] args) {
        HotelMain user = new HotelMain();
        List<Hotel> hotelList = new ArrayList<Hotel>();
        hotelList.add(new Hotel("Lakewood",110,90,4.3,0,0));
        hotelList.add(new Hotel("Bridgewood",160,60,4.9,0,0));
        hotelList.add(new Hotel("Ridgewood",220,150,4.5,0,0));

        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.print("1.View Hotels\t 2.Find cheaper Hotel\t 3.Add Ratings\t 4.Best rated Hotel\t 5.Add special rates for reward customer\t 6.Exit\n");
            System.out.println("Enter a choice : ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Hotels are : ");
                    hotelList.stream().forEach(x -> System.out.println(x));
                    break;
                case 2:
                    System.out.println("Enter start date : ");
                    String startDate = input.next();
                    System.out.println("Enter end date : ");
                    String endDate = input.next();

                    long totalWeekDays = getWeekdays(startDate, endDate);
                    System.out.println("Total weekDays => " + totalWeekDays);
                    System.out.println();
                    long totalWeekEnds = getWeekends(startDate, endDate);
                    System.out.println("Total weekEnds => " + totalWeekEnds);

                    Hotel hotel1 = hotelList.get(0);
                    Hotel cheaperHotel = hotelList.stream().reduce(hotel1, (a, b) -> a.totalRate(totalWeekDays, totalWeekEnds) < b.totalRate(totalWeekDays, totalWeekEnds) ? a : b);
                    System.out.println("Cheaper hotel you get => " + cheaperHotel + " with total rate of Rs. " + cheaperHotel.totalRate(totalWeekDays,totalWeekEnds));
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
                    System.out.print("1.Regular Customer\t 2.Reward Customer\n");
                    System.out.println("Enter choice for type of customer : ");
                    int typeOfCustomer = input.nextInt();
                    if(typeOfCustomer ==1){
                        for (Hotel hotel:hotelList) {
                            System.out.println("Hotel name = " + hotel.getHotelName());
                            System.out.println("WeekDay rate for regular customer = Rs. " + hotel.getRegularCustomerWeekdayRates());
                            System.out.println("WeekEnd rate for regular customer = Rs. " + hotel.getRegularCustomerWeekEndRates());
                            System.out.println();
                        }
                    } else {
                        hotelList.stream().forEach(x -> System.out.println(x));
                        System.out.println("Enter Hotel Name = ");
                        String hotelName1 = input.next();
                        for (Hotel hotel:hotelList) {
                            if(hotel.getHotelName().equals(hotelName1)) {
                                System.out.println("Enter Weekdays Special Rates for Reward Customer : ");
                                int weekdayRates = input.nextInt();
                                hotel.setRewardCustomerWeekdayRates(weekdayRates);
                                System.out.println();
                                System.out.println("Enter WeekEnds Special Rates for Reward Customer : ");
                                int weekendRates = input.nextInt();
                                hotel.setRewardCustomerWeekEndRates(weekendRates);
                                System.out.println();
                                System.out.println(hotel) ;
                            }
                        }
                    }
                    break;
                case 6:
                    System.out.println("Exiting from program !!!!");
                    break;
            }
        }while (choice != 6);

    }
}
