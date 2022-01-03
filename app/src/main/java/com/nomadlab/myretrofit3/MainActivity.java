package com.nomadlab.myretrofit3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.nomadlab.myretrofit3.utils.FragmentType;

// Android Asset studio 검색
// http://romannurik.github.io/AndroidAssetStudio/

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        addBottomMenuListener();
        addFragment(FragmentType.HOME);
    }

    private void addFragment(FragmentType type) {
        Fragment fragment = null;
        switch (type) {
            case HOME:
                fragment = new HomeFragment();
                break;
            case TODO:
                fragment = new TodoFragment();
                break;
            case COMMENT:
                fragment = new CommentFragment();
                break;
            case USER:
                fragment = new UserFragment();
                break;
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction =  fragmentManager.beginTransaction();
        transaction.replace(R.id.mainContainer, fragment);
        transaction.commit();
    }

    private void initData() {
        bottomNavigationView = findViewById(R.id.bottom_navigation);

    }

    private void addBottomMenuListener() {
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.page_1:
                        addFragment(FragmentType.HOME);
                        break;
                    case R.id.page_2:
                        addFragment(FragmentType.TODO);
                        break;
                    case R.id.page_3:
                        addFragment(FragmentType.COMMENT);
                        break;
                    case R.id.page_4:
                        addFragment(FragmentType.USER);
                        break;
                }
                return true;
            }
        });

    }


}