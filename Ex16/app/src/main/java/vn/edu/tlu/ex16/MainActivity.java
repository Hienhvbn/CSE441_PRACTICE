package vn.edu.tlu.ex16;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edta, edtb, edtkq;
    Button btntong, btnclear;
    TextView txtlichsu;
    String lichsu = "";

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences myprefs = getSharedPreferences("myprefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = myprefs.edit();
        editor.putString("lichsu", lichsu);
        editor.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edta = findViewById(R.id.editTextText);
        edtb = findViewById(R.id.editTextText2);
        edtkq = findViewById(R.id.editTextText3);
        btntong = findViewById(R.id.button);
        btnclear = findViewById(R.id.button2);
        txtlichsu = findViewById(R.id.textView5);

        SharedPreferences myprefs = getSharedPreferences("myprefs", MODE_PRIVATE);
        lichsu = myprefs.getString("lichsu", "");
        txtlichsu.setText(lichsu);

        btntong.setOnClickListener(v -> {
            int a = Integer.parseInt(edta.getText().toString());
            int b = Integer.parseInt(edtb.getText().toString());
            int kq = a + b;
            edtkq.setText(kq + "");
            lichsu += a + " + " + b + " = " + kq;
            txtlichsu.setText(lichsu);
            lichsu +="\n";
        });
        btnclear.setOnClickListener(v -> {
            lichsu = "";
            txtlichsu.setText(lichsu);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}