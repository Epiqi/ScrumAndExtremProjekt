import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class Reminder {

    public static void TimerSendMail(int month,int year,int day) {

        // Timer =         A facility for threads to schedule tasks 
        //                for future execution in a background thread
        // TimerTask =     A task that can be scheduled for one-time 
        //                or repeated execution by a Timer
        Timer timer = new Timer();

        TimerTask task = new TimerTask() {

            int counter = 10;

            @Override
            public void run() {
//
                System.out.println("HAPPY NEW YEAR!");
                timer.cancel();
//
            }
        };

        Calendar date = Calendar.getInstance();
        date.set(Calendar.YEAR, year);
        date.set(Calendar.MONTH, month);
        date.set(Calendar.DAY_OF_MONTH, day);
        date.set(Calendar.HOUR_OF_DAY, 11);
        date.set(Calendar.MINUTE, 53);
        date.set(Calendar.SECOND, 00);
        date.set(Calendar.MILLISECOND,0);
//
//        timer.schedule(task, 0);
//        timer.schedule(task, date.getTime());
//        timer.scheduleAtFixedRate(task, 0, 1000);
        timer.scheduleAtFixedRate(task, date.getTime(), 1000);
    }

}