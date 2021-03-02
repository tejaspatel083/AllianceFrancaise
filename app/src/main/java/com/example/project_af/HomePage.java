package com.example.project_af;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class HomePage extends AppCompatActivity {

    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView navi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        navi = findViewById(R.id.nv);
        dl = findViewById(R.id.drawer_layout);
        t = new ActionBarDrawerToggle(this,dl,R.string.nav_drawer_open,R.string.nav_drawer_close);

        dl.addDrawerListener(t);
        t.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (savedInstanceState == null)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new PurposeFragment()).commit();
        }

        navi.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = null;

                switch (item.getItemId())
                {

                    case R.id.Home :

                        fragment = new LevelsFragment();
                        break;

                    case R.id.Profile :

                        fragment = new ProfileFragment();
                        break;

                    case R.id.Beginner :

                        fragment = new BeginnerFragment();
                        break;

                    case R.id.Moderate :

                        fragment = new ModerateFragment();
                        break;

                    case R.id.Difficult :

                        fragment = new DifficultFragment();
                        break;



                    default:
                        fragment = new PurposeFragment();
                        break;


                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,fragment).commit();



                dl.closeDrawer(GravityCompat.START);
                return false;
            }
        });


    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (t.onOptionsItemSelected(item))
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
