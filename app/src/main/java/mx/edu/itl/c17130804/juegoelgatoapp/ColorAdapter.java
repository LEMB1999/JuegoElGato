package mx.edu.itl.c17130804.juegoelgatoapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ColorAdapter extends ArrayAdapter<String> {

    //----------------------------------------------------------------------------------------------
    // Constructor

    public ColorAdapter(@NonNull Context context, ArrayList<String> colores ) {
        super ( context, 0, colores );
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return inicializarView ( position, convertView, parent );
    }

    @Override
    public View getDropDownView ( int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return inicializarView ( position, convertView, parent );
    }

    //----------------------------------------------------------------------------------------------
    // Metodo personalizado para inicializar la vista del elemento dado por el argumento position

    private View inicializarView ( int position, @Nullable View convertView, @NonNull ViewGroup parent ) {

        if ( convertView == null ){
            convertView = LayoutInflater.from( getContext() ).inflate( R.layout.spinner_color , parent , false );
        }
        TextView nombre = convertView.findViewById( R.id.txtvNombre );

        String nombrecolor = getItem( position );
        nombre.setText(nombrecolor);


        return convertView;
    }

    //----------------------------------------------------------------------------------------------
}

