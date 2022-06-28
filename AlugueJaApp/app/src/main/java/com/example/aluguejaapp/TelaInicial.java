package com.example.aluguejaapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.aluguejaapp.transactions.Constants;
import com.example.aluguejaapp.transactions.Imoveis;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class TelaInicial extends AppCompatActivity {
    int selected;
    //private FirebaseAuth mAuth;
    ArrayList<Imoveis> listItem;
    ArrayAdapter adapter;
    ListView listaDeImoveis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //mAuth = FirebaseAuth.getInstance();

        setContentView(R.layout.activity_tela_inicial);

        selected = -1;

        listItem = new ArrayList<Imoveis>();

        adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, listItem);
        listaDeImoveis = (ListView) findViewById(R.id.idListaImoveis);
        listaDeImoveis.setAdapter(adapter);
        listaDeImoveis.setSelector(android.R.color.holo_blue_dark);

        listaDeImoveis.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Toast.makeText(TelaInicial.this, "" + listItem.get(position).toString(),
                        Toast.LENGTH_SHORT).show();
                selected = position;
            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_tela_inicial, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(TelaInicial.this, "" + item.getItemId(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case R.id.profile:
                perfilUsuario();
                break;
            case R.id.properties:
                addImovel();
                break;
            case R.id.favorite:
                favoritaImovel();
                break;
            case R.id.notification:
                notificacao();
                break;
            case R.id.settings:
                configuracoes();
                break;
            case R.id.logout:
                sair();
                break;
        }
        return true;
    }

    public void addImovel() {
        Intent intent = new Intent(this, ListImoveis.class);
        startActivityForResult(intent, Constants.REQUEST_ADD_IMOVEL);
    }

    public void sair() {
        //mAuth.signOut();
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
        finish();
    }

    public void configuracoes() {
        Intent intent = new Intent(this, Configuracoes.class);
        startActivity(intent);
    }

    public void favoritaImovel() {
        Intent intent = new Intent(this, Favoritos.class);
        startActivity(intent);
    }

    public void notificacao() {

    }

    public void perfilUsuario() {
        Intent intent = new Intent(this, PerfilUser.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Constants.REQUEST_ADD_IMOVEL && resultCode == Constants.RESULT_ADD_IMOVEL) {
            String rua = (String) data.getExtras().get("rua");
            String numero = (String) data.getExtras().get("numero");
            String bairro = (String) data.getExtras().get("bairro");
            String cidade = (String) data.getExtras().get("cidade");
            String uf = (String) data.getExtras().get("uf");
            String mensalidade = (String) data.getExtras().get("mensalidade");
            String quartos = (String) data.getExtras().get("quartos");
            String banheiros = (String) data.getExtras().get("banheiros");
            String contato = (String) data.getExtras().get("contato");
            Imoveis imovel = new Imoveis(rua, numero, bairro, cidade, uf, mensalidade, quartos, banheiros, contato);
            listItem.add(imovel);
            adapter.notifyDataSetChanged();

        } else if (requestCode == Constants.REQUEST_EDT_IMOVEL && resultCode == Constants.RESULT_ADD_IMOVEL) {
            String rua = (String) data.getExtras().get("rua");
            String numero = (String) data.getExtras().get("numero");
            String bairro = (String) data.getExtras().get("bairro");
            String cidade = (String) data.getExtras().get("cidade");
            String uf = (String) data.getExtras().get("uf");
            String mensalidade = (String) data.getExtras().get("mensalidade");
            String quartos = (String) data.getExtras().get("quartos");
            String banheiros = (String) data.getExtras().get("banheiros");
            String contato = (String) data.getExtras().get("contato");
            int idEdit = (int) data.getExtras().get("id");

            for (Imoveis imovel : listItem) {
                if (imovel.getId() == idEdit) {
                    imovel.setRua(rua);
                    imovel.setNumero(numero);
                    imovel.setBairro(bairro);
                    imovel.setCidade(cidade);
                    imovel.setUf(uf);
                    imovel.setMensalidade(mensalidade);
                    imovel.setQuartos(quartos);
                    imovel.setBanheiros(banheiros);
                    imovel.setContato(contato);
                }
            }
            adapter.notifyDataSetChanged();

        }

    }
}