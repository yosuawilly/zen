package com.belajar.shalat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class TransparentLinearLayout extends LinearLayout{

	public TransparentLinearLayout(Context context) {
		super(context);
	}
	
	public TransparentLinearLayout(Context context, AttributeSet attr) {
		super(context, attr);
	}
	
	@Override
	protected void dispatchDraw(Canvas canvas) {
		RectF drawRect = new RectF();
		drawRect.set(0,0, getMeasuredWidth(), getMeasuredHeight());
		
		Paint innerPaint = new Paint();
		innerPaint.setARGB(225, 75, 75, 75);
		
		Paint borderPaint = new Paint();
		borderPaint.setARGB(255, 255, 255, 255);
		borderPaint.setAntiAlias(true);
		borderPaint.setStyle(Paint.Style.STROKE);
		borderPaint.setStrokeWidth(2);
		
		canvas.drawRoundRect(drawRect, 5, 5, innerPaint);
		canvas.drawRoundRect(drawRect, 5, 5, borderPaint);
		super.dispatchDraw(canvas);
		getBackground().setAlpha(50);
	}

}
