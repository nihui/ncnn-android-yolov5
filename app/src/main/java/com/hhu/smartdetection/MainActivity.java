package com.hhu.smartdetection;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.xuexiang.xui.XUI;
import com.xuexiang.xui.widget.button.ButtonView;
import com.xuexiang.xui.widget.button.roundbutton.RoundButton;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        XUI.initTheme(this);//加入这行代码
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RoundButton button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int option = 0; // 要传递的标题
                Intent intent = new Intent(MainActivity.this, DetectionActivity.class);
                intent.putExtra("OPTION", option);
                startActivity(intent);
            }
        });

        RoundButton button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int option = 1; // 要传递的标题
                Intent intent = new Intent(MainActivity.this, DetectionActivity.class);
                intent.putExtra("OPTION", option);
                startActivity(intent);
            }
        });

        RoundButton button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int option = 2; // 要传递的标题
                Intent intent = new Intent(MainActivity.this, DetectionActivity.class);
                intent.putExtra("OPTION", option);
                startActivity(intent);
            }
        });

        RoundButton button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int option = 3; // 要传递的标题
                Intent intent = new Intent(MainActivity.this, DetectionActivity.class);
                intent.putExtra("OPTION", option);
                startActivity(intent);
            }
        });

        RoundButton button5 = findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int option = 4; // 要传递的标题
                Intent intent = new Intent(MainActivity.this, DetectionActivity.class);
                intent.putExtra("OPTION", option);
                startActivity(intent);
            }
        });

        RoundButton button6 = findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int option = 5; // 要传递的标题
                Intent intent = new Intent(MainActivity.this, DetectionActivity.class);
                intent.putExtra("OPTION", option);
                startActivity(intent);
            }
        });

        RoundButton button7 = findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int option = 6; // 要传递的标题
                Intent intent = new Intent(MainActivity.this, DetectionActivity.class);
                intent.putExtra("OPTION", option);
                startActivity(intent);
            }
        });

        RoundButton button8 = findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int option = 7; // 要传递的标题
                Intent intent = new Intent(MainActivity.this, DetectionActivity.class);
                intent.putExtra("OPTION", option);
                startActivity(intent);
            }
        });

        RoundButton button9 = findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int option = 8; // 要传递的标题
                Intent intent = new Intent(MainActivity.this, DetectionActivity.class);
                intent.putExtra("OPTION", option);
                startActivity(intent);
            }
        });
    }
}
