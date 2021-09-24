package gujarprajwal.com.example.spinthebottle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView bottle;
    private  int lastdirection;
    private boolean spinning;
    private Random random = new Random(  );


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public  void spinBottle(View v){

        if(!spinning){
            int newdirection = random.nextInt(1800 );
            float pivotX = bottle.getWidth() / 2;
            float pivotY = bottle.getHeight() / 2;


            Animation rotate = new RotateAnimation(lastdirection,newdirection,pivotX,pivotY);
            rotate.setDuration(2500);
            rotate.setFillAfter(true);
            rotate.setAnimationListener(new Animation.AnimationListener( ) {
                @Override
                public void onAnimationStart(Animation animation) {
                    spinning = true;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                     spinning =false;
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });


            lastdirection =  newdirection;
            bottle.startAnimation(rotate);
        }


}



    }
