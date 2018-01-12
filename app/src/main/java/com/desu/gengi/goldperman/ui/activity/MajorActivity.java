package com.desu.gengi.goldperman.ui.activity;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.desu.gengi.goldperman.R;
import com.desu.gengi.goldperman.ui.adapter.SectionsPagerAdapter;

public class MajorActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    private Button incomeBtn, expenseBtn;
    private ImageButton historyBtn, settingBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_major);

        initInstance();
        setListener();

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        /*mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);*/

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

    }

    private void initInstance() {
        incomeBtn = findViewById(R.id.income_btn);
        expenseBtn = findViewById(R.id.expense_btn);
        historyBtn = findViewById(R.id.imageButton);
        settingBtn = findViewById(R.id.imageButton2);
    }

    private void setListener() {
        incomeBtn.setOnClickListener(this);
        expenseBtn.setOnClickListener(this);
        historyBtn.setOnClickListener(this);
        settingBtn.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_major, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        };

        return super.onOptionsItemSelected(item);
    }

    private static long backPressed;
    @Override
    public void onBackPressed() {
        if (backPressed + 2000L > System.currentTimeMillis()){
            super.onBackPressed();
        } else {
            Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show();
            backPressed = System.currentTimeMillis();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.income_btn:
                Toast.makeText(getApplicationContext(), "Income", Toast.LENGTH_SHORT).show();
                break;
            case R.id.expense_btn:
                Toast.makeText(getApplicationContext(), "Expense", Toast.LENGTH_SHORT).show();
                break;
            case R.id.imageButton:
                Toast.makeText(getApplicationContext(), " History", Toast.LENGTH_SHORT).show();
                break;
            case R.id.imageButton2:
                Toast.makeText(getApplicationContext(), "Setting", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(MajorActivity.this, SettingsActivity.class);
//                startActivity(intent);
                break;
            default:
                Toast.makeText(getApplicationContext(), view.getId() + "", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
