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

public class Tab2 extends Fragment {
    private String TAG = "Tab2";
    private View view;
    private ArrayList<Post> arraylist;
    RecyclerView recyclerView;

    public Tab2(ArrayList<Post> arrayList) {
        this.arraylist = arrayList;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view  = inflater.inflate(R.layout.fragment_tab2, container, false);
        //TextView tv = (TextView) view.findViewById(R.id.tab2_text);
        //tv.setText("\n\n\n\n\n\n\n"+ arraylist.get(0).getName());

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_2);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        CustomAdapter ca = new CustomAdapter(arraylist);
        recyclerView.setAdapter(ca);

        Log.d(TAG, "onCreateView: ");
        return view;
    }
}