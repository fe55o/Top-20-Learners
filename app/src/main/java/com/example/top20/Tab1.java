package com.example.top20;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;



public class Tab1 extends Fragment {


    View view;
    RecyclerView recyclerView;
    ArrayList<skilliq> arrayList;
    private String TAG = "Tab1";

    public Tab1(ArrayList<skilliq> arrayList) {
        this.arrayList = arrayList;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_tab1, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        CustomAdapter2 ca = new CustomAdapter2(arrayList);
        recyclerView.setAdapter(ca);

        Log.d(TAG, "onCreateView:  Iam here  " + String.valueOf(arrayList.size()) );
        return view;
    }


}