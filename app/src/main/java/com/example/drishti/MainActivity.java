package com.example.drishti;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.android.tflitecamerademo.CameraActivity;
import com.google.android.gms.samples.vision.ocrreader.OcrCaptureActivity;

import org.tensorflow.lite.examples.classification.ClassifierActivity;

public class MainActivity extends AppCompatActivity {

    private static  final  String TAG = "MAIN ACTIVITY";
    private DrawerLayout drawerLayout;
    Button btnOcr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        btnOcr = (Button)findViewById(R.id.btn_ocr);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);


        drawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        switch (menuItem.getItemId()){
                            case R.id.nav_ocr:
                                Log.i(TAG,"OCR activity");
                                Intent i = new Intent(MainActivity.this, OcrCaptureActivity.class);
                                startActivity(i);
                                break;
                            case R.id.nav_attendance:
                                Log.i(TAG,"Alarm");
                                Intent it = new Intent(MainActivity.this, StartActivity.class);
                                startActivity(it);
                                break;
                            case R.id.nav_object:
                                Log.i(TAG,"Object recognition");
                                Intent itt = new Intent(MainActivity.this, ClassifierActivity.class);
                                startActivity(itt);
                                break;
                            case R.id.nav_diet:
                                Log.i(TAG,"Food recognition");
                                Intent ittt = new Intent(MainActivity.this, CameraActivity.class);
                                startActivity(ittt);
                                break;
                        }

//                        return  true;
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
//                        drawerLayout.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here

                        return true;
                    }
                });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean res=false;
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
               res=true;
                break;

        }
        return super.onOptionsItemSelected(item);
    }


    public void ocr(View view){
        Intent i = new Intent(this, OcrCaptureActivity.class);
        startActivity(i);
    }

    public void alarmer(View view){
        Intent i = new Intent(this, StartActivity.class);
        startActivity(i);
    }
}
