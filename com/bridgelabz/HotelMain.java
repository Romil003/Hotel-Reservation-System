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

            LocalDate startDate = LocalDate.parse(strStartDate, formatter) ;
            LocalDate endDate = LocalDate.parse(strEndDate, formatter) ;

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
        hotelList.add(new Hotel("Lakewood",110,90,0));
        hotelList.add(new Hotel("Bridgewood",160,60,0));
        hotelList.add(new Hotel("Ridgewood",220,150,0));

//        hotelList.stream().forEach(x -> System.out.println(x));

        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.print("1.View Hotels\t 2.Find cheaper Hotel\t 3.Add Ratings\t 4.Exit\n");
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
                    System.out.println("Cheaper hotel you get => " + cheaperHotel);
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
                    System.out.println("Exiting from program !!!!");
                    break;
            }
        }while (choice != 4);

    }
}
