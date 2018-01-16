package com.desu.gengi.goldperman.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.desu.gengi.goldperman.R;
import com.desu.gengi.goldperman.ui.fragment.DraggableGridExampleFragment;
import com.desu.gengi.goldperman.ui.fragment.ExampleDataProviderFragment;

import com.desu.gengi.goldperman.data.provider.AbstractDataProvider;

public class RecordActivity extends AppCompatActivity {
    private static final String FRAGMENT_TAG_DATA_PROVIDER = "data provider";
    private static final String FRAGMENT_LIST_VIEW = "list view";

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

    }

    public AbstractDataProvider getDataProvider() {
        final Fragment fragment = getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG_DATA_PROVIDER);
        return ((ExampleDataProviderFragment) fragment).getDataProvider();
    }

}
