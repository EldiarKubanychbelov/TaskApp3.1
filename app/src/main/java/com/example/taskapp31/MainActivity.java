package com.example.taskapp31;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.taskapp31.ui.onboard.BoardAdapter;
import com.example.taskapp31.ui.onboard.BoardFragment;
import com.example.taskapp31.ui.onboard.OnBoarding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private NavController navController;

  //  private BoardAdapter boardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);


        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard,R.id.navigation_profile, R.id.navigation_notifications)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
        navController.navigate(R.id.boardFragment);
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(R.id.navigation_home);
                list.add(R.id.navigation_dashboard);
                list.add(R.id.navigation_notifications);
                list.add(R.id.navigation_profile);

                if (list.contains(destination.getId())){
                    navView.setVisibility(View.VISIBLE);
                } else {
                    navView.setVisibility(View.GONE);
                }

                if (destination.getId() == R.id.boardFragment){
                    getSupportActionBar().hide();
                } else {
                    getSupportActionBar().show();
                }
            }
        });
    }

//    private void setupOnBoardingItems(){
//        List<OnBoarding> onBoardingList = new ArrayList<>();
//
//        OnBoarding itemPayOnline = new OnBoarding();
//        itemPayOnline.setTxtName("Gamburger");
//        itemPayOnline.setImgLogo(R.drawable.gamburger);
//
//        OnBoarding itemTheMay = new OnBoarding();
//        itemPayOnline.setTxtName("Gamburger");
//        itemPayOnline.setImgLogo(R.drawable.shaurma);
//
//        OnBoarding itemTogether = new OnBoarding();
//        itemPayOnline.setTxtName("Gamburger");
//        itemPayOnline.setImgLogo(R.drawable.pitsa);
//
//        boardAdapter = new BoardAdapter(onBoardingList);
//
//
//    }
//
//    private  void  setupOnBoard(){
//        ImageView[] imageViews = new ImageView[boardAdapter.getItemCount()];
//        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
//                ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT
//        );
//        layoutParams.setMargins(8,0,8,0);
//        for (int i = 0; i < imageViews.length; i++ ){
//            imageViews[i] = new ImageView(getApplicationContext());
//            imageViews[i].setImageDrawable(ContextCompat.getDrawable(getя));
//        }
//    }

    @Override
    public boolean onSupportNavigateUp() {
        return navController.navigateUp();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}