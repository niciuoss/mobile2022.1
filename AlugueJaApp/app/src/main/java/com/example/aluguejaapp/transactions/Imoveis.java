package com.example.aluguejaapp.transactions;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Imoveis {
    //private  static  int contadorId = 0;
    private String id;
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String uf;
    private String mensalidade;
    private String quartos;
    private String banheiros;


    public Imoveis(String rua, String numero, String bairro, String cidade, String uf, String mensalidade, String quartos, String banheiros) {
        //this.id = contadorId++;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.mensalidade = mensalidade;
        this.quartos = quartos;
        this.banheiros = banheiros;
    }

    public Imoveis(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(String mensalidade) {
        this.mensalidade = mensalidade;
    }

    public String getQuartos() {
        return quartos;
    }

    public void setQuartos(String quartos) {
        this.quartos = quartos;
    }

    public String getBanheiros() {
        return banheiros;
    }

    public void setBanheiros(String banheiros) {
        this.banheiros = banheiros;
    }

    public void salvar(){
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        reference.child("Imoveis").child(getId()).setValue(this);
    }

    @Override
    public String toString() {
        return "Imovel " + "- " +
                "Rua: " + rua  +
                ", Numero: " + numero +
                ", Bairro: " + bairro +
                ", Cidade: " + cidade +
                ", UF: " + uf +
                ", Mensalidade: " + mensalidade +
                ", Quartos: " + quartos +
                ", Banheiros: " + banheiros;
    }
}
