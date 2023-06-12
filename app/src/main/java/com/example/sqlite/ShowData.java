package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.SQLException;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.DataOutputStream;

public class ShowData extends AppCompatActivity {

    TextView tvShowData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        tvShowData = findViewById(R.id.tvShowData);

        try {
            ContactsDB db = new ContactsDB(this);
            db.open();
            tvShowData.setText(db.getData());
            db.close();
        }catch (SQLException e)
        {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}