package com.example.ex14;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editText, editText2, editText3;
    Button button, button2, button3, button4;
    ListView listView;
    ArrayList<String> myList;
    ArrayAdapter<String> myAdapter;
    SQLiteDatabase mydatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editTextText2);
        editText2 = findViewById(R.id.editTextText3);
        editText3 = findViewById(R.id.editTextText4);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        listView = findViewById(R.id.lv);
        myList = new ArrayList<>();
        myAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, myList);
        listView.setAdapter(myAdapter);

        mydatabase = openOrCreateDatabase("qlsinhvien.db",MODE_PRIVATE, null);
        try {
            String sql = "CREATE TABLE tbllop(malop TEXT primary key, tenlop TEXT, siso INTEGER)";
            mydatabase.execSQL(sql);
        }
        catch (Exception e)
        {
            Log.e("Error", "Table da ton tai");
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String malop = editText.getText().toString();
                String tenlop = editText2.getText().toString();
                String siso = editText3.getText().toString();
                ContentValues values = new ContentValues();
                values.put("malop", malop);
                values.put("tenlop", tenlop);
                values.put("siso", siso);
                String msg = "";
                if (mydatabase.insert("tbllop", null, values) == -1)
                {
                    msg = "Fail to Insert Record!";
                }
                else {
                    msg = "Insert Record Successfully!";
                }
                Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String malop = editText.getText().toString();
                int n = mydatabase.delete("tbllop", "malop = ?", new String[]{malop});
                String msg = "";
                if (n == 0)
                {
                    msg = "No record to Delete !";
                }
                else {
                    msg = n + " record is deleted!";
                }
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int siso = Integer.parseInt(editText3.getText().toString());
                String malop = editText.getText().toString();
                ContentValues myvalues = new ContentValues();
                myvalues.put("siso", siso);
                int n = mydatabase.update("tbllop", myvalues, "malop = ?", new String[]{malop});
                String msg = "";
                if (n == 0)
                {
                    msg = "No record to Update !";
                }
                else {
                    msg = n + " record is updated!";
                }
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                }
            });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myList.clear();
                Cursor mycursor = mydatabase.query("tbllop", null, null, null, null, null, null);
                mycursor.moveToNext();
                String data = "";
                while (mycursor.isAfterLast() == false)
                {
                    data = mycursor.getString(0)+"-"+mycursor.getString(1)+"-"+mycursor.getString(2);
                    mycursor.moveToNext();
                    myList.add(data);
                }
                mycursor.close();
                myAdapter.notifyDataSetChanged();
                }

        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}