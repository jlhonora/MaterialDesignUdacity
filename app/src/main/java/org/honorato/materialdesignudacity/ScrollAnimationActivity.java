package org.honorato.materialdesignudacity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ScrollView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ScrollAnimationActivity extends AppCompatActivity {

    @Bind(R.id.scroll_view_anim)
    ScrollView mScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_animation);
        ButterKnife.bind(this);
    }

    @Override
    public void onEnterAnimationComplete() {
        super.onEnterAnimationComplete();

        final int startScrollPos = getResources()
                .getDimensionPixelSize(R.dimen.scroll_animation_start);

        Animator anim = ObjectAnimator.ofInt(
                mScrollView,
                "scrollY",
                startScrollPos)
                .setDuration(1000);

        anim.start();
    }
}
