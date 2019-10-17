package com.test.customview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_canvas,btn_canvas2, btn_bezier1, btn_bezier2;
    private CustomView canvas;
    private CustomView2 canvas2;
    private Bezier bezier;
    private MagicCircle circle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_canvas = findViewById(R.id.btn_canvas);
        btn_canvas2 = findViewById(R.id.btn_canvas2);
        btn_bezier1 = findViewById(R.id.btn_bezier1);
        btn_bezier2 = findViewById(R.id.btn_bezier2);

        canvas = findViewById(R.id.canvas);
        canvas2 = findViewById(R.id.canvas2);
        bezier = findViewById(R.id.bezier);
        circle = findViewById(R.id.circle);
        btn_canvas.setOnClickListener(this);
        btn_canvas2.setOnClickListener(this);
        btn_bezier1.setOnClickListener(this);
        btn_bezier2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_canvas:
                setViewVisible(canvas,true);
                setViewVisible(canvas2,false);
                setViewVisible(bezier,false);
                setViewVisible(circle,false);
                break;
            case R.id.btn_canvas2:
                setViewVisible(canvas,false);
                setViewVisible(canvas2,true);
                setViewVisible(bezier,false);
                setViewVisible(circle,false);
                break;
            case R.id.btn_bezier1:
                setViewVisible(canvas,false);
                setViewVisible(canvas2,false);
                setViewVisible(bezier,true);
                setViewVisible(circle,false);
                break;
            case R.id.btn_bezier2:
                setViewVisible(canvas,false);
                setViewVisible(canvas2,false);
                setViewVisible(bezier,false);
                setViewVisible(circle,true);
                circle.startAnimation();
                break;
        }
    }

    private void setViewVisible(View view, boolean visible) {
        view.setVisibility(visible ? View.VISIBLE : View.GONE);
    }
}
