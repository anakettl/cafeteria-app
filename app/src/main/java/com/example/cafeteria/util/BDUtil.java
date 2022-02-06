package com.example.cafeteria.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BDUtil extends SQLiteOpenHelper {

    private static final String BASE_DE_DADOS = "CAFETERIA";
    private static final int VERSAO = 1;

    public BDUtil(Context context){
        super(context,BASE_DE_DADOS,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuilder criarTabela = new StringBuilder();
        criarTabela.append(" CREATE TABLE PEDIDO (");
        criarTabela.append(" _ID   INTEGER PRIMARY KEY AUTOINCREMENT, ");
        criarTabela.append(" CAFE  TEXT    NOT NULL,");
        criarTabela.append(" SALGADO   TEXT    NOT NULL,");
        criarTabela.append(" DOCE   TEXT    NOT NULL,");
        criarTabela.append(" ENDERECO   TEXT    NOT NULL,");
        criarTabela.append(" TALHER   TEXT    NOT NULL,");
        criarTabela.append(" DATA TEXT  NOT NULL)");
        db.execSQL(criarTabela.toString());
    }

    /*Método abaixo é executado quando troca a versão do BD*/
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS PEDIDO");
        onCreate(db);
        System.out.println("---------------------------------------------Deletou o banco, onUpgrade");
    }

    /*Método usado para obter a conexão com o BD*/
    public SQLiteDatabase getConexao(){
        return this.getWritableDatabase();
    }


}
