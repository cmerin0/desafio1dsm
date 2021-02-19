package com.example.desafio1dsm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CalculoSueldo extends AppCompatActivity {

    private TextView tvSueldo;
    private TextView tvAumento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_sueldo);

        tvSueldo = (TextView)findViewById(R.id.txvSueldo);
        tvAumento = (TextView)findViewById(R.id.txvAumento);

        Bundle bundle = getIntent().getExtras();
        String sueldo = bundle.getString("txtSueldo");
        double _sueldo = Double.parseDouble(sueldo);
        String anyos = bundle.getString("txtAnyos");

        double aumento = porcentajeAumento(anyos);
        double nSueldo = calcularAumento(_sueldo, aumento);

        tvSueldo.setText("El Salario del Empleado es: $" + nSueldo);
        if(_sueldo > 500)
            tvAumento.setText("Empleado no califica a aumento");
        else
            tvAumento.setText("El Empleado recibio un aumento de " + (aumento * 100) + "%");
    }

    public void finalizar(View v){
        finish();
    }

    public double calcularAumento(double _sueldo, double aumento){
        if(_sueldo < 500){
            _sueldo = _sueldo * (1 + aumento);
        }
        else if (_sueldo < 500){
            _sueldo = _sueldo * (1 + aumento);
        }
        return _sueldo;
    }

    public double porcentajeAumento(String anyos){
        int _anyos = Integer.parseInt(anyos);
        double aumento;
        if (_anyos > 10)
            aumento = 0.20;
        else
            aumento = 0.05;
        return aumento;
    }

}