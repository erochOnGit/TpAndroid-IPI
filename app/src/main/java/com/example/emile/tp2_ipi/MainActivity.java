package com.example.emile.tp2_ipi;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /* Crée le menu */
    public boolean onCreateOptionsMenu(Menu menu)
    {
        menu.add(0, 25, 0, "alert");
        menu.add(0, 26, 0, "timepicker");
        menu.add(0, 27, 0, "datePicker");
        menu.add(0,25, 0, "New Game").setIcon(R.mipmap.ic_launcher);
        menu.add(0,25, 0, "New Game").setIcon(R.mipmap.ic_launcher)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        return super.onCreateOptionsMenu(menu);
    }
    /* Handles item selections */
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case 25:
                //Préparation de la fenêtre
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
//Message
                alertDialogBuilder.setMessage("Mon message");
//titre
                alertDialogBuilder.setTitle("Mon titre");
//bouton ok
                alertDialogBuilder.setPositiveButton("ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
//Affiche un toast apres le click sur le bouton ok
                                Toast.makeText(MainActivity.this, "Click sur ok",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
//Icone
                alertDialogBuilder.setIcon(R.mipmap.ic_launcher);
//Afficher la fenêtre
                alertDialogBuilder.show();
                break;
            case 26:
//(Context, callback, heure, minute, 24h format)
                TimePickerDialog timePickerDialog = new TimePickerDialog(this, this, 14, 33, true);
                timePickerDialog.show();
                break;
            case 27:
//Gestion de la date
                Calendar calendar = Calendar.getInstance();
//Création de la fenêtre
                DatePickerDialog datePickerDialog = new DatePickerDialog(this, this,
                        calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH));
//Afficher la fenêtre
                datePickerDialog.show();
                break;
        }
        return super.onOptionsItemSelected(item);
    } 


    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {

    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

    }
}
