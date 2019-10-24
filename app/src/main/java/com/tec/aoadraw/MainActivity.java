package com.tec.aoadraw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SpecialView specialView = new SpecialView(this);
        setContentView(specialView);
    }

    private class SpecialView extends View {
        float x = 50;
        float y = 50;
        String action   = "Accion";
        Path path   = new Path();

        public SpecialView(Context context){
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas){
            canvas.drawColor(Color.rgb(255,255,150));
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(6);
            paint.setColor(Color.BLUE);

            if (action.equals("down"))
                path.moveTo(x,y);
            else if (action.equals("move"))
                path.lineTo(x,y);

            canvas.drawPath(path,paint);
        }

        @Override
        public boolean onTouchEvent(MotionEvent motionEvent){
            x   = motionEvent.getX();
            y   = motionEvent.getY();

            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                action  = "down";
            else if (motionEvent.getAction() == MotionEvent.ACTION_MOVE)
                action  = "move";

            invalidate();

            return true;
        }

    }

}
