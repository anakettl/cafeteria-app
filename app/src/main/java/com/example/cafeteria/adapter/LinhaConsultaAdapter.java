package com.example.cafeteria.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.cafeteria.PedidoActivity;
import com.example.cafeteria.R;
import com.example.cafeteria.dao.PedidoRepository;
import com.example.cafeteria.model.Pedido;

import java.util.ArrayList;
import java.util.List;

public class LinhaConsultaAdapter extends BaseAdapter {

    //Cria objeto LayoutInflater para ligar com a View activity_linha.xml
    private static LayoutInflater layoutInflater = null;

    List<Pedido> pedidos =  new ArrayList<>();
    PedidoRepository pedidoRepository;

    //Cria objeto do tipo que lista as tarefas
    private PedidoActivity listarPedidos;

    //Construtor que recebe a atividade como parametro e a lista de tarefas que vai retornar do BD
    public LinhaConsultaAdapter(PedidoActivity listarPedidos, List<Pedido> pedidos ) {

        this.pedidos       =  pedidos;
        this.listarPedidos  =  listarPedidos;
        this.layoutInflater     = (LayoutInflater) this.listarPedidos.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        pedidoRepository   = new PedidoRepository(listarPedidos);
    }

    //Retorna a quantidade de objetos que esta na lista
    @Override
    public int getCount(){
        return pedidos.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    //Método converte os valores de um item  da lista de Tarefas para uma linha do ListView
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        //Cria um objeto para acessar o layout activity_linha.xml
        final View viewLinhaLista = layoutInflater.inflate(R.layout.activity_linha,null);

        //vincula os campos do arquivo de layout aos objetos cadastrados
        TextView textViewCodigo = viewLinhaLista.findViewById(R.id.textViewId);
        TextView textViewCafe  =  viewLinhaLista.findViewById(R.id.textViewCafe);
        TextView textViewSalgado = viewLinhaLista.findViewById(R.id.textViewSalgado);
        TextView textViewDoce = viewLinhaLista.findViewById(R.id.textViewDoce);
        TextView textViewEndereco = viewLinhaLista.findViewById(R.id.textViewEndereco);
        TextView textViewTalher = viewLinhaLista.findViewById(R.id.textViewTalher);
        TextView textViewData = viewLinhaLista.findViewById(R.id.textViewData);

        textViewCodigo.setText(String.valueOf(pedidos.get(position).get_id()));
        textViewCafe.setText(pedidos.get(position).getCafe());
        textViewSalgado.setText(pedidos.get(position).getSalgado());
        textViewDoce.setText(pedidos.get(position).getDoce());
        textViewEndereco.setText(pedidos.get(position).getEndereco());
        textViewTalher.setText(pedidos.get(position).getTalher());
        textViewData.setText(pedidos.get(position).getData());

        //Criando evento para excluir um registro do BD
//        buttonExcluir.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String mensagem = "Registro excluído com sucesso!";
//                Integer retorno = tarefaRepository.delete(tarefas.get(position).get_id());
//                if(retorno == 0)
//                    mensagem = "Erro ao excluir registro!";
//                Toast.makeText(listarAtividades, mensagem, Toast.LENGTH_LONG).show();
//                atualizaLista();
//            }
//        });
        return viewLinhaLista;
    }

    //atualizando a lista após excluir registro
//    public void atualizaLista(){
//        this.tarefas.clear();
//        this.tarefas = tarefaRepository.getAll();
//        this.notifyDataSetChanged();
//    }
}
