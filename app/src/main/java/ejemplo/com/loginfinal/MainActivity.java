package ejemplo.com.loginfinal;

import android.Manifest;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private SwipeRefreshLayout swipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textEmail = (TextView) findViewById(R.id.editEmail);
        textEmail.setError("Es requerido");
        TextView textPass = (TextView) findViewById(R.id.editPassword);
        textPass.setError("Es requerido");
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
        checkBox.setError("Es requerido");
    }

   public void enviarDatos(View view) {

       TextView textEmail = (TextView) findViewById(R.id.editEmail);
       TextView textPass = (TextView) findViewById(R.id.editPassword);
       CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
       int cont = 0;
       if (textEmail.getText().toString().isEmpty()) {
           Toast.makeText(getBaseContext(), "Ingrese el Email", Toast.LENGTH_LONG).show();
       } else if (textPass.getText().toString().isEmpty()) {
           Toast.makeText(getBaseContext(), "Ingrese el Password", Toast.LENGTH_LONG).show();
       } else if (!checkBox.isChecked()) {
           Toast.makeText(getBaseContext(), "Acepte el ingreso", Toast.LENGTH_LONG).show();
       } else if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.INTERNET)) {
           Toast.makeText(getBaseContext(), "Necesita permisos de internet", Toast.LENGTH_LONG).show();
       }else {
           cont = 1;
       }

       if (cont == 1) {
           Intent i = new Intent(this, NextActivity.class);
           startActivity(i);

        /*   swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
               @Override
               public void onRefresh() {
                   Log.i(TAG, "Ingreso a refresh");
                   swipeRefreshLayout.setRefreshing(false);
               }
           });*/
       }
   }
}