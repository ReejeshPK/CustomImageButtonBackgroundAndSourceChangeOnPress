package com.blogspot.cavemanbacktocave.buttonpressbgsrc;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

public class MyImageButton extends AppCompatImageButton {

    private String TAG = MyImageButton.class.getSimpleName();
    private int normalBackgroundResource, pressedBackgroundResource, normalSrc, pressedSrc;

    public MyImageButton(@NonNull Context context) {
        super(context);
    }

    public MyImageButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initMe(context, attrs);
    }

    private void initMe(Context context, AttributeSet attrs) {
        initalizeMe(context, attrs);
    }

    public MyImageButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initMe(context, attrs, defStyleAttr);
    }

    private void initMe(Context context, AttributeSet attrs, int defStyleAttr) {
        initalizeMe(context, attrs);
    }

    private void initalizeMe(Context context, AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.MyImageButton, 0, 0);
        try {
            normalBackgroundResource = ta.getResourceId(R.styleable.MyImageButton_normalBackground, -1);
            pressedBackgroundResource = ta.getResourceId(R.styleable.MyImageButton_pressedBackground, -1);

            normalSrc = ta.getResourceId(R.styleable.MyImageButton_normalSrc, -1);
            pressedSrc = ta.getResourceId(R.styleable.MyImageButton_pressedSrc, -1);

            //setting default
            setImageResource(normalSrc);
            setBackground(ContextCompat.getDrawable(context, normalBackgroundResource));

        } catch (Exception e) {
            Toast.makeText(getContext(), "Some error at MyImageButton, See Error Logs", Toast.LENGTH_SHORT).show();
            Log.e(TAG, "initMe: " + e.getMessage());
        } finally {
            ta.recycle();
        }
    }

    @Override
    protected void drawableStateChanged() {
        /***
         * Credits:
         * https://stackoverflow.com/a/8518217/7710739
         *
         * Author: Muffinmad
         * https://stackoverflow.com/users/824739/muffinmad
         *
         * Comment with highest votes
         * */
        Log.d(TAG, "drawableStateChanged: ");
        if (isPressed()) {
            //Log.d(TAG, "drawableStateChanged: set"+pressedSrc+" pressbg:"+pressedBackgroundResource);
            if (pressedBackgroundResource != -1) {
                setMyBackground(pressedBackgroundResource);
            }
            if (pressedSrc != -1) {
                setImageResource(pressedSrc);
            }
        } else {
            //Log.d(TAG, "drawableStateChanged: set not press"+normalSrc+" normalbg:"+normalBackgroundResource);
            if (normalBackgroundResource != -1) {
                setMyBackground(normalBackgroundResource);
            }
            if (normalSrc != -1) {
                setImageResource(normalSrc);
            }
        }
        super.drawableStateChanged();
    }

    private void setMyBackground(int drawableResourceId) {
        //setBackground(ResourcesCompat.getDrawable(getContext().getResources(),drawableResourceId,getContext().getTheme()));
        setBackground(ContextCompat.getDrawable(getContext(), drawableResourceId));
    }
}
