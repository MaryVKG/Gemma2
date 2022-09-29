package mary.klinger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIMER = 5000;
    //Se crean las variables
    ImageView backgroundImage;
    TextView poweredByLine;

    //Acá se crean las variables de animación
    Animation sideAnim, bottonAnim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN );
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);


        //Acá capturamos las variables
        backgroundImage = findViewById(R.id.backgound_image);
        poweredByLine = findViewById(R.id.powered_by_line);


        //Animaciones
        sideAnim = AnimationUtils.loadAnimation(this, R.anim.side_anim);
        bottonAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);


        //Acá se cambian las animaciones
        backgroundImage.setAnimation(sideAnim);
        poweredByLine.setAnimation(bottonAnim);

        new Handler().postDelayed(() -> {
             {
                Intent intent = new Intent(SplashScreen.this, OnBoarding.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIMER);

    }
}