package com.example.listadetarefas.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.listadetarefas.R;
import com.example.listadetarefas.helper.TarefaDAO;
import com.example.listadetarefas.model.Tarefa;
import com.google.android.material.textfield.TextInputEditText;

public class AdicionarTarefaActivity extends AppCompatActivity {

    private TextInputEditText editTarefa;
    private Tarefa tarefaAtual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_tarefa);

        editTarefa = findViewById(R.id.textTarefa);

        //recuperar id de tarefaSelecionada via intent

        tarefaAtual = (Tarefa) getIntent().getSerializableExtra("tarefaSelecionada");

        //Configurar tarefaSelecionada na caixa de texto textTarefa

        if(tarefaAtual != null) {

            editTarefa.setText(tarefaAtual.getTitulo());
        }
    }



    //Metodo de criação de menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //Metodo de inflar (converter o xml em view) menu;
        getMenuInflater().inflate(R.menu.menu_adicionar_tarefa, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.itemSalvar:

                TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());

                if(tarefaAtual != null){//atualizar existente

                    String titulo = editTarefa.getText().toString();
                    if(!titulo.isEmpty()) {
                        Tarefa tarefa  = new Tarefa();
                        tarefa.setTitulo(titulo);
                        tarefa.setId(tarefaAtual.getId());

                        //atualizar

                        if(tarefaDAO.atualizar(tarefa)){

                            finish();
                            Toast.makeText(getApplicationContext(), "Editado com sucesso!", Toast.LENGTH_SHORT).show();

                        }else{

                            Toast.makeText(getApplicationContext(), "Erro ao editar", Toast.LENGTH_SHORT).show();
                        }

                    }


                }else{//salvar novo

                    String titulo = editTarefa.getText().toString();
                    if(!titulo.isEmpty()) {
                        Tarefa tarefa = new Tarefa();
                        tarefa.setTitulo(titulo);
                        if(tarefaDAO.salvar(tarefa)){
                            finish();
                            Toast.makeText(getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getApplicationContext(), "Erro ao salvar tarefa", Toast.LENGTH_SHORT).show();
                        }

                    }
                }

                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
