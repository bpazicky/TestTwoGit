package sk.bpazicky.testtwogit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button mStartService;
    Button mStopService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Declare the start service button
        mStartService = (Button) findViewById(R.id.btn_start_service);

        // Declare the stop service button
        mStopService = (Button) findViewById(R.id.btn_stop_service);

        // Add event listener to each button
        mStartService.setOnClickListener(this);
        mStopService.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        // User click start button
        if (v.getId() == R.id.btn_start_service) {
            // Display the Toast Message
            startService(new Intent(getBaseContext(), DemoService.class));
        } else { // User click stop button

            // Stop the service
            stopService(new Intent(getBaseContext(), DemoService.class));
        }
    }
}

