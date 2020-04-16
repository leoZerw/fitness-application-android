package com.example.fitness_prototyp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class logIn_startFragment extends Fragment implements View.OnClickListener {

    private NavController navController;

    public logIn_startFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_log_in_start, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(getView());
        getActivity().findViewById(R.id.start_login_button).setOnClickListener(this);
        getActivity().findViewById(R.id.start_register_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_login_button:
                navController.navigate(R.id.action_logIn_startFragment_to_logIn_loginFragment);
                break;
            case R.id.start_register_button:
                navController.navigate(R.id.action_logIn_startFragment_to_logIn_registerFragment);
                break;
        }
    }
}
