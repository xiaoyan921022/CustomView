package com.test.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.PictureDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * @author Yan
 * @date 2019/10/17.
 * description：
 */
public class CustomView2 extends View {

    // 1.创建一个画笔
    private Paint mPaint = new Paint();

    // 1.创建Picture
    private Picture mPicture = new Picture();

    private int type = 0;

    public CustomView2(Context context) {
        super(context);
    }

    public CustomView2(Context context, @Nullable AttributeSet attrs) {
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
        //-------------------画布操作----------------------
        // 将坐标系原点移动到画布正中心
        canvas.translate(getWidth() / 2, getHeight() / 2);
        switch (type) {
            case 0:
                //位移
                // 在坐标原点绘制一个黑色圆形
                mPaint.setColor(Color.BLACK);
                canvas.translate(200, 200);
                canvas.drawCircle(0, 0, 100, mPaint);

                // 在坐标原点绘制一个蓝色圆形
                mPaint.setColor(Color.BLUE);
                canvas.translate(200, 200);
                canvas.drawCircle(0, 0, 100, mPaint);
                break;
            case 1:
                //缩放
                RectF rect1 = new RectF(0, -400, 400, 0);   // 矩形区域
                mPaint.setColor(Color.BLACK);           // 绘制黑色矩形
                canvas.drawRect(rect1, mPaint);
                canvas.scale(0.5f, 0.5f);                // 画布缩放
                mPaint.setColor(Color.BLUE);            // 绘制蓝色矩形
                canvas.drawRect(rect1, mPaint);
                break;
            case 2:
                //缩放  更改缩放中心
                RectF rect2 = new RectF(0, -400, 400, 0);   // 矩形区域
                mPaint.setColor(Color.BLACK);           // 绘制黑色矩形
                canvas.drawRect(rect2, mPaint);
                canvas.scale(0.5f, 0.5f, 200, 0);          // 画布缩放  <-- 缩放中心向右偏移了200个单位
                mPaint.setColor(Color.BLUE);            // 绘制蓝色矩形
                canvas.drawRect(rect2, mPaint);
                break;
            case 3:
                //缩放 翻转缩放
                RectF rect3 = new RectF(0, -400, 400, 0);   // 矩形区域
                mPaint.setColor(Color.BLACK);           // 绘制黑色矩形
                canvas.drawRect(rect3, mPaint);
                canvas.scale(-0.5f, -0.5f);          // 画布缩放
                mPaint.setColor(Color.BLUE);            // 绘制蓝色矩形
                canvas.drawRect(rect3, mPaint);
                break;
            case 4:
                //叠加缩放
                mPaint.setStyle(Paint.Style.STROKE);
                RectF rect4 = new RectF(-400, -400, 400, 400);   // 矩形区域
                for (int i = 0; i <= 20; i++) {
                    canvas.scale(0.9f, 0.9f);
                    canvas.drawRect(rect4, mPaint);
                }
                break;
            case 5:
                //旋转
                RectF rect5 = new RectF(0, -400, 400, 0);   // 矩形区域
                mPaint.setColor(Color.BLACK);           // 绘制黑色矩形
                canvas.drawRect(rect5, mPaint);
                canvas.rotate(180);                     // 旋转180度 <-- 默认旋转中心为原点
                mPaint.setColor(Color.BLUE);            // 绘制蓝色矩形
                canvas.drawRect(rect5, mPaint);
                break;
            case 6:
                RectF rect6 = new RectF(0, -400, 400, 0);   // 矩形区域
                mPaint.setColor(Color.BLACK);           // 绘制黑色矩形
                canvas.drawRect(rect6, mPaint);
                canvas.rotate(180, 200, 0);               // 旋转180度 <-- 旋转中心向右偏移200个单位
                mPaint.setColor(Color.BLUE);            // 绘制蓝色矩形
                canvas.drawRect(rect6, mPaint);
                break;
            case 7:
                //错切
                RectF rect7 = new RectF(0, 0, 200, 200);   // 矩形区域
                mPaint.setColor(Color.BLACK);           // 绘制黑色矩形
                canvas.drawRect(rect7, mPaint);
                canvas.skew(1, 0);                       // 水平错切 <- 45度
                mPaint.setColor(Color.BLUE);            // 绘制蓝色矩形
                canvas.drawRect(rect7, mPaint);
                break;
            case 8:
                // 将Picture中的内容绘制在Canvas上
                //PS：这种方法在比较低版本的系统上绘制后可能会影响Canvas状态，所以这种方法一般不会使用。
//        mPicture.draw(canvas);

                //使用Canvas提供的drawPicture方法绘制
//        canvas.drawPicture(mPicture,new RectF(0,0,mPicture.getWidth(),200));

                //将Picture包装成为PictureDrawable，使用PictureDrawable的draw方法绘制。
                // 包装成为Drawable
                PictureDrawable drawable = new PictureDrawable(mPicture);
                // 设置绘制区域 -- 注意此处所绘制的实际内容不会缩放
                drawable.setBounds(0, 0, 250, mPicture.getHeight());
                // 绘制
                drawable.draw(canvas);
                break;
        }


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
        canvas.translate(250, 250);
        // 绘制一个圆
        canvas.drawCircle(0, 0, 100, paint);

        mPicture.endRecording();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_UP:
                if (type == 8) {
                    type = 0;
                } else {
                    type++;
                }
                invalidate();
                break;
        }
        return true;
    }
}
