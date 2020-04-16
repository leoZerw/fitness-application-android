package com.example.fitness_prototyp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.parceler.Parcels;


public class logIn_registerFragment extends Fragment {

    private NavController navController;
    private EditText userNameEdit;
    private EditText userEmailEdit;
    private EditText userPasswordEdit;
    private EditText userTeamCodeEdit;
    private User user;

    public logIn_registerFragment() {
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
        return inflater.inflate(R.layout.fragment_log_in_register, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Assign attributes
        navController = Navigation.findNavController(view);
        userNameEdit = getActivity().findViewById(R.id.register_name_edit);
        userEmailEdit = getActivity().findViewById(R.id.register_eMail_edit);
        userPasswordEdit = getActivity().findViewById(R.id.register_password_edit);
        userTeamCodeEdit = getActivity().findViewById(R.id.register_teamcode_edit);

        final Button registerButton = getActivity().findViewById(R.id.register_button);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userNameEdit.getText().toString().isEmpty() || userEmailEdit.getText().toString().isEmpty()
                    || userPasswordEdit.getText().toString().isEmpty() || userTeamCodeEdit.getText().toString().isEmpty()) {

                    Toast.makeText(getActivity(),"Felder ausfüllen", Toast.LENGTH_SHORT).show();
                } else {
                    registerButtonPressed();
                }
            }
        });
    }

    private void registerButtonPressed() {
        //TODO: User eingabe validieren, falls email passt, User object erstellen und dieses mit einem
        // bundle zur hauptapplication schicken(mit key String "User").
        // Falls Eingabe ungültig Toast ausgeben und returnen.

        //TESTING
        String name = userNameEdit.getText().toString();
        String email = userEmailEdit.getText().toString();
        String password = userPasswordEdit.getText().toString();
        String teamCode = userTeamCodeEdit.getText().toString();

        user = new User(name, email, password, teamCode);

        Intent intent = new Intent(getActivity(), ApplicationActivity.class);

        Parcelable parcelable = Parcels.wrap(user);
        intent.putExtra("USER_KEY", parcelable);
        startActivity(intent);
    }
}
