package com.example.fitness_prototyp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class app_dashboardFragment extends Fragment {

    private onFragmentBtnSelected listener;
    private User user;

    public app_dashboardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_app_dashboard, container, false);

        Button commentButton = view.findViewById(R.id.app_dashboard_comments);
        commentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onCommentsSelected();
            }
        });

        TextView welcomeMessage = view.findViewById(R.id.app_dashboard_welcome);

        user = ApplicationActivity.getAppUser();
        welcomeMessage.setText("Hallo " + user.getName());
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof onFragmentBtnSelected) {
            listener = (onFragmentBtnSelected) context;
        } else {
            throw new ClassCastException(context.toString() + " must implement listener");
        }

    }

    public interface onFragmentBtnSelected {
        public void onCommentsSelected();
    }
}