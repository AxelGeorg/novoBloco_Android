package br.ifsc.edu.blocodenotas;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.campoTexto);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("nota", editText.getText().toString());
                editor.commit();
                //

            }
        });
        //Configuração SharePreferences
        sharedPreferences = getSharedPreferences("BlocoDeNotas", MODE_PRIVATE);

        editor = sharedPreferences.edit();

    }


    @Override
    protected void onStart() {
        super.onStart();
        editText.setText(sharedPreferences.getString("nota", ""));
    }
}
