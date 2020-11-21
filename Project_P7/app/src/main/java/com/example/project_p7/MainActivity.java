package com.example.project_p7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager2 viewPager2 = (ViewPager2) findViewById(R.id.viewPager2Main);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), getLifecycle());
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayoutMain);

        viewPagerAdapter.addFragment(new SintomasFragment());
        viewPagerAdapter.addFragment(new ComoActuarFragment());
        viewPagerAdapter.addFragment(new NoticiasCovidFragment());

        viewPager2.setAdapter(viewPagerAdapter);

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