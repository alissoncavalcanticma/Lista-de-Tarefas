package com.example.listadetarefas.model;

import java.io.Serializable;

public class Tarefa implements Serializable {

    private Long id;
    private String titulo;
    //private String descricao;


    public Tarefa(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public Tarefa(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
