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
import android.widget.EditText;
import android.widget.Toast;

import org.parceler.Parcels;


/**
 * A simple {@link Fragment} subclass.
 */
public class logIn_loginFragment extends Fragment implements View.OnClickListener {

    private NavController navController;
    private String userEmail;
    private String userPassword;
    private EditText userEmailEdit;
    private EditText userPasswordEdit;
    private User user;

    public logIn_loginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_log_in_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Assign attributes
        navController = Navigation.findNavController(view);
        userEmailEdit = getActivity().findViewById(R.id.logIn_eMail_eddit);
        userPasswordEdit = getActivity().findViewById(R.id.logIn_password_edit);
        getActivity().findViewById(R.id.logIn_login_button).setOnClickListener(this);
        getActivity().findViewById(R.id.logIn_cancel_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.logIn_login_button:
                loginPressed();
                break;
            case R.id.logIn_cancel_button:
                getActivity().onBackPressed();
                break;
        }
    }

    private void loginPressed() {

        if (userEmailEdit.getText().toString().isEmpty()
                || userPasswordEdit.getText().toString().isEmpty()) {
            Toast.makeText(getActivity(),"Eingabe fehlt", Toast.LENGTH_SHORT).show();
            return;
        } else if (getUserByInput() == null){
            Toast.makeText(getActivity(), "Nutzer ist nicht registriert", Toast.LENGTH_SHORT).show();
            return;
        } else {
            Intent intent = new Intent(getActivity(), ApplicationActivity.class);
            user = getUserByInput();

            Parcelable parcelable = Parcels.wrap(user);
            intent.putExtra("USER_KEY", parcelable);
            startActivity(intent);
            return;
        }
    }

    private User getUserByInput() {
        //TODO: Input vom user validieren und in der Datenbank überprüfen lassen.
        // Wenn er existiert object erstellen oder referenz bilden und nutzer object zurück geben.
        // Ansonsten null zurückgeben.
        userEmail = userEmailEdit.getText().toString();
        userPassword = userPasswordEdit.getText().toString();

        //TESTING
        String teamCode = "CHF676";
        String name = "Karl-Heinz";
        String eMail = "karl.heinz@gmx.de";
        String password = "password";

        if (userPassword.equals(password)){
            return (new User(name, eMail, password, teamCode));
        } else {
            return null;
        }
    }
}
