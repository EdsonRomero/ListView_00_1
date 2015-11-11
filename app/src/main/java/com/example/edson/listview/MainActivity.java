package com.example.edson.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.internal.view.menu.ActionMenuItemView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<String> nomes = new ArrayList<>();
    EditText edit;
    Button btn;
    ListView lista;
    TextView lstTotal;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit= (EditText) findViewById(R.id.xNome);
        btn= (Button) findViewById(R.id.xbtn);
        lista=(ListView) findViewById(R.id.xList);
        lstTotal=(TextView) findViewById(R.id.txtNumero);


        final  ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nomes);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (edit.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Preencha o EditTest", Toast.LENGTH_SHORT).show();
                } else { if(edit.getText().toString().length()<=3 ) {
                        Toast.makeText(MainActivity.this, "Preencha o EditTest com mais que 3 caracteres", Toast.LENGTH_SHORT).show();
                          }else{
                                if(nomes.isEmpty()){

                                    String nomeAdd= edit.getText().toString().toLowerCase();
                                    nomes.add(nomeAdd);
                                    Toast.makeText(MainActivity.this, "Parabens add " + nomeAdd, Toast.LENGTH_SHORT).show();
                                    lista.setAdapter(adapter);
                                    lstTotal.setText(String.valueOf(nomes.size()));
                                    adapter.notifyDataSetChanged();
                                    edit.setText("");
                                    edit.setHint("Digite");
                                }else{
                                            int x =0 ;
                                                int y =0;

                                            do{if(nomes.get(x).equalsIgnoreCase(edit.getText().toString())){
                                                Toast.makeText(MainActivity.this, "ja Existe na lista", Toast.LENGTH_SHORT).show();
                                                y++;
                                                break;
                                            }else{
                                                x++;
                                            }

                                            }while(x<nomes.size());
                                                if(y ==0) {
                                                    String nomeAdd= edit.getText().toString().toLowerCase();
                                                    nomes.add(nomeAdd);
                                                    Toast.makeText(MainActivity.this, "Parabens add " + nomeAdd, Toast.LENGTH_SHORT).show();
                                                    lista.setAdapter(adapter);
                                                    lstTotal.setText(String.valueOf(nomes.size()));
                                                    adapter.notifyDataSetChanged();
                                                    edit.setText("");
                                                    edit.setHint("Digite");
                                                }
                                    }
                            }

                   }
             }
        });

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selecao = (String) parent.getAdapter().getItem(position);
                //nomes.remove(selecao);
                //lista.setAdapter(adpter);
                Toast.makeText(MainActivity.this, selecao, Toast.LENGTH_SHORT).show();
                int p = nomes.indexOf(selecao);

                Intent i = new Intent(MainActivity.this, Alteracao.class);
                i.putExtra("p", p);
                i.putExtra("nomeA", selecao);
                startActivity(i);

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        lstTotal.setText(String.valueOf(nomes.size()));
    }



}


