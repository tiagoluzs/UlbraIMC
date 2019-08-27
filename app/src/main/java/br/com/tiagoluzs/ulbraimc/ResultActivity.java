package br.com.tiagoluzs.ulbraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView textView;
    TextView textView4;
    TextView textView5;

    public float calcula(float altura, float peso) {
        if(altura != 0) {
            return peso / (altura * altura);
        } else {
            return -1;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textView4 = findViewById(R.id.textView4);
        textView = findViewById(R.id.textView);
        textView5 = findViewById(R.id.textView5);

        IMC imc = (IMC)this.getIntent().getParcelableExtra("imc");

        Log.d("ResultActivity","Altura: "+imc.altura);
        Log.d("ResultActivity","Peso: "+imc.peso);

        float valor = calcula(imc.altura,imc.peso);

        String classificacao = "";

        if(valor < 18.5) {
            classificacao = getResources().getString(R.string.class1);
        } else if(valor <= 24.9) {
            classificacao = getResources().getString(R.string.class2);
        } else if(valor <= 29.9) {
            classificacao = getResources().getString(R.string.class3);
        } else if(valor <= 39.9) {
            classificacao = getResources().getString(R.string.class4);
        } else {
            classificacao = getResources().getString(R.string.class5);
        }

        if(valor == -1) {
            // informações inválidas
            textView4.setVisibility(View.INVISIBLE);
            textView5.setVisibility(View.INVISIBLE);
            textView.setText(getResources().getString(R.string.valores_invalidos));
        } else {
            textView4.setVisibility(View.VISIBLE);
            textView5.setVisibility(View.VISIBLE);
            textView.setText(String.valueOf(valor));
            textView5.setText(classificacao);
            if(valor > 24.9) {
                textView5.setTextColor(Color.RED);
            } else {
                textView5.setTextColor(Color.GREEN);
            }

        }



    }
}
