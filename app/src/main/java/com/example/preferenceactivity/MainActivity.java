package com.example.preferenceactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView;
    Button store,show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        show=findViewById(R.id.btn_show_info);
        store=findViewById(R.id.btn_store_info);

        show.setOnClickListener(this);
        store.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_store_info:
                Intent intent=new Intent(MainActivity.this, PrefsActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_show_info:
                ShowMethode();
                break;

        }


    }

    private void ShowMethode() {
        SharedPreferences preferences= PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        String Username=preferences.getString("username","XYZ");
        String Password=preferences.getString("password","XYZ");
        boolean Login=preferences.getBoolean("checkbox",false);
        String Lang=preferences.getString("list","XYZ");

        StringBuilder builder=new StringBuilder();
        builder.append("Username: "+Username+"\n");
        builder.append("Password: "+Password+"\n");
        builder.append("Login: "+Login+"\n");
        builder.append("Language: "+Lang);
        textView.setText(builder.toString());
    }
}