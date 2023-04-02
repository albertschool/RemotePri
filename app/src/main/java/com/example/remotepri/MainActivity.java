package com.example.remotepri;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnPlus, btnMinus, btnOn, btnOff, btnMode;
    TextView tVTemp, tVMode;
    int tempCool, tempHeat;
    boolean activeAC, modeCool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initviews();

        activeAC = false;
        modeCool = true;
        tempCool = 10;
        tempHeat = 20;

        btnOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!activeAC) {
                    activeAC = true;
                    Toast.makeText(MainActivity.this, "A/C ON", Toast.LENGTH_SHORT).show();
                    if (modeCool) {
                        tVTemp.setText(""+tempCool);
                        tVMode.setText("COOL");
                    } else {
                        tVTemp.setText(""+tempHeat);
                        tVMode.setText("HEAT");
                    }
                }
            }
        });

        btnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (activeAC) {
                    activeAC = false;
                    Toast.makeText(MainActivity.this, "A/C OFF", Toast.LENGTH_SHORT).show();
                    tVTemp.setText("");
                    tVMode.setText("");
                }
            }
        });

        btnMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (activeAC) {
                    if (modeCool) {
                        modeCool = false;
                        tVTemp.setText(""+tempHeat);
                        tVMode.setText("HEAT");
                    } else {
                        modeCool = true;
                        tVTemp.setText(""+tempCool);
                        tVMode.setText("COOL");
                    }
                }
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (activeAC) {
                    if (modeCool) {
                        if (tempCool<25) {
                            tempCool++;
                            tVTemp.setText(""+tempCool);
                        }
                    } else {
                        if (tempHeat<30) {
                            tempHeat++;
                            tVTemp.setText(""+tempHeat);
                        }
                    }
                }
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (activeAC) {
                    if (modeCool) {
                        if (tempCool>10) {
                            tempCool--;
                            tVTemp.setText(""+tempCool);
                        }
                    } else {
                        if (tempHeat>20) {
                            tempHeat--;
                            tVTemp.setText(""+tempHeat);
                        }
                    }
                }
            }
        });

    }

    private void initviews() {
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnOn = findViewById(R.id.btnOn);
        btnOff  = findViewById(R.id.btnOff);
        btnMode = findViewById(R.id.btnMode);
        tVTemp = findViewById(R.id.tVTemp);
        tVMode = findViewById(R.id.tVMode);

    }
}