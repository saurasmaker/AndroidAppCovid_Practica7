package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    public ViewPager2 viewPager2;
    public ViewPagerAdapter viewPagerAdapter;
    public TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager2 = (ViewPager2) findViewById(R.id.viewPager2Main);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), getLifecycle());
        tabLayout = (TabLayout) findViewById(R.id.tabLayoutMain);

        viewPagerAdapter.addFragment(new SintomasFragment(this));
        viewPagerAdapter.addFragment(new ComoActuarFragment());
        viewPagerAdapter.addFragment(new NoticiasCovidFragment());

        new TabLayoutMediator(tabLayout, viewPager2,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        switch (position){
                            case 0:
                                tab.setText("Síntomas");
                                break;
                            case 1:
                                tab.setText("Cómo Actuar");
                                break;
                            case 2:
                                tab.setText("Noticias Covid 19");
                                break;
                        }
                    }
                }).attach();
    }
}