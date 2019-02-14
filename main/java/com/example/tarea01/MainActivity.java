package com.example.tarea01;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private String Nombre, Telefono, Escolaridad, Genero, Libro;
    private Boolean Deporte;
    private EditText et_Nombre, et_Telefono;
    private AutoCompleteTextView et_Libro;
    private Spinner sp_Escolaridad;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private CheckBox checkBox;
    private boolean checked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        /////////////Definimos el Spinner////////////////////////////////////////////////////////
        Spinner spinner_escolaridad = (Spinner) findViewById(R.id.spinnerESC);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.escolaridad_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_escolaridad.setAdapter(adapter);

        /////Definimos el autocomplete text /////////////////////////////////////////////////////////////
        AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.et_libro);
        String[] libros = getResources().getStringArray(R.array.libros_array);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, libros);
        textView.setAdapter(adapter1);






    }


    ///////Pintamos el menu dentro de nuestra actividad/////////////////////////////////////////////////
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.savebtn:

                et_Nombre = (EditText)findViewById(R.id.et_nombre);
                Nombre = et_Nombre.getText().toString();

                et_Telefono = (EditText)findViewById(R.id.et_telefono);
                Telefono = et_Telefono.getText().toString();

                sp_Escolaridad = (Spinner)findViewById(R.id.spinnerESC);
                Escolaridad = sp_Escolaridad.getSelectedItem().toString();

                /*radioGroup = (RadioGroup) findViewById(R.id.radio);
                int selectedId = radioGroup.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(selectedId);
                Genero = radioButton.getText().toString();*/

                et_Libro = findViewById(R.id.et_libro);
                Libro = et_Libro.getText().toString();

                Deporte = checked;

                Alumno alumno = new Alumno(Nombre, Telefono, Escolaridad, Genero, Libro,Deporte);
                String deporte;

                if(alumno.getDeporte() == true) deporte = "Si";
                else deporte = "No";

                ///////Creacion del Toast///////////////////////////////////////
                Context context = getApplicationContext();
                CharSequence text = "Nombre:"+ alumno.getNombre()+ "Telefono:"+ alumno.getTelefono() + "Escolaridad:"+ alumno.getEscoladridad() //+ "Genero:"+ alumno.getGenero()
                        + "Libro Favorito:"+ alumno.getLibro() + "Practica Deporte:"+ deporte;
                int duration = Toast.LENGTH_LONG;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                /*Context context = getApplicationContext();
                Toast toast = Toast.makeText(context, "HOLA"+ Nombre+ Telefono+ Escolaridad +Libro + deporte, Toast.LENGTH_SHORT);
                toast.show();*/

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void onCheckboxClicked(View view) {

        checkBox = (CheckBox)findViewById(R.id.chbx_deporte);
         checked = checkBox.isChecked();

    }

    public void btnlimpiarclicked(View view){

        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setMessage("Seguro que quieres limpiar?");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Limpiar();

                        dialog.cancel();
                    }
                });

        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancelar",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        alertDialog.show();

    }

    public void Limpiar(){

        ((EditText) findViewById(R.id.et_nombre)).getText().clear();
        ((EditText) findViewById(R.id.et_telefono)).getText().clear();
        //sp_Escolaridad.se
        //radioGroup.clearCheck();
        ((EditText) findViewById(R.id.et_libro)).getText().clear();
         checkBox.setChecked(false);
    }



}
