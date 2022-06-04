package com.example.projetofiinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.projetofiinal.transactions.Constants;
import com.example.projetofiinal.transactions.Imoveis;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TelaInicial extends AppCompatActivity {
    int selected;
    ArrayList<Imoveis> listItem;
    ArrayAdapter adapter;
    ListView listaDeImoveis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

        selected = -1;

        listItem = new ArrayList<Imoveis>();

    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_tela_inicial, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onCreateOptionsMenuSelected(MenuItem item){
        Toast.makeText(TelaInicial.this, "" + item.getItemId(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()){
            case R.id.profile:
                break;
            case R.id.properties:
                addImovel();
                break;
            case R.id.favorite:
                break;
            case R.id.notification:
                break;
            case R.id.settings:
                break;
            case R.id.about:
                break;
        }
        return true;
    }

    public void addImovel(){
        Intent intent = new Intent(this, AddImoveis.class);
        startActivityForResult(intent, Constants.REQUEST_ADD_IMOVEL);
    }

}