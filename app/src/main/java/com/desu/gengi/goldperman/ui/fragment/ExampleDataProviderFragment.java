package com.desu.gengi.goldperman.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.desu.gengi.goldperman.data.provider.AbstractDataProvider;
import com.desu.gengi.goldperman.data.provider.ExampleDataProvider;

/**
 * Created by thanaphong.khaownual on 1/15/2018.
 */

public class ExampleDataProviderFragment extends Fragment {
    private AbstractDataProvider mDataProvider;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRetainInstance(true);  // keep the mDataProvider instance
        mDataProvider = new ExampleDataProvider();
    }

    public AbstractDataProvider getDataProvider() {
        return mDataProvider;
    }
}
