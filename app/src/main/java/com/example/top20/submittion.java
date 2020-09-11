package com.example.top20;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import static java.lang.String.valueOf;

public class submittion extends AppCompatActivity {

    private EditText firstName;
    private EditText lastName;
    private EditText email;
    private EditText github;
    private Button submitbtn;
    private Context context;
    private String TAG = "submit Activity";
    AlertDialog di;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submittion);

        Log.d(TAG, "onCreate: ");
    }

    public void submitclick(View view) {


        CustomDialog cd = new CustomDialog(submittion.this, " ", "Are You Sure ");

        di = cd.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).create();

        di.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                Button dialog_btn = di.getButton(AlertDialog.BUTTON_NEGATIVE);
                //di.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(getResources().getColor(R.color.cardview_shadow_start_color));
                final Drawable drawable = getResources().getDrawable(R.drawable.dialog_button);
                dialog_btn.setTextColor(getResources().getColor(R.color.coloryellow));
                dialog_btn.setBackgroundDrawable(drawable);

                LinearLayout.LayoutParams dialog_btnLL = (LinearLayout.LayoutParams) dialog_btn.getLayoutParams();
                //dialog_btnLL.gravity = Gravity.BOTTOM;
                dialog_btnLL.weight = 10;
                dialog_btnLL.gravity = Gravity.CENTER_HORIZONTAL;
                dialog_btnLL.width = 30;
                dialog_btnLL.leftMargin = 50;
                dialog_btn.setLayoutParams(dialog_btnLL);
                dialog_btn.invalidate();

                dialog_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        createPost();
                        //di.dismiss();
                    }
                });

            }
        });



        di.show();
        di.getWindow().setLayout(700, 800);

//        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(submittion.this);
//
//        alertDialogBuilder.setMessage("Are You Sure ");
//        alertDialogBuilder.setIcon(R.drawable.ic_question);
//        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//
//                dialogInterface.dismiss();
//            }
//        });
//
//        alertDialogBuilder.setTitle(" ");
//        alertDialogBuilder.setIcon(R.drawable.ic_baseline_close_24);
//
//        AlertDialog alertDialog = alertDialogBuilder.create();
//        alertDialog.show();

    }

    //https://docs.google.com/forms/d/e/1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse
    private void createPost() {
//
//        Gson gson = new GsonBuilder()
//                .setLenient()
//                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://docs.google.com/forms/d/e/")
                //.addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonAPIInterface jsonAPI = retrofit.create(jsonAPIInterface.class);

        firstName = findViewById(R.id.editText1);
        lastName = findViewById(R.id.editText11);
        email = findViewById(R.id.editText2);
        github = findViewById(R.id.editText3);

        String newemail = email.getText().toString();
        String newfname = firstName.getText().toString();
        String newlname = lastName.getText().toString();
        String newgithub = github.getText().toString();

        Call<Void> call = jsonAPI.createFormPost(newemail,newfname, newlname , newgithub);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (!response.isSuccessful()) {
                di.dismiss();
                //unsuccess(valueOf(response.code()));
                    Toast.makeText(submittion.this, "error "+ response.code() + "\n please fill all required fields", Toast.LENGTH_SHORT).show();
                    unsuccess(valueOf(response.code()));
                    return;
                }

                di.dismiss();
                succesdialog(valueOf(response.code()));

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                di.dismiss();
                unsuccess(t.getMessage());

            }
        });
    }

    void succesdialog(String message) {

        Log.d(TAG, "succesdialog: "+ message);

        confirmDialog suc = new confirmDialog(submittion.this,  "Successful Submission!", R.drawable.ic_check_circle_24);

        suc.show();


    }

    void unsuccess(String t){
        Log.d(TAG, "UN success dialog: "+ t);

        confirmDialog unsuc = new confirmDialog(submittion.this,  "UnSuccessful Submission!", R.drawable.ic_report_problem_24);

        unsuc.show();

    }
}
