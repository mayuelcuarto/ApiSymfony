package com.cristhian.apisymfony.Fragments;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.cristhian.apisymfony.API.APIServices.UserService;
import com.cristhian.apisymfony.API.APIUser;
import com.cristhian.apisymfony.Models.User;
import com.cristhian.apisymfony.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InfoFragment extends Fragment implements View.OnClickListener {

    private FloatingActionButton fab;
    private EditText editTextEmail;
    private EditText editTextPassword;


    public InfoFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info, container, false);

        fab = (FloatingActionButton) view.findViewById(R.id.fab);
        editTextEmail = (EditText) view.findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) view.findViewById(R.id.editTextPassword);
        fab.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();
        boolean getHash = true;

        UserService service = APIUser.getApi().create(UserService.class);

        Call<User> userCall = service.pruebas(
        "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjQsImVtYWlsIjoiYWRtaW4xQGFkbWluLmNvbSIsIm5hbWUiOiJBZG1pbiAxIiwic3VybmFtZSI6IkFkbWluIDEiLCJpYXQiOjE1MTcwODg0NzcsImV4cCI6MTUxNzY5MzI3N30.pFXRKXHSH4EUMBUQAJJ5cXK7I1JGHbMAP4tdJdJlk4E",
                4);

        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User usuario = response.body();
                if(response.isSuccessful()){
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Usuario");
                builder.setMessage(
                        "ID: " + usuario.getId() + "\n" +
                        "Name: " + usuario.getName() + "\n" +
                        "Surname: " + usuario.getSurname() + "\n" +
                        "Email: " + usuario.getEmail() + "\n" +
                        "Password: " + usuario.getPassword()
                );
                builder.setNeutralButton("Got it", null);
                AlertDialog dialog = builder.create();
                dialog.show();}
                else{
                    Toast.makeText(getContext(),"Error: " + response.message(), Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getContext(),"Error Failure", Toast.LENGTH_SHORT).show();
            }
        });


    }
}





