package com.example.forsolo;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FindMateActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;  //bottom navigation view
    private FragmentManager fm;
    private FragmentTransaction ft;
    private EditFragment editFragment;
    private ListFragment listFragment;
    private MapFragment mapFragment;
    private ProfileFragment profileFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findmate);

        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_list :
                        setFrag(0);
                        break;
                    case R.id.action_map :
                        setFrag(1);
                        break;
                    case R.id.action_edit :
                        setFrag(2);
                        break;
                    case R.id.action_profile :
                        setFrag(3);
                        break;
                }

                return true;
            }
        });
        editFragment = new EditFragment();
        listFragment = new ListFragment();
        mapFragment = new MapFragment();
        profileFragment = new ProfileFragment();
        setFrag(0);     //첫 fragment 화면을 무엇으로 지정할 지 설정함
    }


    //fragment 교체가 일어나는 실행문
    private void setFrag(int n){
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();     //실제적인 fragment 교체
        switch (n){
            case 0:
                ft.replace(R.id.frame_content, listFragment);
                ft.commit();        //저장을 의미합니다.
                break;
            case 1:
                ft.replace(R.id.frame_content, mapFragment);
                ft.commit();
                break;
            case 2:
                ft.replace(R.id.frame_content, editFragment);
                ft.commit();
                break;
            case 3:
                ft.replace(R.id.frame_content, profileFragment);
                ft.commit();
                break;
        }
    }
}
