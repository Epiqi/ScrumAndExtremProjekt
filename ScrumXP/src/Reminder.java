
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import oru.inf.InfDB;

public class Reminder {

    public static void TimerSendMail(int month, int year, int day, int timmen, int minut, InfDB scrumXPdb, String userName) {

        Timer timer = new Timer();

        TimerTask task = new TimerTask() {

            @Override
            public void run() {

                JavaMailUtil.Meeting_Notification(scrumXPdb, userName);

                timer.cancel();

            }
        };

        Calendar date = Calendar.getInstance();
        date.set(Calendar.YEAR, year);
        date.set(Calendar.MONTH, month);
        date.set(Calendar.DAY_OF_MONTH, day);
        date.set(Calendar.HOUR_OF_DAY, timmen);
        date.set(Calendar.MINUTE, minut);
        date.set(Calendar.SECOND, 00);
        date.set(Calendar.MILLISECOND, 0);
//
//        timer.schedule(task, 0);
//        timer.schedule(task, date.getTime());
//        timer.scheduleAtFixedRate(task, 0, 1000);
        timer.scheduleAtFixedRate(task, date.getTime(), 1000);
    }

}
