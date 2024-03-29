package com.example.wayfar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawer_layout;

    NavigationView navigation_view;

    Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer_layout = findViewById(R.id.drawer_layout);
        navigation_view = findViewById(R.id.navigationView);
        toolbar = findViewById(R.id.toolbar);



        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE);

        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.add(R.id.container,new dashboardfragment(),"dashboardfragment");
        ft.commit();

        fm.popBackStack(null,FragmentManager.POP_BACK_STACK_INCLUSIVE);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.open_drawer, R.string.close_drawer);

        drawer_layout.addDrawerListener(toggle);

        toggle.syncState();
        navigation_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id==R.id.dashboard) {
                    toolbar.setTitle("Dashboard");
                    FragmentManager fm=getSupportFragmentManager();
                    FragmentTransaction ft=fm.beginTransaction();
                    ft.replace(R.id.container,new dashboardfragment(),"dashboardfragment");
                    ft.commit();
                    Toast.makeText(MainActivity.this, "Dashboard", Toast.LENGTH_SHORT).show();


                } else if (id==R.id.basukedar) {
                    toolbar.setTitle("Basukedar Temple");

                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.container, new BasukedarFragment());
                    ft.commit();

                    Toast.makeText(MainActivity.this, "Basukedar Temple", Toast.LENGTH_SHORT).show();

                } else if (id==R.id.someshwar) {
                    toolbar.setTitle("Someshwar Temple");

                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.container, new SomeshwarFragment());
                    ft.commit();

                    Toast.makeText(MainActivity.this, "Someshwar Temple", Toast.LENGTH_SHORT).show();

                } else if (id==R.id.mata_man) {
                    toolbar.setTitle("Mata Man Ichha Devi Temple");

                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.container, new MataManFragment());
                    ft.commit();

                    Toast.makeText(MainActivity.this, "Mata Man Ichha Devi Temple", Toast.LENGTH_SHORT).show();

                } else if (id==R.id.bansi_narayan) {
                    toolbar.setTitle("Bansi Narayan Temple");

                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.container, new BansiNarayanFragment());
                    ft.commit();

                    Toast.makeText(MainActivity.this, "Bansi Narayan Temple", Toast.LENGTH_SHORT).show();

                } else if (id==R.id.badrinath) {
                    toolbar.setTitle("Badrinath Temple");

                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.container, new BadrinathFragment());
                    ft.commit();



                    Toast.makeText(MainActivity.this, "Badrinath Temple", Toast.LENGTH_SHORT).show();

                } else if (id==R.id.kedarnath) {
                    toolbar.setTitle("Kedarnath Temple");

                    FragmentManager fm=getSupportFragmentManager();
                    FragmentTransaction ft=fm.beginTransaction();
                    ft.replace(R.id.container,new kedarnathfragment());
                    ft.commit();

                    Toast.makeText(MainActivity.this, "Kedarnath Temple", Toast.LENGTH_SHORT).show();

                } else if(id==R.id.flower_valley){
                    toolbar.setTitle("Valley of Flowers");

                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.container, new ValleyOfFlowerFragment());
                    ft.commit();

                    Toast.makeText(MainActivity.this, "Flower Valley", Toast.LENGTH_SHORT).show();

                }

                drawer_layout.closeDrawer(GravityCompat.START);

                return true;
            }


        });


    }



    @Override
    public void onBackPressed() {

        toolbar = findViewById(R.id.toolbar);
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START);
        }

        else
        {
            dashboardfragment myFragment = (dashboardfragment) getSupportFragmentManager().findFragmentByTag("dashboardfragment");
            if(myFragment != null && myFragment.isVisible())
             super.onBackPressed();

            else {
                toolbar.setTitle("Dashboard");
                FragmentManager fm=getSupportFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.container,new dashboardfragment(),"dashboardfragment");
                ft.commit();
            }
        }
    }



}