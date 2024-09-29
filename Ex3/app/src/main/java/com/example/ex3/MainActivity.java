package com.example.ex3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        EditText edta = findViewById(R.id.edta);
        EditText edtb = findViewById(R.id.edtb);
        EditText edtc = findViewById(R.id.edtc);
        Button btnthuong = findViewById(R.id.btnthuong);
        Button btntong = findViewById(R.id.btntong);
        Button btntich = findViewById(R.id.btntich);
        Button btnhieu = findViewById(R.id.btnhieu);
        btntong.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           int a = Integer.parseInt("0" + edta.getText());
                                           int b = Integer.parseInt("0" + edtb.getText());
                                           edtc.setText("a + b =" + (a + b));
                                       }
        });

        btnhieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt("0" + edta.getText());
                int b = Integer.parseInt("0" + edtb.getText());
                edtc.setText("a - b =" + (a - b));
            }
        });

        btntich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt("0" + edta.getText());
                int b = Integer.parseInt("0" + edtb.getText());
                edtc.setText("a * b =" + (a * b));
            }
        });
        btnthuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt("0" + edta.getText());
                int b = Integer.parseInt("0" + edtb.getText());
                if (b == 0){
                    edtc.setText("Không thể chia cho 0");
                }
                else
                {
                    edtc.setText("a / b =" + (a / b));
                }
            }
        });
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}