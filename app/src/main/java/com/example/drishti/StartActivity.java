package com.example.drishti;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class StartActivity extends AppCompatActivity {
    EditText date,hour,minute,object;
    public static final String EXTRA_MESSAGE = "com.mkhrenov.clarifaialarm.MESSAGE";
    Calendar c = Calendar.getInstance();
    int mYear = c.get(Calendar.YEAR);
    int mMonth = c.get(Calendar.MONTH)+1;
    int mDay = c.get(Calendar.DAY_OF_MONTH);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_alarm);
        date = findViewById(R.id.date);
        hour = findViewById(R.id.hour);
        minute = findViewById(R.id.minute);
        object = findViewById(R.id.object);


        date.setText(Integer.toString(mDay)+"-"+Integer.toString(mMonth)+"-"+Integer.toString(mYear));
    }

    public void setAlarm(View view) throws ParseException {



        String dateString = date.getText().toString() + " " + hour.getText().toString() + ":" + minute.getText().toString();

        Date dateTime = (new SimpleDateFormat("dd-MM-yy HH:mm")).parse(dateString);

        Intent alarmIntent = new Intent(this, AlarmActivity.class);
        alarmIntent.putExtra(EXTRA_MESSAGE, object.getText().toString());
        AlarmManager alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);

        alarmManager.set(AlarmManager.RTC_WAKEUP, dateTime.getTime(),
                PendingIntent.getActivity(this, 1, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT));
        finish();
    }


}
