package mary.klinger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class Login extends AppCompatActivity {

    ImageView loginBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        loginBack = findViewById(R.id.login_back_button);

        loginBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login.super.onBackPressed();
            }
        });

    }
}