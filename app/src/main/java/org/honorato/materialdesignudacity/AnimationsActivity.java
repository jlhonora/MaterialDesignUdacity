package org.honorato.materialdesignudacity;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

public class AnimationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animations);

        setupButtons();
    }

    public void setupButtons() {
        setupTransitionManager();
    }

    public void setupTransitionManager() {
        AppCompatButton b = (AppCompatButton) findViewById(R.id.button_transition_manager);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performTransitionManager();
            }
        });
    }

    public void performTransitionManager() {
        View image = this.findViewById(R.id.image_transition);

        int finalState = image.getVisibility() == View.VISIBLE ? View.INVISIBLE : View.VISIBLE;

        if (Build.VERSION.SDK_INT < 21) {
            image.setVisibility(finalState);
        } else {
            Slide slide = new Slide();
            slide.setSlideEdge(Gravity.TOP);

            final ViewGroup viewGroup = (ViewGroup) ((ViewGroup) this
                    .findViewById(android.R.id.content)).getChildAt(0);
            TransitionManager.beginDelayedTransition(viewGroup, slide);

            image.setVisibility(finalState);
        }
    }
}
