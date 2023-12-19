package com.example.natureapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Recupera o nome e o e-mail do usuário
        SharedPreferences preferences = getSharedPreferences("profile", Context.MODE_PRIVATE);
        String name = preferences.getString("name", "");
        String email = preferences.getString("email", "");

        // Preenche os campos do formulário
        EditText editTextName = findViewById(R.id.edit_text_name);
        editTextName.setText(name);
        EditText editTextEmail = findViewById(R.id.edit_text_email);
        editTextEmail.setText(email);

        // Botão para salvar as alterações
        Button buttonSave = findViewById(R.id.button_save);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Salva o nome e o e-mail do usuário
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("name", editTextName.getText().toString());
                editor.putString("email", editTextEmail.getText().toString());
                editor.apply();

                // Volta para a Activity Principal
                finish();
            }
        });
    }
}

