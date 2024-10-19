package com.example.blood_donor;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText eid, fn, ln, bg; // Removed editText for fetching
    TextView tv1;
    Button button, button2;
    DBhelper dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eid = findViewById(R.id.eid);
        fn = findViewById(R.id.fn);
        ln = findViewById(R.id.ln);
        bg = findViewById(R.id.bg);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        tv1 = findViewById(R.id.tv1);

        dbhelper = new DBhelper(this);
    }

    public void getData(View view) {
        int id1 = Integer.parseInt(eid.getText().toString());
        String fname1 = fn.getText().toString();
        String lname1 = ln.getText().toString();
        String bgroup1 = bg.getText().toString();

        dbhelper.getDataHelper(id1, fname1, lname1, bgroup1);
        Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show();
    }

    public void fetchData(View view) {
        String result = dbhelper.fetchDataHelper(); // Fetch all data without filters

        if (result.isEmpty()) {
            tv1.setText("No data found.");
        } else {
            tv1.setText(result);
        }
        Toast.makeText(this, "Fetch Successful", Toast.LENGTH_SHORT).show();
    }
}
