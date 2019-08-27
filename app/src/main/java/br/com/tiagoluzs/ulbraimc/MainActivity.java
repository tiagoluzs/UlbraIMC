package br.com.tiagoluzs.ulbraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText txtAltura;
    EditText txtPeso;
    Button btnCalcular;

    private float toFloat(String valor) {
        try {
            return Float.valueOf(valor);
        } catch(Exception e) {
            return 0;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtAltura = findViewById(R.id.txtAltura);
        txtPeso = findViewById(R.id.txtPeso);
        btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent = new Intent(getBaseContext(),ResultActivity.class);
            IMC imc = new IMC(toFloat(txtAltura.getText().toString()),toFloat(txtPeso.getText().toString()));
            intent.putExtra("imc",imc);
            startActivity(intent);
            }
        });
    }
}
