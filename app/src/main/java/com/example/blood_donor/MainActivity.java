package com.example.blood_donor;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText eid, fn, ln, bg;
    Button button;
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

        dbhelper = new DBhelper(getApplicationContext());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void getData(View view) {
        int id1 = Integer.parseInt(eid.getText().toString());
        String fname1 = fn.getText().toString();
        String lname1 = ln.getText().toString();
        String bgroup1 = bg.getText().toString();

        dbhelper.getDataHelper(id1,fname1, lname1, bgroup1);
        Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show();
    }
}
