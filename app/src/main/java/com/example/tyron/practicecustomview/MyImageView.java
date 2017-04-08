package com.example.tyron.practicecustomview;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;

/**
 * Created by tyron on 08/04/2017.
 */

public class MyImageView extends android.support.v7.widget.AppCompatImageView {


    float dX, dY;

    public static final String DEBUG_TAG = "long";

    public MyImageView(Context context) {
        super(context);
    }

    public MyImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public String toString(MotionEvent event) {
        return "MyImageView{" +
                ", viewX=" + (event.getRawX()-dX) +
                ", viewY=" + (event.getRawY()-dY) +
                ", eventX=" + event.getRawX() +
                ", eventY=" + event.getRawY() +
                ", fx=" + (event.getRawX()+dX) +
                ", fy=" + (event.getRawX()+dY) +
                '}';
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        int action = MotionEventCompat.getActionMasked(event);

        switch(action) {
            case (MotionEvent.ACTION_DOWN):

                dX = getX()-event.getRawX();
                dY = getY()-event.getRawY();


                //Log.i(DEBUG_TAG,"Action was DOWN");
                return true;
            case (MotionEvent.ACTION_MOVE):

                setX(event.getRawX()+ dX);
                setY(event.getRawY()+ dY);

                //Log.i(DEBUG_TAG, toString(event));
                return true;
            case (MotionEvent.ACTION_UP):
                Log.i(DEBUG_TAG, "Action was UP");
                return true;
            case (MotionEvent.ACTION_CANCEL):
                Log.i(DEBUG_TAG, "Action was CANCEL");
                return true;
            case (MotionEvent.ACTION_OUTSIDE):
                Log.i(DEBUG_TAG, "Movement occurred outside bounds " +
                        "of current screen element");
                return true;
            default:
                return super.onTouchEvent(event);
        }
    }

}
