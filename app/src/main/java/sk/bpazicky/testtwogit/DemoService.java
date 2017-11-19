package sk.bpazicky.testtwogit;

/**
 * Created by Branko on 19.11.2017.
 */

import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class DemoService extends Service {

    private static final String TAG = "DemoService";
    private final int INTERVAL = 60 * 1000;
    private Timer timer = new Timer();

    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }
    /*
     * (non-Javadoc)
     *
     * @see android.app.Service#onCreate() Called by the system when the service
     * is first created. Do not call this method directly.
     */
    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        Toast.makeText(this, "Service is created", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // TODO Auto-generated method stub
        // Display the Toast Message
        Toast.makeText(this, "Start Service", Toast.LENGTH_SHORT).show();

        // Execute an action after period time
        timer.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                // Print a log
                Log.d(TAG, "Start to do an action");
            }
        }, 0, INTERVAL);
        return super.onStartCommand(intent, flags, startId);
    }

    /*
     * (non-Javadoc)
     *
     * @see android.app.Service#onDestroy() Service is destroyed when user stop
     * the service
     */
    @Override
    public void onDestroy() {
        // Display the Toast Message
        Toast.makeText(this, "Stop Service", Toast.LENGTH_SHORT).show();
        if (timer != null) {
            timer.cancel();
        }
        super.onDestroy();
    }

}
