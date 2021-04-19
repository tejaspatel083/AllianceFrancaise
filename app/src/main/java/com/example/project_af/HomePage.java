package com.example.project_af;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class HomePage extends AppCompatActivity {

    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView navi;
    private FirebaseAuth firebaseAuth;
    private NavController navController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        navi = findViewById(R.id.nv);
        dl = findViewById(R.id.drawer_layout);
        t = new ActionBarDrawerToggle(this,dl,R.string.nav_drawer_open,R.string.nav_drawer_close);

        navController = Navigation.findNavController(HomePage.this,R.id.Host_Fragment2);

        firebaseAuth = FirebaseAuth.getInstance();

        dl.addDrawerListener(t);
        t.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (savedInstanceState == null)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.Host_Fragment2,new PurposeFragment()).commit();
        }

        navi.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                item.setCheckable(true);
                Fragment fragment = null;

                switch (item.getItemId())
                {

                    case R.id.Home :

                        navController.navigate(R.id.levelsFragment);
                        break;

                    case R.id.Profile :

                        navController.navigate(R.id.profileFragment);
                        break;

                    case R.id.Beginner :

                        navController.navigate(R.id.beginnerFragment);
                        break;

                    case R.id.Moderate :

                        navController.navigate(R.id.moderateFragment);
                        break;

                    case R.id.Difficult :

                        navController.navigate(R.id.difficultFragment);
                        break;

                    case R.id.Logout :

                        Toast toast = Toast.makeText(HomePage.this,"Logged out",Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
                        toast.show();
                        firebaseAuth.signOut();
                        fragment = new LoginFragment();
                        finish();
                        break;

                }

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

    /*
    @Override
    public void onBackPressed() {

        int fragmentCount = getSupportFragmentManager().getBackStackEntryCount();
        if (fragmentCount == 1) {
            finish();
        } else {
            if (fragmentCount > 1) {
                getFragmentManager().popBackStack();
            } else {
                super.onBackPressed();
            }

        }
    }

     */


}
