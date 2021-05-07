package com.example.primerparcial;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UsuarioView {

    private Activity activity;
    private  Usuario usuario;
    EditText edNombre;
    UsuarioController usuarioController;

    public UsuarioView(Activity activity , Usuario usuario , UsuarioController usuarioController){
        this.activity = activity;
        this.usuario = usuario;
        this.edNombre = this.activity.findViewById(R.id.plain_text_input_usuario);
        Button btnGuardar = this.activity.findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(usuarioController);
    }

    public void mostrarModelo(){
        edNombre.setText(edNombre.getText().toString());
    }

    public void guardarModelo() {

        usuario.setNombre(edNombre.getText().toString());
    }

    public void mostrarMensaje(String mensaje) {

        Toast.makeText(this.activity, mensaje, Toast.LENGTH_SHORT).show();
    }

}
