package mary.klinger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.accessibility.AccessibilityViewCommand;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Contactanos extends AppCompatActivity {
    ImageView backBtn2, icon_wpp, icon_face,icon_insta,icon_twit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactanos);

        //Acá se capturan las variables
        backBtn2 = findViewById(R.id.back);


        //Acá se llamaran los iconos de las redes sociales para linkearlas.
        icon_wpp = findViewById(R.id.iconWpp);
        icon_face = findViewById(R.id.iconFace);
        icon_insta = findViewById(R.id.iconInsta);
        icon_twit = findViewById(R.id.iconTwit);

        backBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Contactanos.super.onBackPressed();
            }
        });

        icon_wpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Aca lo inicializamos
                String number = "+56923823323";
                Uri uri = Uri.parse(String.format(
                        "http://wa.me/56923823323",number
                ));
                //
                //Aquí llamamos al intent
                Intent intent = new Intent(Intent.ACTION_VIEW);

                intent.setData(uri);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }

        });

        icon_face.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sAppLink = "https://www.facebook.com/profile.php?id=100063692191473";
                String sPackage = "https://www.facebook.com/zuck";
                String sWebLink = "https://m.facebook.com/search/top/?q=Empanadas+gemma";
                openLink(sAppLink, sPackage, sWebLink);
            }
        });

        icon_insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sAppLink = "https://www.instagram.com/empanadasgemma2/";
                String sPackage = "https://instagram.com/empanadasgemma2?igshid=YmMyMTA2M2Y=";
            }
        });


    }

    private void openLink(String sAppLink, String sPackage, String sWebLink ) {
        try{
            Uri uri = Uri.parse(sAppLink);

            Intent intent = new Intent(Intent.ACTION_VIEW);

            intent.setData(uri);
            intent.setPackage(sPackage);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }catch (ActivityNotFoundException activityNotFoundException){
           Uri uri = Uri.parse(sWebLink);
           Intent intent = new Intent(Intent.ACTION_VIEW);
           intent.setData(uri);

           intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
}