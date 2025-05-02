public class Main{

public static void main(String[] args){
    boolean[][] timeslots=new boolean[8][60];
    AppointmentBook schedule=new AppointmentBook(timeslots);
    for (int i=0;i<25;i++) timeslots[1][i]=true;
    for (int i=30;i<60;i++) timeslots[1][i]=true;
    for (int i=15;i<41;i++) timeslots[2][i]=true;
    for (int i=0;i<5;i++) timeslots[3][i]=true;
    for (int i=30;i<44;i++) timeslots[3][i]=true;
    schedule.printPeriod(2);
    schedule.printPeriod(3);
    schedule.printPeriod(4);
    System.out.println(schedule.makeAppointment(2, 4, 22));
    System.out.println(schedule.makeAppointment(3, 4, 3));
    System.out.println(schedule.makeAppointment(2, 4, 20));
    
}

}