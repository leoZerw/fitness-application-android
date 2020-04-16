package com.example.fitness_prototyp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.content.Intent;
import android.icu.lang.UCharacter;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Layout;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import org.parceler.Parcels;

public class ApplicationActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,
                                                                        app_dashboardFragment.onFragmentBtnSelected {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private Toolbar toolbar;
    private Layout drawerHeader;
    private NavigationView navigationView;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    public static User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();

        //load default fragment
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container_fragment, new app_dashboardFragment());
        fragmentTransaction.commit();

        //UserObject
        Parcelable parcelable = getIntent().getParcelableExtra("USER_KEY");
        user = Parcels.unwrap(parcelable);
        
        TextView drawerUserName = findViewById(R.id.drawer_user_name);
        TextView drawerUserEmail = findViewById(R.id.drawer_user_email);
        drawerUserName.setText("MOIN");
        drawerUserEmail.setText("MOIN");
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        drawerLayout.closeDrawer(GravityCompat.START);

        switch (menuItem.getItemId()) {
            case R.id.drawer_dashboard:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.container_fragment, new app_dashboardFragment());
                fragmentTransaction.commit();
                break;
            case R.id.drawer_newUnit:
                //TODO: Handle task for that click (intent or navController)

                break;
            case R.id.drawer_comments:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.container_fragment, new app_commentsFragment());
                fragmentTransaction.commit();
                break;
            case R.id.drawer_exercises:
                //TODO: Handle task for that click (intent or navController)

                break;
            case R.id.drawer_settings:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.container_fragment, new app_settingsFragment());
                fragmentTransaction.commit();
                break;
        }
        return true;
    }

    @Override
    public void onCommentsSelected() {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container_fragment, new app_commentsFragment());
        fragmentTransaction.commit();
    }

    public static User getAppUser() {
        if (user == null) {
            return null;
        } else {
            return user;
        }
    }
}
