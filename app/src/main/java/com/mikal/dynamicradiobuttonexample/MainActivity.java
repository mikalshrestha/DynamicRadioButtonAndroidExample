package com.mikal.dynamicradiobuttonexample;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> stringList = new ArrayList<>();
    private RadioButton radioButton;
    private RadioGroup radioGroup;
    private LinearLayout linearLayout;


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.llRadioButtonContainer);

        stringList.add("Radio Button Text Example 1");
        stringList.add("Radio Button Text Example 2");
        stringList.add("Radio Button Text Example 3");
        stringList.add("Radio Button Text Example 4");
        stringList.add("Radio Button Text Example 5");
        stringList.add("Radio Button Text Example 6");


        radioGroup = new RadioGroup(this);
        radioGroup.setOrientation(LinearLayout.VERTICAL);
        radioGroup.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

        RadioGroup.LayoutParams layoutParams;

        for (int i = 0; i < stringList.size(); i++){
            radioButton = new RadioButton(this);
            radioButton.setText(stringList.get(i));
            radioButton.setPadding(20,0,0,0);

            layoutParams = new RadioGroup.LayoutParams(RadioGroup.LayoutParams.MATCH_PARENT, RadioGroup.LayoutParams.MATCH_PARENT);
            layoutParams.setMargins(0,20,0,0);
            radioGroup.addView(radioButton, layoutParams);
        }

        linearLayout.addView(radioGroup);

        //to find selected id and text of radiobutton

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                RadioButton checkedRadioButton = (RadioButton) radioGroup.findViewById(checkedId);
                int checkedRadioButtonId = radioGroup.indexOfChild(checkedRadioButton);
                String checkedRadioButtonText = checkedRadioButton.getText().toString();

                Toast.makeText(MainActivity.this, "Selected text of radio button is:" + checkedRadioButtonText, Toast.LENGTH_SHORT).show();
            }
        });
    }
}