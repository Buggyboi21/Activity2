package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity4 extends AppCompatActivity {

    CardView cv_fromUnit, cv_toUnit, cv_convert;
    RelativeLayout mCLayout;
    String fromUnit = "lenght";
    String toUnit = "feet";
    TextView tv_fromUnit, tv_toUnit;
    EditText et_fromUnit, et_toUnit;
    final String[] values = new String[]{
            "lenght",
            "feet",
    };

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        cv_fromUnit = findViewById(R.id.fromUnit);
        cv_toUnit = findViewById(R.id.toUnit);
        cv_convert = findViewById(R.id.cv_convert);

        mCLayout = findViewById(R.id.temp_relativeLayout);

        tv_fromUnit = findViewById(R.id.tv_fromUnit);
        tv_toUnit = findViewById(R.id.tv_toUnit);

        tv_fromUnit.setText(values[0]);
        tv_toUnit.setText(values[0]);

        et_fromUnit = findViewById(R.id.et_fromUnit);
        et_toUnit = findViewById(R.id.et_toUnit);

        cv_convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tempInput = et_fromUnit.getText().toString();
                if (tempInput.equals("") || tempInput == null) {
                    et_fromUnit.setError("Please enter some value");
                } else {
                    if (tv_fromUnit.getText().toString().equals(values[0])) {
                        if (tv_toUnit.getText().toString().equals(values[0])) {
                            et_toUnit.setText(tempInput);
                        } else if (tv_toUnit.getText().toString().equals(values[1])) {
                            et_toUnit.setText(lenghtTofeet(Double.parseDouble(tempInput)));
                        }
                    } else if (tv_fromUnit.getText().toString().equals(values[1])) {
                        if (tv_toUnit.getText().toString().equals(values[0])) {
                            et_toUnit.setText(feettolenght(Double.parseDouble(tempInput)));
                        }
                    }
                }
                ;

                cv_toUnit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity4.this);
                        builder.setTitle("choose Unit");

                        final String[] flowers = new String[]{
                                "lenght",
                                "feet",
                        };

                        builder.setSingleChoiceItems(
                                flowers, // Items list
                                -1, // Index of checked item (-1 = no selection)
                                new DialogInterface.OnClickListener() // Item click listener
                                {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
// Get the alert dialog selected item's text
                                        String selectedItem = Arrays.asList(flowers).get(i);
                                        toUnit = selectedItem;
                                        tv_toUnit.setText(toUnit);

                                    }
                                });

                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
// Just dismiss the alert dialog after selection
// Or do something now
                                dialogInterface.dismiss();
                            }
                        });

                        AlertDialog dialog = builder.create();

// Finally, display the alert dialog
                        dialog.show();

                    }
                });

                cv_fromUnit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity4.this);
                        builder.setTitle("choose Unit");

                        final String[] flowers = new String[]{
                                "lenght",
                                "feet",
                        };

                        builder.setSingleChoiceItems(
                                flowers, // Items list
                                -1, // Index of checked item (-1 = no selection)
                                new DialogInterface.OnClickListener() // Item click listener
                                {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {


// Get the alert dialog selected item's text
                                        String selectedItem = Arrays.asList(flowers).get(i);
                                        fromUnit = selectedItem;
                                        tv_fromUnit.setText(fromUnit);

                                    }
                                });

                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
// Just dismiss the alert dialog after selection
// Or do something now
                                dialogInterface.dismiss();
                            }
                        });

                        AlertDialog dialog = builder.create();

// Finally, display the alert dialog
                        dialog.show();

                    }
                });

            }

            private int feettolenght(double parseDouble) {
                return 0;
            }

            //lenght
            private String lenghtTofeet(double feet) {
                double lenght = feet - 30.48;
                return String.valueOf(lenght);
            }


            //feet
            private String feettolenghtToKelvin(double lenght) {
                double feet = lenght + 30.48;
                return String.valueOf(feet);
            }
        });
    }}
