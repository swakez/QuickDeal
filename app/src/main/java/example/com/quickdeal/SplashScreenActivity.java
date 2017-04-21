package example.com.quickdeal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

/**
 * Created by swati on 18/04/2017.
 */

public class SplashScreenActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

      //  final LinearLayout linearLayout = (LinearLayout)findViewById(R.id.linear_layout);
        final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linear_layout_splash_screen);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.animate);

    //    animation.setInterpolator(new LinearInterpolator());
    //    animation.setRepeatCount(Animation.INFINITE);
    //    animation.setDuration(700);

        linearLayout.startAnimation(animation);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) { }

            @Override
            public void onAnimationEnd(Animation animation) {
                finish();
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
            @Override
            public void onAnimationRepeat(Animation animation) { }
        });
    }
}
