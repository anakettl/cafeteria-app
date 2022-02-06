package com.example.cafeteria.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.cafeteria.model.Pedido;
import com.example.cafeteria.util.BDUtil;

import java.util.ArrayList;
import java.util.List;

public class PedidoRepository {
    private BDUtil bdUtil;

    public PedidoRepository(Context context){
        bdUtil =  new BDUtil(context);
    }

    public String insert(String cafe, String salgado, String doce, String endereco, String talher, String data){
        ContentValues valores = new ContentValues();
        valores.put("CAFE", cafe);
        valores.put("SALGADO", salgado);
        valores.put("DOCE", doce);
        valores.put("ENDERECO", endereco);
        valores.put("TALHER", talher);
        valores.put("DATA", data);
        long resultado = bdUtil.getConexao().insert("PEDIDO", null, valores);
        if (resultado ==-1) {
            bdUtil.close();
            return "Erro ao inserir registro";
        }
        return "Registro inserido com sucesso";
    }

    @SuppressLint("Range")
    public List<Pedido> getAll(){
        List<Pedido> pedidos = new ArrayList<>();
        // monta a consulta
        StringBuilder stringBuilderQuery = new StringBuilder();
        stringBuilderQuery.append("SELECT _ID, CAFE, SALGADO, DOCE, TALHER, ENDERECO, DATA ");
        stringBuilderQuery.append("FROM  PEDIDO ");
        stringBuilderQuery.append("ORDER BY DATA");
        //consulta os registros que estão no BD
        Cursor cursor = bdUtil.getConexao().rawQuery(stringBuilderQuery.toString(), null);
        //aponta cursos para o primeiro registro
        cursor.moveToFirst();
        Pedido pedido = null;
        //Percorre os registros até atingir o fim da lista de registros
        while (!cursor.isAfterLast()){
            // Cria objetos do tipo tarefa
            pedido =  new Pedido();
            //adiciona os dados no objeto
            pedido.set_id(cursor.getInt(cursor.getColumnIndex("_ID")));
            pedido.setCafe(cursor.getString(cursor.getColumnIndex("CAFE")));
            pedido.setSalgado(cursor.getString(cursor.getColumnIndex("SALGADO")));
            pedido.setDoce(cursor.getString(cursor.getColumnIndex("DOCE")));
            pedido.setTalher(cursor.getString(cursor.getColumnIndex("TALHER")));
            pedido.setEndereco(cursor.getString(cursor.getColumnIndex("ENDERECO")));
            pedido.setData(cursor.getString(cursor.getColumnIndex("DATA")));
            //adiciona o objeto na lista
            pedidos.add(pedido);
            //aponta para o próximo registro
            cursor.moveToNext();
        }
        bdUtil.close();
        //retorna a lista de objetos
        return pedidos;
    }
}
