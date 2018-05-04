package com.example.android.java;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    //private RelativeLayout canvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.faceIcon);
        //canvas = (RelativeLayout) findViewById(R.id.animationCanvas);
    }

    /*public void onButtonClick(View v) {

        int screenHeight = canvas.getHeight();
        int targetY = screenHeight - imageView.getHeight();

        ObjectAnimator animator = ObjectAnimator.ofFloat(
                imageView, "y", 0, targetY)
                .setDuration(1000);
        animator.setInterpolator(new BounceInterpolator());
        animator.start();
    }*/
    public void onButtonClick(View v) {
        imageView.animate()
                .alpha(0)
                .scaleX(2)
                .scaleY(2)
                .scaleXBy(1)
                .scaleYBy(1)
                .setDuration(3000)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        Log.i("Animation", "onAnimationStart");
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        imageView.animate()
                                .alpha(1)
                                .translationX(200)
                                .translationY(100)
                                .translationY(-200)
                                .rotation(50)
                                .setListener(new Animator.AnimatorListener() {

                                    @Override
                                    public void onAnimationStart(Animator animation) {

                                    }

                                    @Override
                                    public void onAnimationEnd(Animator animator) {
                                        imageView.animate()
                                                .alpha(1)
                                                .translationX(-400)
                                                .rotation(-900)
                                                .setListener(new Animator.AnimatorListener() {
                                                    @Override
                                                    public void onAnimationStart(Animator animator) {

                                                    }

                                                    @Override
                                                    public void onAnimationEnd(Animator animator) {
                                                        imageView.animate()
                                                                .alpha(0)
                                                                .translationX(250)
                                                                .translationY(-200)
                                                                .scaleX(5)
                                                                .scaleY(5)
                                                                .rotation(-900);
                                                    }

                                                    @Override
                                                    public void onAnimationCancel(Animator animation) {

                                                    }

                                                    @Override
                                                    public void onAnimationRepeat(Animator animation) {

                                                    }
                                                });
                                    }

                                    @Override
                                    public void onAnimationCancel(Animator animation) {

                                    }

                                    @Override
                                    public void onAnimationRepeat(Animator animation) {

                                    }
                                });
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
    }

}