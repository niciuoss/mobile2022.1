package com.example.aluguejaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.aluguejaapp.transactions.Constants;

public class ListImoveis extends AppCompatActivity {
    EditText edtRua;
    EditText edtNumero;
    EditText edtBairro;
    EditText edtCidade;
    EditText edtUf;
    EditText edtMensalidade;
    EditText edtQuartos;
    EditText edtBanheiros;
    boolean edit;
    int idEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_imoveis);

        edtRua =findViewById(R.id.editTextRua);
        edtNumero =findViewById(R.id.editTextNumero);
        edtBairro =findViewById(R.id.editTextBairro);
        edtCidade =findViewById(R.id.editTextCidade);
        edtUf =findViewById(R.id.editTextUf);
        edtMensalidade =findViewById(R.id.editTextMensalidade);
        edtQuartos =findViewById(R.id.editTextQuartos);
        edtBanheiros =findViewById(R.id.editTextBanheiros);

        edit = false;

        if(getIntent().getExtras() != null){
            String rua = (String)getIntent().getExtras().get("rua");
            String numero = (String)getIntent().getExtras().get("numero");
            String bairro = (String)getIntent().getExtras().get("bairro");
            String cidade = (String)getIntent().getExtras().get("cidade");
            String uf = (String)getIntent().getExtras().get("uf");
            String mensalidade = (String)getIntent().getExtras().get("mensalidade");
            String quartos = (String)getIntent().getExtras().get("quartos");
            String banheiros = (String)getIntent().getExtras().get("banheiros");
            idEditar = (int)getIntent().getExtras().get("id");

            edtRua.setText(rua);
            edtNumero.setText(numero);
            edtBairro.setText(bairro);
            edtCidade.setText(cidade);
            edtUf.setText(uf);
            edtMensalidade.setText(mensalidade);
            edtQuartos.setText(quartos);
            edtBanheiros.setText(banheiros);

            edit = true;
        }
    }

    public void cancelarBtn(View view){
        setResult(Constants.RES_CANCEL_IMOVEL);
        finish();
    }

    public void confirmarBtn(View view){
        Intent intent = new Intent();

        String rua = edtRua.getText().toString();
        String numero = edtNumero.getText().toString();
        String bairro = edtBairro.getText().toString();
        String cidade = edtCidade.getText().toString();
        String uf = edtUf.getText().toString();
        String mensalidade = edtMensalidade.getText().toString();
        String quartos = edtQuartos.getText().toString();
        String banheiros = edtBanheiros.getText().toString();

        intent.putExtra("rua", rua);
        intent.putExtra("numero",numero);
        intent.putExtra("bairro", bairro);
        intent.putExtra("cidade", cidade);
        intent.putExtra("uf", uf);
        intent.putExtra("mensalidade", mensalidade);
        intent.putExtra("quartos", quartos);
        intent.putExtra("banheiros", banheiros);

        if(edit){
            intent.putExtra("id", idEditar);
        }

        setResult(Constants.RES_ADD_IMOVEL, intent);
        finish();
    }
}