package com.example.pr31;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private GestureDetector gestureDetector;
    public ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        imageView = findViewById(R.id.imageView1);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        RadioButton radioButton1 = findViewById(R.id.radioButton1);
        RadioButton radioButton2 = findViewById(R.id.radioButton2);
        RadioButton radioButton3 = findViewById(R.id.radioButton3);

        gestureDetector = new GestureDetector(this, new GestureListener());
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioButton1) {
                    imageView.setImageResource(R.drawable.image1);
                } else if (checkedId == R.id.radioButton2) {
                    imageView.setImageResource(R.drawable.image2);
                }else if (checkedId == R.id.radioButton3){
                    imageView.setImageResource(R.drawable.image3);
                }
            }
        });
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    private class GestureListener extends GestureDetector.SimpleOnGestureListener {
        private static final int SWIPE_THRESHOLD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 100;

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            float deltaX = e2.getX() - e1.getX();
            float deltaY = e2.getY() - e1.getY();
            if (Math.abs(deltaX) > Math.abs(deltaY) && Math.abs(deltaX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                if (deltaX > 0) {
                    // Свайп вправо
                    Toast.makeText(SecondActivity.this, "Swipe Right", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    // Свайп влево
                    Toast.makeText(SecondActivity.this, "Swipe Left", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                    startActivity(intent);
                }
                return true;
            }
            return false;
        }
    }
}