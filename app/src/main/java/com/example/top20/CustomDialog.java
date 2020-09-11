package com.example.top20;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.widget.ImageView;
import android.widget.TextView;

import static androidx.core.content.ContextCompat.startActivity;

public class CustomDialog extends AlertDialog.Builder {
    public CustomDialog(Context context, String title, String Message){
        super(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View viewDialog = inflater.inflate(R.layout.dialog, null, false);

        TextView dialog_title = (TextView) viewDialog.findViewById(R.id.dialog_title);
        dialog_title.setText(title);

        TextView dialog_text = (TextView) viewDialog.findViewById(R.id.dialog_text);
        dialog_text.setText(Message);

        ImageView exit = (ImageView) viewDialog.findViewById(R.id.dialog_exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewDialog.setVisibility(View.INVISIBLE);
            }
        });

        this.setView(viewDialog);


    }
}
