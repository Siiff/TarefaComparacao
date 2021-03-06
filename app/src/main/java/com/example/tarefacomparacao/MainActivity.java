package com.example.tarefacomparacao;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private EditText editPreco1, editPreco2;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPreco1 = findViewById(R.id.Preco1);
        editPreco2 = findViewById(R.id.Preco2);

        textResultado = findViewById(R.id.Resultado);

    }


    public void calcularMet(View view) {
        String picanhaboa,picanharuim;
        picanhaboa = editPreco1.getText().toString();
        picanharuim = editPreco2.getText().toString();

        Boolean camposvalidados = validarcampos(picanhaboa,picanharuim);
        if(camposvalidados){
            Double valorPicanhaboa = Double.parseDouble(picanhaboa);
            Double valorPicanharuim = Double.parseDouble(picanharuim);

            Double resultado = valorPicanhaboa / valorPicanharuim;
            if (resultado >= 0.7){
                textResultado.setText("Melhor a Picanha Ruim");
            }
            else {
                textResultado.setText("Melhor a Picanha Boa");
            }
        }
        else{
            textResultado.setText("Preencha os campos primeiro!");
        }
    }
    public Boolean validarcampos(String P1, String P2){
        Boolean camposvalidados = true;
        if(P1 == null || P1.equals("")){
            camposvalidados = false;
        }
        else if (P2 == null || P2.equals("")){
            camposvalidados = false;
        }
        return camposvalidados;
    }
}