package com.example.rv_v2_;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    ViewPagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();

        TabLayoutMediator tlm = new TabLayoutMediator(
                tabLayout,
                viewPager2,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        switch (position)
                        {
                            case 0:
                                tab.setText("Calls");
                                tab.setIcon(R.drawable.icon_call);
                                BadgeDrawable bd = tab.getOrCreateBadge();
                                bd.setNumber(102);
                                bd.setMaxCharacterCount(3);
                                break;
                            case 1:
                                tab.setText("Chats");
                                tab.setIcon(R.drawable.icon_chat);
                                BadgeDrawable bd1 = tab.getOrCreateBadge();
                                bd1.setNumber(19);
                                bd1.setMaxCharacterCount(2);
                                break;
                            case 2:
                                tab.setText("Status");
                                tab.setIcon(R.drawable.icon_status);
                                break;
                            default:
                                tab.setText("Calls");
                                tab.setIcon(R.drawable.icon_call);
                                break;

                        }
                    }
                });

        tlm.attach();


        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                BadgeDrawable bd = tabLayout.getTabAt(position).getOrCreateBadge();
                bd.setNumber(0);
                bd.setVisible(false);
            }
        });

    }

    private void init()
    {
        tabLayout = findViewById(R.id.tablayout);
        viewPager2 = findViewById(R.id.viewpager2);
        adapter = new ViewPagerAdapter(this);
        viewPager2.setAdapter(adapter);
    }
}