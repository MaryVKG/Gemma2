package mary.klinger;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity implements  NavigationView.OnNavigationItemSelectedListener{

    static final float END_SCALE = 0.7f;

    RecyclerView featuredRecycler, mostViewedRecycler, categoriesRecycler;
    RecyclerView.Adapter adapter;
    private GradientDrawable gradient1, gradient2, gradient3, gradient4;
    ImageView menuIcon;
    LinearLayout contentView;




    //El menú irá aquí
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dashboard);

        //Hooks
        featuredRecycler = findViewById(R.id.featured_recycler);
        mostViewedRecycler = findViewById(R.id.most_viewed_recycler);
        categoriesRecycler = findViewById(R.id.categories_recycler);
        menuIcon = findViewById(R.id.menu_icon);
        contentView = findViewById(R.id.content);

        //Functions will be executed automatically when this activity will be created
        featuredRecycler();
        mostViewedRecycler();
        categoriesRecycler();

        //Acá se capturan los menus
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);

        
        navigationDrawer();

    }

    //Acá se ve la selección del menú
    private void navigationDrawer() {
        //Acá se captura la navegación
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);
        //Acá se llama al menu, con el menuIcon que capturamos arriba.
        menuIcon.setOnClickListener(view -> {
            if (drawerLayout.isDrawerVisible(GravityCompat.START))
                drawerLayout.closeDrawer(GravityCompat.START);
            else drawerLayout.openDrawer(GravityCompat.START);
        });

        animateNavigationDrawer();
        
    }

    private void animateNavigationDrawer() {

        drawerLayout.setScrimColor(getResources().getColor(R.color.colorSecondary));
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

                // Scale the View based on current slide offset
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                // Translate the View, accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }
        });

    }


    public void onBackPressed(){
        if(drawerLayout.isDrawerVisible(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else
            super.onBackPressed();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return true;
    }




    private void categoriesRecycler() {

        //All Gradients
        gradient2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffd4cbe5, 0xffd4cbe5});
        gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xff7adccf, 0xff7adccf});
        gradient3 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xfff7c59f, 0xFFf7c59f});
        gradient4 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffb8d7f5, 0xffb8d7f5});


        ArrayList<CategoriesHelperClass> categoriesHelperClasses = new ArrayList<>();

        categoriesHelperClasses.add(new CategoriesHelperClass(gradient1, R.drawable.card5, "Champiñón"));
        categoriesHelperClasses.add(new CategoriesHelperClass(gradient2,R.drawable.card6, "Pollo"));
        categoriesHelperClasses.add(new CategoriesHelperClass(gradient3,R.drawable.card7, "Choclo"));
        categoriesHelperClasses.add(new CategoriesHelperClass(gradient4,R.drawable.card7, "Choclo"));
        categoriesHelperClasses.add(new CategoriesHelperClass(gradient1,R.drawable.card7, "Choclo"));


        categoriesRecycler.setHasFixedSize(true);
        adapter = new CategoriesAdapter(categoriesHelperClasses);
        categoriesRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        categoriesRecycler.setAdapter(adapter);



    }

    private void mostViewedRecycler() {

        mostViewedRecycler.setHasFixedSize(true);
        mostViewedRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<MostViewedHelperClass> mostViewedLocations = new ArrayList<>();
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.mechada, "Mechada","holaaa descripcion"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.salmon, "Salmón","holaaa descripcion"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.seafood, "Marisco","holaaa descripcion"));
       // mostViewedLocations.add(new MostViewedHelperClass(R.drawable.mechada, "Mechada","holaaa descripcion"));

        adapter = new MostViewedAdpater(mostViewedLocations);
        mostViewedRecycler.setAdapter(adapter);



    }

    private void featuredRecycler() {

        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.cardone, "Camarón", "Camarón queso frita con queso sin lactosa."));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.card2, "Marisco", "Marisco frita con variedad de surtidos."));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.card4, "Queso", "Queso frita con queso sin lactosa."));


        featuredLocations.add(new FeaturedHelperClass(R.drawable.cardone, "Camarón", "Camarón queso frita con queso sin lactosa."));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.card2, "Marisco", "Marisco frita con variedad de surtidos."));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.card4, "Queso", "Queso frita con queso sin lactosa."));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.cardone, "Camarón", "Camarón queso frita con queso sin lactosa."));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.card2, "Marisco", "Marisco frita con variedad de surtidos."));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.card4, "Queso", "Queso frita con queso sin lactosa."));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.cardone, "Camarón", "Camarón queso frita con queso sin lactosa."));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.card2, "Marisco", "Marisco frita con variedad de surtidos."));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.card4, "Queso", "Queso frita con queso sin lactosa."));


        adapter = new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);

        GradientDrawable gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT,new int[]{0xffeff400,0xffaff600});



    }


}