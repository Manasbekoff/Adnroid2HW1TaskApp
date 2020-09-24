package com.example.taskapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.taskapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeFragment extends Fragment {


    FloatingActionButton fab_main, fab_one, fabAddForm;
    TextView profileText, formTextView;
    Boolean menuOpen=false;
    NavController navController, navControllerTwo;
    Animation oneFabOpen, oneFabClose;


    OvershootInterpolator interpolator = new OvershootInterpolator();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fab_main=view.findViewById(R.id.main_fab);
        fab_one =view.findViewById(R.id.prof_fab);
        fabAddForm=view.findViewById(R.id.form_fab);

        profileText = view.findViewById(R.id.textViewProf);
        formTextView=view.findViewById(R.id.textViewForm);


       oneFabOpen=AnimationUtils.loadAnimation(getActivity(), R.anim.open_anim);
       oneFabClose=AnimationUtils.loadAnimation(getActivity(),R.anim.close_anim);

        initListeners();
    }

    private void initListeners() {
        fab_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (menuOpen){
                    fab_one.setAnimation(oneFabClose);
                    fabAddForm.setAnimation(oneFabClose);
                    formTextView.setVisibility(View.INVISIBLE);
                    profileText.setVisibility(View.INVISIBLE);
                    menuOpen =false;
                } else {
                    fab_one.setAnimation(oneFabOpen);
                    fabAddForm.setAnimation(oneFabOpen);
                    formTextView.setVisibility(View.VISIBLE);
                    profileText.setVisibility(View.VISIBLE);
                    menuOpen = true;
                }
            }
        });

        fab_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.action_navigation_home_to_profile);
            }
        });

        fabAddForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMenu();
            }
        });


    }

    private void openMenu() {
        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
        navController.navigate(R.id.action_navigation_home_to_form);
    }


    }
