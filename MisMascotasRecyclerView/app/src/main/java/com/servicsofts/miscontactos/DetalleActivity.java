package com.servicsofts.miscontactos;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

public class DetalleActivity extends AppCompatActivity {

      //declaro globales para ponderlos manipular
      TextView  tvNpmbre ;
      TextView  tvApellido;
      TextView  tvTelefo;
      TextView  tvEmail ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        //objeto bundle para recibir los parametros
        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString(getResources().getString(R.string.pnombre));
        String apellido = parametros.getString(getResources().getString(R.string.papellido));
        String email = parametros.getString(getResources().getString(R.string.pemail));
        String telefono = parametros.getString(getResources().getString(R.string.ptelefono));

     //luego paso los parametros a los viewList definidos
         tvNpmbre = (TextView) findViewById(R.id.tvNombre);
         tvApellido = (TextView) findViewById(R.id.tvApellido);
         tvTelefo = (TextView) findViewById(R.id.tvtelef);
         tvEmail = (TextView) findViewById(R.id.tvEmail);

        tvNpmbre.setText(nombre);
        tvApellido.setText(apellido);
        tvTelefo.setText(telefono);
        tvEmail.setText(email);

    }

    public void llamar (View v){
      String  telefono = tvTelefo.getText().toString();
      startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel"+telefono)));
    }

    public  void enviarEmail(View v){
        String  email = tvEmail.getText().toString();
      Intent  emailIten =   new Intent(Intent.ACTION_SEND);
        emailIten.setData(Uri.parse("mailto:"));
        emailIten.putExtra(Intent.EXTRA_EMAIL, email);
        emailIten.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIten,"Email"));
    }

   //mantener la actividad anterior
    @Override
    public  boolean onKeyDown(int keyCode, KeyEvent event){
     if(keyCode== KeyEvent.KEYCODE_BACK){
      Intent intent = new Intent(DetalleActivity.this,MainActivity.class);
     }
     return super.onKeyDown(keyCode, event);
    }
}