package test2;

import test1.Day;

public class Test {

    public static void main(String[] args) {

        Day day = Day.SUNDAY;

        switch (day) { 
            case MONDAY: {
                System.out.println("Work day");
                break;
            }
            case TUESDAY: {
                System.out.println("Worship day");
                break;
            }
            default: {
                System.out.println("Fun day");
            }
        }

        day.aajKaDin();
    }

}