package com.example.localizationinapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtMessage;
    EditText edtInfo;
    ImageView imgFlag;
    Button btnSubmit;
    Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        res = getResources();
        txtMessage = findViewById(R.id.txtMessage);
        edtInfo = findViewById(R.id.edtInfo);
        imgFlag = findViewById(R.id.imgFlag);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtMessage.setText(edtInfo.getText().toString());
            }
        });

        MyData mydata = (MyData) getLastCustomNonConfigurationInstance();
        if(mydata != null){
            txtMessage.setText(mydata.data + "updated");
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("code",101);
        Log.e("tag","onSaveInstanceCalled");
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.e("tag","onConfigurationCalled");
    }

    @Nullable
    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        Log.e("tag","onRetainCalled");
        MyData myData = new MyData();
        myData.data = txtMessage.getText().toString();
        return myData;
    }
}