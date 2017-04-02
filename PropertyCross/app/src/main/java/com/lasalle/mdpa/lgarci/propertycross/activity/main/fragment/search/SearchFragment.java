package com.lasalle.mdpa.lgarci.propertycross.activity.main.fragment.search;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.lasalle.mdpa.lgarci.propertycross.R;
import com.lasalle.mdpa.lgarci.propertycross.activity.main.OnMainReceiveEvent;
import com.lasalle.mdpa.lgarci.propertycross.activity.main.fragment.search.adapter.RecyclerViewAdapter;

/**
 * Created by FurruPi on 1/4/17.
 */

public class SearchFragment extends Fragment {

    private OnMainReceiveEvent mainListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainListener = (OnMainReceiveEvent) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentLayout = inflater.inflate(R.layout.fragment_search, container, false);
        EditText editTextSearch = (EditText) fragmentLayout.findViewById(R.id.editText_search);
        editTextSearch.clearFocus();
        editTextSearch.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                mainListener.onNavigateToSearchActivity();
            }
        });

        RecyclerView recyclerView = (RecyclerView)fragmentLayout.findViewById(R.id.recycler_fragment_search);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, true);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext());
        recyclerView.setAdapter(recyclerViewAdapter);

        return fragmentLayout;
    }
}
