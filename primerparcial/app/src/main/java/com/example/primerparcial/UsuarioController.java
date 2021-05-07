package com.example.primerparcial;

import android.app.Activity;
import android.util.Log;
import android.view.View;

public class UsuarioController implements View.OnClickListener {

    Activity activity;
    UsuarioView usuarioView;
    Usuario usuario;

    public UsuarioController(Usuario usuario ){
        this.usuario = usuario;
    }

    public boolean validarCarga() {

        return false;
    }

    public void setView(UsuarioView usuarioView){
        this.usuarioView = usuarioView;
    }

    @Override
    public void onClick(View view) {
        this.usuarioView.guardarModelo();

        if (this.validarCarga()){
            Log.d("Ok" ,  usuario.toString());
        }else {
            Log.d("Error" , usuario.toString());
            this.usuarioView.mostrarMensaje("los datos son incorrectos");
        }

    }

}
