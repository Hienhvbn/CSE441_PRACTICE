package com.example.myapplicationsecond;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity1 extends AppCompatActivity {
    String tutorials[] = {"Algorithms", "Data Structures", "Languages"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main1);
//        EditText edtkq = findViewById(R.id.edtkq);
//        Button btnback = findViewById(R.id.btnback);
        ListView lvmain = findViewById(R.id.lv_main);
        ArrayAdapter<String> arr;
        arr = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, tutorials);
        lvmain.setAdapter(arr);
//        Intent intent = getIntent();
//        Bundle bundle = intent.getExtras();
//        int a = bundle.getInt("soa");
//        int b = bundle.getInt("sob");
//        String kq = "";
//        if(a==0 && b==0){
//            kq = "Vô số nghiệm";
//        }else if(a==0 && b!=0){
//            kq = "Vô nghiệm";
//        }else{
//            DecimalFormat dcf = new DecimalFormat("0.##");
//            kq = dcf.format(-b*1.0/a);
//        }
//        edtkq.setText(kq);
//        btnback.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                finish();
//            }
//        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}