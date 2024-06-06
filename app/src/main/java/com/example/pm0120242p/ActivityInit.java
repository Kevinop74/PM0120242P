package com.example.pm0120242p;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Configuracion.SQLiteConexion;
import Configuracion.Trans;

public class ActivityInit extends AppCompatActivity {
    EditText nombres, apellidos, edad, correo;
    Button btingresar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init);

        nombres = (EditText) findViewById(R.id.nombres);
        apellidos = (EditText) findViewById(R.id.apellidos);
        edad = (EditText) findViewById(R.id.edad);
        correo = (EditText) findViewById(R.id.correo);
        btingresar = (Button) findViewById(R.id.btningresar);

        btingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Agregar();
            }
        });
    }

    private void Agregar() {

       try {
           SQLiteConexion conexion = new SQLiteConexion(this, Trans.DBname, null, 1);
           SQLiteDatabase db = conexion.getWritableDatabase();
           ContentValues valores  = new ContentValues();
           valores.put(Trans.nombres, nombres.getText().toString());
           valores.put(Trans.apellidos, apellidos.getText().toString());
           valores.put(Trans.edad, edad.getText().toString());
           valores.put(Trans.correo, correo.getText().toString());

           Long resultado = db.insert(Trans.TablePersonas, Trans.id, valores);

           Toast.makeText(getApplicationContext(), "Registro Ingresado con exito" + resultado.toString(),
           Toast.LENGTH_LONG).show();

           db.close();
       }
       catch (Exception ex )
       {
           ex.toString();

       }
    }}



