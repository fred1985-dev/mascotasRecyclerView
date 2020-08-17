package com.servicsofts.miscontactos;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder> {

    //defino una lista
    ArrayList<Mascota> mascotas;
    /*
    Hemos puesto un mensaje Toast, que nos muestra el nombre del contacto,
     al dar click en su foto. Como observas el mensaje Toast recibe un objeto activity
     como contexto este lo estaremos declarando como variable global en nuestra
    clase ContactoAdaptador y lo inicializaremos en el constructor como se observa:
     */
    Activity activity;
    //metodo constructor para pasar la lista al objeto contactos
    public  ContactoAdaptador (ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity=activity;

    }


    @NonNull
    @Override  //con este metodo le damos vida a nuestro layou cardView
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      //le dmaos vida a nuestro layout RecyclerView indicamos cual es el layou
       View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto,parent, false);
        return new ContactoViewHolder(v) ;
    }

    @Override //en este netodo vamos  nuestra lista de contacto y seteamos cada uno de los elementos
    public void onBindViewHolder(@NonNull ContactoViewHolder holder, int position) {
       final Mascota mascota = mascotas.get(position);
        holder.imgFoto.setImageResource(mascota.getFoto());
        holder.tvNombreCv.setText(mascota.getNombre());


        //agreganos un evento onClickListener
        holder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity,  mascota.getNombre(), Toast.LENGTH_SHORT).show();

                //Ahora solo nos faltará colocar nuestro intent para que nos lleve a la actividad DetalleContacto
                Intent intent = new Intent(activity, DetalleActivity.class);
                intent.putExtra("nombre", mascota.getNombre());
                intent.putExtra("email", mascota.getEmail());
                activity.startActivity(intent);
            }
        });
    }

    //cantidad de elemento q contiene la lista
    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    //viewholder se maneja la logia de nuesrta view
    public static class  ContactoViewHolder extends RecyclerView.ViewHolder{

         private ImageView imgFoto;
         private TextView tvNombreCv;
         private TextView tvemail;


         public ContactoViewHolder(View itemView){
             super(itemView);
             imgFoto=(ImageView) itemView.findViewById(R.id.imgFoto);
             tvNombreCv = (TextView) itemView.findViewById(R.id.tvNombre);
             tvemail = (TextView) itemView.findViewById(R.id.tvEmail);
         }

    }
}
