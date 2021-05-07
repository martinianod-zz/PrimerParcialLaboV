package com.example.primerparcial;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioViewHolder>  {

        List<Usuario> usuarios;
         MyOnItemClick listener;

        public UsuarioAdapter(List<Usuario> usuarios , MyOnItemClick myOnItemClick){
        this.usuarios = usuarios;
            this.listener = myOnItemClick;
        }

    @NonNull
    @Override
    public UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item , parent , false);
        UsuarioViewHolder usuarioViewHolder = new UsuarioViewHolder(v , listener);
        return usuarioViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioViewHolder holder, int position) {

        Usuario usuario = this.usuarios.get(position);
        holder.tvName.setText(usuario.getNombre());
        holder.tvPass.setText(usuario.getContraseña());
        holder.tvTipo.setText(usuario.getTipoUsuario());

        holder.setPosition(position);
    }

    @Override
    public int getItemCount() {
        return this.usuarios.size();
    }

    public void onActivityResult(int requestCode, int i) {

        this.notifyDataSetChanged();
    }

}
