package com.example.edson.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Alteracao extends AppCompatActivity {

    Button btnUp,btnDel,btnCancel;
    EditText xUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alteracao);

        final Bundle extra = getIntent().getExtras();
        final int p = extra.getInt("p");
        final String nomeA = extra.getString("nomeA");



        btnUp = (Button) findViewById(R.id.xBtnU);
        btnDel=(Button) findViewById(R.id.xBtnD);
        btnCancel = (Button) findViewById(R.id.xBtnC);
        xUp = (EditText) findViewById(R.id.xUpd);

        btnUp.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {

                                         String novoNome= xUp.getText().toString().toLowerCase();

                                         Toast.makeText(Alteracao.this, "Alterou "+ nomeA + " para " + novoNome, Toast.LENGTH_SHORT).show();
                                         MainActivity.nomes.set(p,novoNome);
                                         onBackPressed();
                                     }
                                 }

        );
        btnDel.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          Toast.makeText(Alteracao.this, "Removeu " + nomeA, Toast.LENGTH_SHORT).show();
                                          MainActivity.nomes.remove(p);
                                          onBackPressed();
                                      }
                                  }
        );


    }
}
