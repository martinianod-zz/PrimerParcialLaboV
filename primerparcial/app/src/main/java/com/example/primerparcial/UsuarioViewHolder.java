package com.example.primerparcial;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UsuarioViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private MyOnItemClick listener;
    private int position;

    TextView tvName ;
    TextView tvPass;
    TextView tvTipo;

    public UsuarioViewHolder(@NonNull View itemView  , MyOnItemClick listener) {
        super(itemView);

        this.tvName = itemView.findViewById(R.id.tvName);
        this.tvPass = itemView.findViewById(R.id.tvPass);
        this.tvTipo = itemView.findViewById(R.id.tvTipo);

        itemView.setOnClickListener(this);
        this.listener = listener;

    }

    public void setPosition(int position){
        this.position = position;
    }


    @Override
    public void onClick(View view) {

        listener.onItemClick(position);

    }

}
