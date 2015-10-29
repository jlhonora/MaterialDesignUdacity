package org.honorato.materialdesignudacity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ScrollView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ScrollAnimationActivity extends AppCompatActivity {

    @Bind(R.id.scroll_view_anim)
    ScrollView mScrollView;

    boolean mDidAnimateEnter = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_animation);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        setupAnimation();
    }

    protected void setupAnimation() {
        // For API level >= 21, we use
        // onEnterAnimationComplete
        if (Build.VERSION.SDK_INT >= 21) {
            return;
        }
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Do something after 100ms
            }
        }, 100);
    }

    protected void performAnimation() {
        if (mDidAnimateEnter) {
            return;
        }
        mDidAnimateEnter = true;
        final int startScrollPos = getResources()
                .getDimensionPixelSize(R.dimen.scroll_animation_start);

        Animator anim = ObjectAnimator.ofInt(
                mScrollView,
                "scrollY",
                startScrollPos)
                .setDuration(1000);

        anim.start();
    }

    @Override
    public void onEnterAnimationComplete() {
        super.onEnterAnimationComplete();
        performAnimation();
    }
}
