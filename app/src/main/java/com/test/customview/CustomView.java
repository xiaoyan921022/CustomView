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

    // 1.创建Picture
    private Picture mPicture = new Picture();

    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
        recording();
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
//        //绘制点
//        canvas.drawPoint(100, 100, mPaint);     //在坐标(200,200)位置绘制一个点
//        canvas.drawPoints(new float[]{          //绘制一组点，坐标位置由float数组指定
//                200, 150,
//                200, 200,
//                200, 250
//        }, mPaint);
//
//        //绘制直线
//        canvas.drawLine(300, 100, 500, 150, mPaint);    // 在坐标(300,300)(500,600)之间绘制一条直线
//        canvas.drawLines(new float[]{               // 绘制一组线 每四数字(两个点的坐标)确定一条线
//                300, 200, 400, 200,
//                300, 300, 400, 300
//        }, mPaint);
//
//        //绘制矩形
//        // 第一种
//        canvas.drawRect(100, 400, 500, 600, mPaint);
//        // 第二种
//        Rect rect1 = new Rect(100, 400, 500, 600);
//        canvas.drawRect(rect1, mPaint);
//        // 第三种
//        RectF rectF1 = new RectF(100, 400, 500, 600);
//        canvas.drawRect(rectF1, mPaint);
//
//        //绘制圆角矩形
//        // 第一种
//        RectF rectF2 = new RectF(600,400,1000,600);
//        canvas.drawRoundRect(rectF2,30,30,mPaint);
//
//        // 第二种
////        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
////            canvas.drawRoundRect(100,600,1000,1000,30,30,mPaint);
////        }
//
//        //绘制圆形
//        canvas.drawCircle(200,800,150,mPaint);
//
//        //绘制圆弧
//        RectF rectF3 = new RectF(100,1000,300,1200);
//        // 绘制背景矩形
//        mPaint.setColor(Color.GRAY);
//        canvas.drawRect(rectF3,mPaint);
//
//        // 绘制圆弧
//        mPaint.setColor(Color.BLUE);
//        canvas.drawArc(rectF3,0,90,false,mPaint);
//
//
//        RectF rectF4 = new RectF(400,1000,700,1200);
//        // 绘制背景矩形
//        mPaint.setColor(Color.GRAY);
//        canvas.drawRect(rectF4,mPaint);
//
//        // 绘制圆弧
//        mPaint.setColor(Color.BLUE);
//        canvas.drawArc(rectF4,0,90,true,mPaint);


        //-------------------画布操作----------------------
//        //位移
//        // 在坐标原点绘制一个黑色圆形
//        mPaint.setColor(Color.BLACK);
//        canvas.translate(200,200);
//        canvas.drawCircle(0,0,100,mPaint);
//
//        // 在坐标原点绘制一个蓝色圆形
//        mPaint.setColor(Color.BLUE);
//        canvas.translate(200,200);
//        canvas.drawCircle(0,0,100,mPaint);

        // 将坐标系原点移动到画布正中心
//        canvas.translate(getWidth() / 2, getHeight() / 2);

        //缩放
//        RectF rect = new RectF(0,-400,400,0);   // 矩形区域
//
//        mPaint.setColor(Color.BLACK);           // 绘制黑色矩形
//        canvas.drawRect(rect,mPaint);
//
//        canvas.scale(0.5f,0.5f);                // 画布缩放
//
//        mPaint.setColor(Color.BLUE);            // 绘制蓝色矩形
//        canvas.drawRect(rect,mPaint);

//        RectF rect = new RectF(0,-400,400,0);   // 矩形区域
//
//        mPaint.setColor(Color.BLACK);           // 绘制黑色矩形
//        canvas.drawRect(rect,mPaint);
//
//        canvas.scale(0.5f,0.5f,200,0);          // 画布缩放  <-- 缩放中心向右偏移了200个单位
//
//        mPaint.setColor(Color.BLUE);            // 绘制蓝色矩形
//        canvas.drawRect(rect,mPaint);

//        RectF rect = new RectF(0,-400,400,0);   // 矩形区域
//
//        mPaint.setColor(Color.BLACK);           // 绘制黑色矩形
//        canvas.drawRect(rect,mPaint);
//
//
//        canvas.scale(-0.5f,-0.5f);          // 画布缩放
//
//        mPaint.setColor(Color.BLUE);            // 绘制蓝色矩形
//        canvas.drawRect(rect,mPaint);

        //叠加缩放
//        mPaint.setStyle(Paint.Style.STROKE);
//
//        RectF rect = new RectF(-400,-400,400,400);   // 矩形区域
//
//        for (int i=0; i<=20; i++)
//        {
//            canvas.scale(0.9f,0.9f);
//            canvas.drawRect(rect,mPaint);
//        }

        //旋转
//
//        RectF rect = new RectF(0,-400,400,0);   // 矩形区域
//
//        mPaint.setColor(Color.BLACK);           // 绘制黑色矩形
//        canvas.drawRect(rect,mPaint);
//
//        canvas.rotate(180);                     // 旋转180度 <-- 默认旋转中心为原点
//
//        mPaint.setColor(Color.BLUE);            // 绘制蓝色矩形
//        canvas.drawRect(rect,mPaint);

//        RectF rect = new RectF(0,-400,400,0);   // 矩形区域
//
//        mPaint.setColor(Color.BLACK);           // 绘制黑色矩形
//        canvas.drawRect(rect,mPaint);
//
//        canvas.rotate(180,200,0);               // 旋转180度 <-- 旋转中心向右偏移200个单位
//
//        mPaint.setColor(Color.BLUE);            // 绘制蓝色矩形
//        canvas.drawRect(rect,mPaint);

        //错切
//        RectF rect = new RectF(0,0,200,200);   // 矩形区域
//
//        mPaint.setColor(Color.BLACK);           // 绘制黑色矩形
//        canvas.drawRect(rect,mPaint);
//
//        canvas.skew(1,0);                       // 水平错切 <- 45度
//
//        mPaint.setColor(Color.BLUE);            // 绘制蓝色矩形
//        canvas.drawRect(rect,mPaint);

        // 将Picture中的内容绘制在Canvas上
        //PS：这种方法在比较低版本的系统上绘制后可能会影响Canvas状态，所以这种方法一般不会使用。
//        mPicture.draw(canvas);

        //使用Canvas提供的drawPicture方法绘制
//        canvas.drawPicture(mPicture,new RectF(0,0,mPicture.getWidth(),200));

        //将Picture包装成为PictureDrawable，使用PictureDrawable的draw方法绘制。
        // 包装成为Drawable
        PictureDrawable drawable = new PictureDrawable(mPicture);
        // 设置绘制区域 -- 注意此处所绘制的实际内容不会缩放
        drawable.setBounds(0,0,250,mPicture.getHeight());
        // 绘制
        drawable.draw(canvas);
    }

    // 2.录制内容方法
    private void recording() {
        // 开始录制 (接收返回值Canvas)
        Canvas canvas = mPicture.beginRecording(500, 500);
        // 创建一个画笔
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);

        // 在Canvas中具体操作
        // 位移
        canvas.translate(250,250);
        // 绘制一个圆
        canvas.drawCircle(0,0,100,paint);

        mPicture.endRecording();
    }
}
