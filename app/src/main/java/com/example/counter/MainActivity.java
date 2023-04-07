package com.example.counter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textCount;
    private Button button;
    private int count = 0;
    private int counter = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textCount = findViewById(R.id.textCount);
        button = findViewById(R.id.button);

        button.setOnClickListener(Listener);
    }
    private View.OnClickListener Listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            count ++;
            textCount.setText(Integer.toString(count));
        }
    };

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("key", count);
        Toast toast = Toast.makeText(this, "запись данных в контейнер Bundle", Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        count = savedInstanceState.getInt("key");
        Toast toast = Toast.makeText(this, "считывание данных из контейнера Bundle", Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    protected void onResume() {
        Toast toast = Toast.makeText(this, "сброс активности", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        //LinearLayout toastContainer = (LinearLayout) toast.getView();
        //ImageView cat = new ImageView(this);
        //cat.setImageResource(R.drawable.cat);
        //toastContainer.addView(cat, 1);
        toast.show();
        super.onResume();
    }

    @Override
    protected void onPause() {
        Toast toast = Toast.makeText(this,"пауза активности", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0, 0);
        toast.show();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        Toast toast = Toast.makeText(this, "уничтожение активности", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.show();
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        Toast toast = Toast.makeText(this, "стоп активности", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.LEFT, 0, 0);
        toast.show();
        super.onStop();
    }

    @Override
    protected void onStart() {
        Toast toast = Toast.makeText(this, "старт активности", Toast.LENGTH_SHORT);
        toast.show();

        super.onStart();
    }
}