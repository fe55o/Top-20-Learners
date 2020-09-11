package com.example.top20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
//import static android.content.ContentValues.TAG;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private static final int hoursAdapter = 1;
    private static final int iqAdapter = 0;

    private TextView text ;
    private TabLayout tabLayout;
    private TabItem tab1, tab2;
    private ViewPager viewpager;
    public PagerAdapter pageradapter;
    private Tab1 hoursTab;
    private Tab2 iqTab;
    private String TAG = "mActivity";
    private Button btn;
    ArrayList<Post> arrayList1;
    ArrayList<skilliq> arrayList2;
    Thread thread_call2;
    Thread thread_call1;
    Boolean get_flag1 = false;
    Boolean get_flag2 = false;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: test");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewpager= findViewById(R.id.view_pager);

        btn = findViewById(R.id.btn5);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, submittion.class));
                finish();
            }
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://gadsapi.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonAPIInterface jsonAPI = retrofit.create(jsonAPIInterface.class);
        Call<List<Post>> call = jsonAPI.getPosts();

         thread_call1 = new Thread(new Runnable() {
            @Override
            public void run() {


        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "code: " + response.code(), Toast.LENGTH_LONG).show();
                    Log.d(TAG, "onResponse: request unsuccessful, code :  " + response.code());

                    return;
                }
                MainActivity.this.arrayList1 = (ArrayList)response.body();
                Log.d(TAG, "onResponse: request successful, the Size:: " + String.valueOf(arrayList1.size()));
                get_flag1 = true;
                //setupPager();

                //setupPager(arrayList1);


            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                Log.d(TAG, "onResponse: request unsuccessful, code :  " + t.getMessage());

            }
        });
            }
        });
        thread_call1.start();

        jsonAPIInterface jsonAPI2 = retrofit.create(jsonAPIInterface.class);

        Call<List<skilliq>> call2 = jsonAPI2.getiq();
         thread_call2 = new Thread(new Runnable() {
            @Override
            public void run() {


        call2.enqueue(new Callback<List<skilliq>>() {
            @Override
            public void onResponse(Call<List<skilliq>> call, Response<List<skilliq>> response) {

                if (!response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "code: " + response.code(), Toast.LENGTH_LONG).show();
                    Log.d(TAG, "onResponse: request unsuccessful, code :  " + response.code());

                    return;
                }
                MainActivity.this.arrayList2 = (ArrayList) response.body();
                Log.d(TAG, "onResponse: request successful, the Size:: " + String.valueOf(arrayList2.size()));
                get_flag2= true;
                //setupPager(arrayList2);

            }
            @Override
            public void onFailure(Call<List<skilliq>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                Log.d(TAG, "onResponse: request unsuccessful, code :  " + t.getMessage());


            }
        });
            }
        });
        thread_call2.start();

setupPager();
    }




    public void setupPager() {
        if (get_flag1 == true && get_flag2 == true ){


            Log.d(TAG, "setupPager: not null arraylists");

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    myPagerAdapter adapter = new myPagerAdapter(getSupportFragmentManager());
                    hoursTab = new Tab1(MainActivity.this.arrayList2);
                    iqTab = new Tab2(MainActivity.this.arrayList1);

                    adapter.addFragment(hoursTab);
                    adapter.addFragment(iqTab);

                    viewpager.setAdapter(adapter);
                    tabLayout = findViewById(R.id.tab_layout);
                    tabLayout.setupWithViewPager(viewpager);
                    tabLayout.getTabAt(hoursAdapter).setText(getString(R.string.hours));
                    tabLayout.getTabAt(iqAdapter).setText(getString(R.string.iq));
                }
            });



        }
        else{
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    setupPager();
                }
            }, 4000);}

        }
    }




