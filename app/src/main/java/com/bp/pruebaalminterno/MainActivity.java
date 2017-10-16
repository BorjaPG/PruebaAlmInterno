package com.bp.pruebaalminterno;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String FILENAME = "miArchivo.txt";
        String str = "Esto es un ejemplo de almacenamiento interno";

        /* Ecritura de un fichero. */
        FileOutputStream fos;
        try {
            //Abrir el archivo indicando nombre y modo.
            fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
            //Escribe en el archivo.
            fos.write(str.getBytes());
            //Cerrar archivo.
            fos.close();
            /* Trata errores como no encontrar el archivo o problemas para escribir
            debido a permisos. */
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*Lectura de un fichero. */
        FileInputStream fis;
        try {
            //Abre el fichero.
            fis = openFileInput(FILENAME);
            //El buffer se rellena a medida que se hacen lecturas.
            byte[] buffer = new byte[1024];
            //Content almacena el contenido del fichero.
            StringBuilder content = new StringBuilder();
            //Mientras no termine de leer...
            while ((fis.read(buffer)) != -1) {
                //...sigue almacenando en el buffer.
                content.append(new String(buffer));
            }
            //Muestra el contenido. 
            Log.d("Ch10", "content = " + content.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
