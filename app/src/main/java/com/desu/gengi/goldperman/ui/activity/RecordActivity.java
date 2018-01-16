package com.desu.gengi.goldperman.ui.activity;

import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.desu.gengi.goldperman.R;
import com.desu.gengi.goldperman.ui.fragment.DraggableGridExampleFragment;
import com.desu.gengi.goldperman.ui.fragment.ExampleDataProviderFragment;

import com.desu.gengi.goldperman.data.provider.AbstractDataProvider;

public class RecordActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String FRAGMENT_TAG_DATA_PROVIDER = "data provider";
    private static final String FRAGMENT_LIST_VIEW = "list view";
    private ConstraintLayout recordActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(new ExampleDataProviderFragment(), FRAGMENT_TAG_DATA_PROVIDER)
                    .commit();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new DraggableGridExampleFragment(), FRAGMENT_LIST_VIEW)
                    .commit();
        }

        initInstance();
        initActionBar();
        initOnClickListener();

    }

    private void initInstance() {
        recordActivity = findViewById(R.id.record_activity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }


    private void initActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    private void initOnClickListener() {
        findViewById(R.id.calendar_btn).setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_record, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_calculator:
                Snackbar.make(recordActivity, "Looking for calculator...", Snackbar.LENGTH_SHORT).show();
                return true;
            case R.id.action_save:
                Snackbar.make(recordActivity, "Saving...", Snackbar.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.calendar_btn:
                Snackbar.make(recordActivity, "Opening calendar...", Snackbar.LENGTH_SHORT).show();
            default:
        }
    }

    @Override
    public void setSupportActionBar(Toolbar toolbar) {
        super.setSupportActionBar(toolbar);
    }

    public AbstractDataProvider getDataProvider() {
        final Fragment fragment = getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG_DATA_PROVIDER);
        return ((ExampleDataProviderFragment) fragment).getDataProvider();
    }

}
