package com.example.listadetarefas.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listadetarefas.R;
import com.example.listadetarefas.model.Tarefa;

import java.util.List;

public class TarefaAdapter extends RecyclerView.Adapter<TarefaAdapter.MyViewHolder>{

    private List<Tarefa> listaTarefas;

    public TarefaAdapter(List<Tarefa> listaTarefas) {
        this.listaTarefas = listaTarefas;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_tarefa_adapter, parent, false);

        return new MyViewHolder(itemLista);
    }

    //Captura e Vincula cada bloco pela posição, para controle de exibição.
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Tarefa tarefa = listaTarefas.get(position);

        holder.titulo.setText(tarefa.getTitulo());
        holder.descricao.setText(tarefa.getDescricao());
    }


    //Verifica e conta a qtd de Blocos(holders)/ itens por exibição
    @Override
    public int getItemCount() {
        return listaTarefas.size();
    }

    //Técnica usada para configurar de definir os blocos no Linear Layout para exibição dos itens da lista
    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView titulo;
        TextView descricao;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            titulo      = itemView.findViewById(R.id.titulo);
            descricao   = itemView.findViewById(R.id.descricao);
        }
    }
}
