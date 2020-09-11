package com.example.top20;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class confirmDialog extends AlertDialog.Builder{

    public confirmDialog(Context context, String Message, int res){
        super(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View viewDialog = inflater.inflate(R.layout.confirm_dialog, null, false);

        TextView dialog_title = (TextView) viewDialog.findViewById(R.id.confirm_title);
        dialog_title.setText("");

        TextView dialog_text = (TextView) viewDialog.findViewById(R.id.confirm_text);
        dialog_text.setText(Message);

        ImageView confirm = (ImageView) viewDialog.findViewById(R.id.confirm_image);
        confirm.setImageResource(res);

        this.setView(viewDialog);


    }
}
