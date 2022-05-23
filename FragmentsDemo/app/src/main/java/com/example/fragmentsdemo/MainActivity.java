package com.example.fragmentsdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {


    LinearLayout fragmentContainerLayout;
    Button backButton, nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentContainerLayout = findViewById(R.id.fragment_container_layout);
        backButton = findViewById(R.id.back_button);
        nextButton = findViewById(R.id.next_button);

        nextButton.setText("Start");
        backButton.setVisibility(View.GONE);
        addSlideOne();

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextButton.setText("Start");
                backButton.setVisibility(View.GONE);
                addSlideOne();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextButton.setText("Next");
                backButton.setVisibility(View.VISIBLE);
                addSlideTwo();
            }
        });


    }

    private void addSlideOne(){
        SlideOneFragment slideOneFragment = new SlideOneFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container_layout, slideOneFragment);
        transaction.commit();
    }

    private void addSlideTwo(){
        SlideTwoFragment slideTwoFragment = new SlideTwoFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container_layout, slideTwoFragment);
        transaction.commit();
    }

}
