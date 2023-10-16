package com.example.trabalho;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    private EditText nomeEditText;
    private EditText valorEditText;
    private RadioGroup valores;
    private RadioButton dolarRadioButton;
    private RadioButton euroRadioButton;
    private RadioButton libraRadioButton;
    private TextView resultadoTextView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nomeEditText = findViewById(R.id.nomeEditText);
        valorEditText = findViewById(R.id.valorEditText);
        button = findViewById(R.id.button);
        valores = findViewById(R.id.valores);
        dolarRadioButton = findViewById(R.id.dolarRadioButton);
        euroRadioButton = findViewById(R.id.euroRadioButton);
        libraRadioButton = findViewById(R.id.libraRadioButton);
        resultadoTextView = findViewById(R.id.resultadoTextView);

        // pega nome e o valor
        button.setOnClickListener(v -> {
            String nome = nomeEditText.getText().toString();
            String valorStr = valorEditText.getText().toString();

            double valor = Double.parseDouble(valorStr);

            double resultado = 0.0;
            String moeda = "";

            int selectedRadioButtonId = valores.getCheckedRadioButtonId();

            if (selectedRadioButtonId == dolarRadioButton.getId()) {
                resultado = valor * 5.0642;
                moeda = "Dólar";
            } else if (selectedRadioButtonId == euroRadioButton.getId()) {
                resultado = valor * 5.3087;
                moeda = "Euro";
            } else if (selectedRadioButtonId == libraRadioButton.getId()) {
                resultado = valor * 6.1137;
                moeda = "Libra";
            }

            String resultadoText = String.format("Prezado(a) %s. Se você tiver o salário de %.2f %s, você vai receber um salário de R$ %.2f reais", nome, valor, moeda, resultado);

            resultadoTextView.setText(resultadoText);
        });
    }
}
