package com.example.ex12;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView txt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        txt1 = findViewById(R.id.selection);
        final String arr1[] = {"Iphone 7", "Samsung Galaxy S7", "Nokia Lumia 730"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr1);
        ListView lv1 = findViewById(R.id.lv1);
        lv1.setAdapter(adapter1);
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                       @Override
                                       public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                           txt1.setText("Vi tri "+position+" : "+arr1[position]);
                                       }
                                   });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}