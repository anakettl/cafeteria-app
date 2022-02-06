package com.example.cafeteria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.example.cafeteria.dao.PedidoRepository;

public class CardapioActivity extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardapio);

        Button btnPedir = findViewById(R.id.btnPedir);

        Spinner spinner_cafes = findViewById(R.id.spinnerCafes);
        spinner_cafes.setOnItemSelectedListener(this);
        Spinner spinner_salgados = findViewById(R.id.spinnerSalgados);
        spinner_salgados.setOnItemSelectedListener(this);
        Spinner spinner_doces = findViewById(R.id.spinnerDoces);
        spinner_doces.setOnItemSelectedListener(this);

        btnPedir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PedidoRepository pedidoRepository = new PedidoRepository(getBaseContext());

                Date dataAtual = Calendar.getInstance().getTime();
                String data = new SimpleDateFormat("dd/MM/yyyy").format(dataAtual);
                EditText endereco =  findViewById(R.id.editTextEndereco);
                String talher = "";

                RadioGroup grupo = (RadioGroup) findViewById(R.id.grupoRbtn);
                int id = grupo.getCheckedRadioButtonId();
                switch(id){
                    case R.id.rbtnOp1:
                        talher = "Sim";
                        break;
                    case R.id.rbtnOp2:
                        talher = "Não";
                        break;
                }

                String resultado = pedidoRepository.insert(
                        spinner_cafes.getSelectedItem().toString(),
                        spinner_salgados.getSelectedItem().toString(),
                        spinner_doces.getSelectedItem().toString(),
                        endereco.getText().toString(),
                        talher,
                        data);

                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();

            }
        });
    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {}
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {}

    public void onClickVoltar(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}