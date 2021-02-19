package com.example.desafio1dsm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etSueldo;
    private EditText etAnyos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etSueldo = (EditText)findViewById(R.id.txtSueldo);
        etAnyos = (EditText)findViewById(R.id.txtAnyos);
    }

    public void calculoSueldo(View v){
        int r = 0;
        etSueldo.setError(null);
        etAnyos.setError(null);
        String noSueldo = etSueldo.getText().toString();
        String noAnyos = etAnyos.getText().toString();
        if("".equals(noSueldo) && "".equals(noAnyos)){
            etSueldo.setError("Debe llenar este campo");
            etSueldo.requestFocus();
            return;
        }
        else if("".equals(noSueldo) && noSueldo != ""){
            etSueldo.setError("No se permite este campo vacio");
            etSueldo.requestFocus();
            return;
        }
        else if("".equals(noAnyos) && noAnyos != ""){
            etAnyos.setError("No se permite este campo vacio");
            etAnyos.requestFocus();
            return;
        }
        int _sueldo = Integer.parseInt(noSueldo);
        int _anyos = Integer.parseInt(noAnyos);
        if (_sueldo < 100 || _sueldo > 1200) {
            etSueldo.setError("Numero Fuera del Rango ($100 a $1200)");
            etSueldo.requestFocus();
        }
        else {
            String toastText1 = "Todo en orden, sueldo actual valido";
            Toast notification1 = Toast.makeText(MainActivity.this, toastText1, Toast.LENGTH_SHORT);
            notification1.show();
            r++;
            if(_anyos < 0 || _anyos > 25){
                etAnyos.setError("Numero Fuera del Rango (0 a 25 años)");
                etAnyos.requestFocus();
            }
            else {
                String toastText2 = "Todo en orden, cantidad de años en orden";
                Toast notification2 = Toast.makeText(MainActivity.this, toastText2, Toast.LENGTH_SHORT);
                notification2.show();
                r++;
            }
        }

        if (r == 2){
            Intent i = new Intent(this, CalculoSueldo.class);
            i.putExtra("txtSueldo", noSueldo);
            i.putExtra("txtAnyos", noAnyos);
            startActivity(i);
        }
    }

}