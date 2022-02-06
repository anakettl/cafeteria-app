package com.example.cafeteria.model;

public class Pedido {
    private int _id;
    private String cafe;
    private String salgado;
    private String doce;
    private String endereco;
    private String talher;
    private String data;

    public Pedido() {
    }

    public Pedido(int _id, String cafe, String salgado, String doce, String endereco, String talher, String data) {
        this._id = _id;
        this.cafe = cafe;
        this.salgado = salgado;
        this.doce = doce;
        this.endereco = endereco;
        this.talher = talher;
        this.data = data;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getCafe() {
        return cafe;
    }

    public void setCafe(String cafe) {
        this.cafe = cafe;
    }

    public String getSalgado() {
        return salgado;
    }

    public void setSalgado(String salgado) {
        this.salgado = salgado;
    }

    public String getDoce() {
        return doce;
    }

    public void setDoce(String doce) {
        this.doce = doce;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTalher() {
        return talher;
    }

    public void setTalher(String talher) {
        this.talher = talher;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "_id=" + _id +
                ", cafe='" + cafe + '\'' +
                ", salgado='" + salgado + '\'' +
                ", doce='" + doce + '\'' +
                ", endereco='" + endereco + '\'' +
                ", talher='" + talher + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
