package com.example.projetofiinal.transactions;

public class Imoveis {
    private  static  int contadorId = 0;
    private int id;
    private String rua;
    private int numero;
    private String bairro;
    private String cidade;
    private String uf;

    public Imoveis(String rua, int numero, String bairro, String cidade, String uf) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
    }

    public Imoveis(){

    }

    public int getId() {
        return id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
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

    @Override
    public String toString() {
        return "Imovel:" +
                "Rua='" + rua + '\'' +
                ", Nº=" + numero +
                ", Bairro='" + bairro + '\'' +
                ", Cidade='" + cidade + '\'' +
                ", UF='" + uf + '\'';
    }
}
