public class AppointmentBook {
    private boolean[][] timeslots;

    public AppointmentBook(boolean[][] schedule)
    {
        timeslots=schedule;
    }
    private boolean isMinuteFree(int period, int minute) {
        return (timeslots[period-1][minute]==false);
    }

    private void reserveBlock(int period, int startMinute, int duration) {
        for (int i=startMinute;i<startMinute+duration;i++){
            timeslots[period-1][i]=true;
        }
    }

    public int findFreeBlock(int period, int duration) {
     int conseq=0;
        for (int i=0;i<60;i++)
        {
          if (isMinuteFree(period,i)) {conseq++;
            if (conseq==duration) return i-duration;
          }
          else conseq=0;
          
        }
        
        return -1;
    }
        

    public boolean makeAppointment(int startPeriod, int endPeriod, int duration){
        for (int i=startPeriod;i<=endPeriod;i++)
        {
         if (findFreeBlock(i,duration)>0){
            reserveBlock(i,findFreeBlock(i,duration),duration);
            i=endPeriod;
            return true;
         }
        }
        return false;
    }
    public void printPeriod(int period){

        for (int i=0;i<60;i++) System.out.println("Period "+ period +": " +"Minute "+ i + ": " + isMinuteFree(period,i));
    }
}