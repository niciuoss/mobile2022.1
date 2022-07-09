package com.example.aluguejaapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aluguejaapp.transactions.Constants;
import com.example.aluguejaapp.transactions.Imoveis;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TelaInicial<childEventListener> extends AppCompatActivity {
    private FirebaseAuth mAuth;

    DatabaseReference databaseReference;
    ListView listView;
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_tela_inicial);
        databaseReference = FirebaseDatabase.getInstance().getReference("Imoveis");
        listView = (ListView) findViewById(R.id.listviewtxt);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String previousChildName) {
                String value = dataSnapshot.getValue(Imoveis.class).toString();
                arrayList.add(value);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_tela_inicial, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void onClickDetails (View view) {
        Intent intent = new Intent(this, DetailImoveis.class);
        startActivity(intent);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(TelaInicial.this, "" + item.getItemId(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case R.id.profile:
                perfilUsuario(mAuth.getCurrentUser());
                break;
            case R.id.properties:
                addImovel();
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
        mAuth.signOut();
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
        finish();
    }

    public void configuracoes() {
        Intent intent = new Intent(this, Configuracoes.class);
        startActivity(intent);
    }

    public void perfilUsuario(FirebaseUser currentUser) {
        Intent intent = new Intent(this, PerfilUser.class);
        intent.putExtra("email", currentUser.getEmail());
        Log.v("DATA", currentUser.getUid());
        startActivity(intent);
    }

}