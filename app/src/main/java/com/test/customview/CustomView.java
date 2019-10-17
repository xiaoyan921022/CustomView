package com.test.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.PictureDrawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by yanqz on 2019-10-16.
 */
public class CustomView extends View {

    // 1.创建一个画笔
    private Paint mPaint = new Paint();

    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }


    // 2.初始化画笔
    private void initPaint() {
        mPaint.setColor(Color.BLACK);       //设置画笔颜色
        mPaint.setStyle(Paint.Style.FILL);  //设置画笔模式为填充
        mPaint.setStrokeWidth(10f);         //设置画笔宽度为10px
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制点
        canvas.drawPoint(100, 100, mPaint);     //在坐标(200,200)位置绘制一个点
        canvas.drawPoints(new float[]{          //绘制一组点，坐标位置由float数组指定
                200, 150,
                200, 200,
                200, 250
        }, mPaint);

        //绘制直线
        canvas.drawLine(300, 100, 500, 150, mPaint);    // 在坐标(300,300)(500,600)之间绘制一条直线
        canvas.drawLines(new float[]{               // 绘制一组线 每四数字(两个点的坐标)确定一条线
                300, 200, 400, 200,
                300, 300, 400, 300
        }, mPaint);

        //绘制矩形
        // 第一种
        canvas.drawRect(100, 400, 500, 600, mPaint);
        // 第二种
        Rect rect1 = new Rect(100, 400, 500, 600);
        canvas.drawRect(rect1, mPaint);
        // 第三种
        RectF rectF1 = new RectF(100, 400, 500, 600);
        canvas.drawRect(rectF1, mPaint);

        //绘制圆角矩形
        // 第一种
        RectF rectF2 = new RectF(600,400,1000,600);
        canvas.drawRoundRect(rectF2,30,30,mPaint);

        // 第二种
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            canvas.drawRoundRect(100,600,1000,1000,30,30,mPaint);
//        }

        //绘制圆形
        canvas.drawCircle(200,800,150,mPaint);

        //绘制圆弧
        RectF rectF3 = new RectF(100,1000,300,1200);
        // 绘制背景矩形
        mPaint.setColor(Color.GRAY);
        canvas.drawRect(rectF3,mPaint);

        // 绘制圆弧
        mPaint.setColor(Color.BLUE);
        canvas.drawArc(rectF3,0,90,false,mPaint);


        RectF rectF4 = new RectF(400,1000,700,1200);
        // 绘制背景矩形
        mPaint.setColor(Color.GRAY);
        canvas.drawRect(rectF4,mPaint);

        // 绘制圆弧
        mPaint.setColor(Color.BLUE);
        canvas.drawArc(rectF4,0,90,true,mPaint);

    }

}
