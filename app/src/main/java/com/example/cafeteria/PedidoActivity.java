package com.example.cafeteria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cafeteria.adapter.LinhaConsultaAdapter;
import com.example.cafeteria.dao.PedidoRepository;
import com.example.cafeteria.model.Pedido;

import java.util.List;

public class PedidoActivity extends AppCompatActivity {
    private ListView listPedidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);

        listPedidos = this.findViewById(R.id.listViewPedidos);
        this.getAll();
    }

    protected  void getAll(){
        PedidoRepository pedidoRepository = new PedidoRepository(this);
        List<Pedido> pedidos = pedidoRepository.getAll();
        for (Pedido pedido:
             pedidos) {
            System.out.println(pedido.toString());
        }

        listPedidos.setAdapter(new LinhaConsultaAdapter(this, pedidos));
    }

    public void onClickVoltar(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
