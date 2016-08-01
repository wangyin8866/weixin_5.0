package wy.com.myapplication;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;

/**
 * Created by DELL on 2016/7/12.
 */
public class GuanZhuActivity extends AppCompatActivity {
    private LinearLayout l1, l2, l3, l4, l5, l6;
    private static final String TAG = "Tab3_Fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab02);
        initView();
    }

    private void initView() {
        l1 = (LinearLayout) findViewById(R.id.ll_01);
        l2 = (LinearLayout) findViewById(R.id.ll_02);
        l3 = (LinearLayout) findViewById(R.id.ll_03);
        l4 = (LinearLayout) findViewById(R.id.ll_04);
        l5 = (LinearLayout) findViewById(R.id.ll_05);
        l6 = (LinearLayout) findViewById(R.id.ll_06);

        setAnimIn(l1, new DecelerateInterpolator());
        setAnimIn(l2, new AccelerateInterpolator());
        setAnimIn(l3, new BounceInterpolator());
        setAnimIn(l4, new BounceInterpolator());
        setAnimIn(l5, new DecelerateInterpolator());
        setAnimIn(l6, new AccelerateInterpolator());


    }

    public void cancel(View view) {
        view.setVisibility(View.GONE);
        setAnimOut(l1, new DecelerateInterpolator());
        setAnimOut(l2, new AccelerateInterpolator());
        setAnimOut(l3, new BounceInterpolator());
        setAnimOut(l4, new BounceInterpolator());
        setAnimOut(l5, new DecelerateInterpolator());
        ObjectAnimator anim1 = ObjectAnimator.ofFloat(l6, "translationY", -100);
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(l6, "translationY", 1000);
        anim1.setDuration(500);
        anim2.setDuration(1000);
        anim2.setInterpolator(new AccelerateInterpolator());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(anim1, anim2);
        animatorSet.start();

        anim2.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                startActivity(new Intent(GuanZhuActivity.this, MainActivity.class));
                finish();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

    }

    private void setAnimIn(View view, Interpolator interpolator) {
        ObjectAnimator anim1 = ObjectAnimator.ofFloat(view, "translationY", -1000);
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(view, "translationY", 0);
        anim1.setDuration(0);
        anim2.setDuration(1000);
        anim2.setInterpolator(interpolator);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(anim1, anim2);
        animatorSet.start();

    }

    private void setAnimOut(View view, Interpolator interpolator) {
        ObjectAnimator anim1 = ObjectAnimator.ofFloat(view, "translationY", -100);
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(view, "translationY", 1000);
        anim1.setDuration(500);
        anim2.setDuration(1000);
        anim2.setInterpolator(interpolator);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(anim1, anim2);
        animatorSet.start();
    }
}
