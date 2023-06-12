package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName, etCell;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.etName);
        etCell = findViewById(R.id.etCell);

    }

    public void btnSubmit(View v)
    {
        String name = etName.getText().toString();
        String cell = etCell.getText().toString();
       try {
           ContactsDB db = new ContactsDB(this);
           db.open();
           db.createEntry(name, cell);
           db.close();
           etName.setText("");
           etCell.setText("");
       }
       catch (SQLException e)
       {
           Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
       }
    }
    public void btnShow(View v)
    {
        startActivity(new Intent(MainActivity.this, ShowData.class));
    }
    public void btnEdit(View v)
    {
        ContactsDB db = new ContactsDB(this);
        db.open();
        db.updateEntry("1", "waqas", "03234677035");
        db.close();
    }
    public void btnDelete(View v)
    {
        ContactsDB db = new ContactsDB(this);
        db.open();
        db.deleteEntry("1");
        db.close();
    }
}