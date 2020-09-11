package com.example.top20;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;

import static java.lang.String.valueOf;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.viewHolder> {
    private Context context ;
    ArrayList<Post> arrayList;
     String TAG = "custom adapter";

    public CustomAdapter(ArrayList<Post> arrayList) {
        Log.d(TAG, "CustomAdapter: in the constructor");
        this.arrayList = arrayList;
    }



    @Override
    public viewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.context = viewGroup.getContext();

        View view = LayoutInflater.from(context).inflate(R.layout.tab_item, viewGroup, false);
        return new viewHolder(view);

    }

    @Override
    public void onBindViewHolder(viewHolder viewHolder, int position) {
        viewHolder.name.setText(arrayList.get(position).getName());
        //viewHolder.image.setImageResource(arrayList.get(position).getBadgeUrl());
        Picasso.with(this.context).load(arrayList.get(position).getBadgeUrl())
                .fit().centerCrop().into(viewHolder.image);
        viewHolder.country.setText(arrayList.get(position).getCountry());
        viewHolder.path.setText("Hours");
        viewHolder.hours.setText(valueOf(arrayList.get(position).getHours()));

        Log.d(TAG, "onBindViewHolder: Iam here");

    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: "+ valueOf(arrayList.size()));
        return arrayList.size();

    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView name,country, path,hours;
        ImageView image;


        public viewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            image = (ImageView) itemView.findViewById(R.id.image);
            country = (TextView) itemView.findViewById(R.id.country);
            path = (TextView) itemView.findViewById(R.id.path);
            hours = (TextView) itemView.findViewById(R.id.number_hours);




        }
    }
}



