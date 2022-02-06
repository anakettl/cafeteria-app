package com.example.cafeteria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickCardapio(View view){
        Intent intent = new Intent(this, CardapioActivity.class);
        startActivity(intent);
    }

    public void onClickPedidos(View view){
        Intent intent = new Intent(this, PedidoActivity.class);
        startActivity(intent);
    }

    public void onClickSobre(View view){
        Intent intent = new Intent(this, SobreActivity.class);
        startActivity(intent);
    }


}