package com.example.taskapp31.ui.onboard;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.taskapp31.R;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import org.jetbrains.annotations.NotNull;

public class BoardFragment extends Fragment implements Finish{

    private Button btnSkip;
    DotsIndicator dotsIndicator;
    ViewPager2 viewPager2;
    BoardAdapter boardAdapter;



    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_board, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dotsIndicator = getView().findViewById(R.id.dots_indicator);
        viewPager2 =  getView().findViewById(R.id.view_pager);
        boardAdapter = new BoardAdapter();
        viewPager2.setAdapter(boardAdapter);
        dotsIndicator.setViewPager2(viewPager2);

        btnSkip = view.findViewById(R.id.btn_skip);
        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigate(R.id.navigation_home);
            }
        });

        boardAdapter.setOpenHome(this);


        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                requireActivity().finish();
            }
        });
    }


    private void navigate(int navigate) {
        NavController navController = Navigation.findNavController(
                requireActivity(),
                R.id.nav_host_fragment);
        navController.navigate(navigate);
    }

    @Override
    public void btnFinishClick() {
        navigate(R.id.navigation_home);
    }
}