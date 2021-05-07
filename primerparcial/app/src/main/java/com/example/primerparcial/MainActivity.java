package com.example.primerparcial;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyOnItemClick  {

    UsuarioAdapter usuarioAdapter;
    List<Usuario> usuarios = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuarios.add(new Usuario("Pepe", "pass1234" , "Usuario"));
        usuarios.add(new Usuario("Carlos", "pass1235" , "Administrador"));
        usuarios.add(new Usuario("Maria", "pass1236" , "Usuario"));
        usuarios.add(new Usuario("Susana", "pass1237" , "Administrador"));
        usuarios.add(new Usuario("Claudia", "pass1238" , "Usuario"));
        usuarios.add(new Usuario("Raul", "pass1239" , "Usuario"));
        usuarios.add(new Usuario("Manuel", "pass12341" , "Administrador"));
        usuarios.add(new Usuario("Carla", "pass123123" , "Administrador"));
        usuarios.add(new Usuario("Silvia", "pass123423" , "Usuario"));
        usuarios.add(new Usuario("Camilo", "pass123124" , "Administrador"));

        usuarioAdapter = new UsuarioAdapter(usuarios , this);
        RecyclerView recyclerView = super.findViewById(R.id.rvUsuarios);

        recyclerView.setAdapter(usuarioAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onItemClick(int position) {

        Usuario usuario = usuarios.get(position);

        Intent i = new Intent(this,EditarActivity.class);

        i.putExtra("position",position);
        i.putExtra("nombreUsuario",usuario.getNombre());
        i.putExtra("contraseña",usuario.getContraseña());
        i.putExtra("tipoUsuario",usuario.getTipoUsuario());


        startActivityForResult(i,1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1 && data != null){

            Bundle bundle = data.getExtras();
            Usuario u = usuarios.get(bundle.getInt("position"));

            u.setNombre(bundle.getString("nombreUsuario"));
            u.setContraseña(bundle.getString("contraseña"));
            u.setTipoUsuario(bundle.getString("tipoUsuario"));

            usuarioAdapter.onActivityResult(requestCode,1);
        }

    }
}