package com.example.primerparcial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class EditarActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editNombreUsuario;
    EditText editPassword;
    RadioButton editTipoUsuario;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Editar usuario");
        actionBar.setDisplayHomeAsUpEnabled(true);

        Usuario model = new Usuario();
        UsuarioController controller = new UsuarioController(model);
        UsuarioView view = new UsuarioView(this, model , controller);
        controller.setView(view);


        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        extras.getInt("position");

        editNombreUsuario = findViewById(R.id.plain_text_input_usuario);
        editNombreUsuario.setText(extras.getString("nombreUsuario"));


        editPassword = findViewById(R.id.plain_text_input_contraseña);
        editPassword.setText(extras.getString("contraseña"));

        String tipoUser = extras.getString("tipoUsuario").toLowerCase();

        if(extras.getString("tipoUsuario").toLowerCase().equals("administrador")){
            editTipoUsuario = findViewById(R.id.radioAdministrador) ;
        }else{
            editTipoUsuario = findViewById(R.id.radioUsuario);
        }

        editTipoUsuario.setChecked(true);

        position = extras.getInt("position");


        extras.getString("tipoUsuario");

        MyListener listener = new MyListener();
        Button boton = (Button) findViewById(R.id.btnGuardar);

        boton.setOnClickListener(this);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == android.R.id.home){
            super.finish();
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View view) {

        editNombreUsuario = findViewById(R.id.plain_text_input_usuario);
        editPassword = findViewById(R.id.plain_text_input_contraseña);

        EditText editRepeatPassword = findViewById(R.id.plain_text_input_repetir_contraseña);


        if (editRepeatPassword.getText().toString().equals(editPassword.getText().toString()) && editNombreUsuario.getText().toString().length() > 2){


        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        radioGroup.getCheckedRadioButtonId();

        editTipoUsuario = findViewById(radioGroup.getCheckedRadioButtonId());

        Intent i = new Intent();

        i.putExtra("position", position);
        i.putExtra("nombreUsuario",editNombreUsuario.getText().toString());
        i.putExtra("contraseña", editPassword.getText().toString());
        i.putExtra("tipoUsuario",editTipoUsuario.getText().toString());


        setResult(RESULT_OK, i);
        super.finish();

        }else {
            Log.d("validacion de datos" , "no coinciden las contraseñas o nombre de usuario menos a 3 caracteres");
        }

    }


}