package com.example.claytonandrade.lanchonetemodelo;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.attr.dial;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static android.media.CamcorderProfile.get;
import static com.example.claytonandrade.lanchonetemodelo.R.array.ingredientes;
import static java.security.AccessController.getContext;

public class SetIngredientes extends AppCompatActivity {

    private ImageView foto_do_lanche;
    private TextView nome_do_lanche;
    private Button btn_adicionar;
    private Button btn_retirar;
    private Button btn_add_pedido;
    private ListView preferencia_ingredientes;
    String[] valuesPadrao;
    String[] valuesGostinho;
    ArrayAdapter<String> adapterPadrao;
    ArrayAdapter<String> adapterGostinho;
    final ArrayList<String> ListaPrincipal = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_ingredientes);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        foto_do_lanche = (ImageView)findViewById(R.id.imagem_do_lanche);
        nome_do_lanche = (TextView)findViewById(R.id.nome_do_lanche);
        btn_adicionar = (Button)findViewById(R.id.btn_add_ingredientes);
        btn_retirar = (Button)findViewById(R.id.btn_rem_ingredientes);
        btn_add_pedido = (Button)findViewById(R.id.btn_confirmar_ingredientes);
        preferencia_ingredientes = (ListView) findViewById(R.id.ltv_ingredientes);

    }
    public void RetirarIngredientes(View view){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Retire os Ingredientes");

        boolean[] opcoes_habilitada = new boolean[getResources().getStringArray(ingredientes).length];

        for (int i = 0; i < opcoes_habilitada.length; i++) {
            opcoes_habilitada[i] = true;
        }

        builder.setMultiChoiceItems(ingredientes, opcoes_habilitada, new DialogInterface.OnMultiChoiceClickListener() {



            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked ) {


                if (!isChecked) {
                    ListaPrincipal.add("Sem "+getResources().getStringArray(ingredientes)[which]);
                }
            }

        })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                        adapterPadrao = new ArrayAdapter<String>(SetIngredientes.this,
                                android.R.layout.simple_list_item_1, android.R.id.text1, ListaPrincipal);
                        preferencia_ingredientes.setAdapter(adapterPadrao);


                    }
                })

                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // removes the AlertDialog in the screen
                    }
                })

                .show();

    }

       /* ListView modeList = new ListView(this);
        valuesPadrao = getResources().getStringArray(R.array.ingredientes);
        adapterPadrao = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, valuesPadrao);
        modeList.setAdapter(adapterPadrao);

        builder.setView(modeList);
        final Dialog dialog = builder.create();

        dialog.show();




                    // specify the list array, the items to be selected by default (null for none),
                    // and the listener through which to receive call backs when items are selected
                    // R.array.choices were set in the resources res/values/strings.xml


    }*/

    public void AdicionarIngredientes(View view){

        final ArrayList<Integer> mSelectedItems2 = new ArrayList<Integer>();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Adicione os Ingredientes");

        builder.setMultiChoiceItems(R.array.gostinho, null, new DialogInterface.OnMultiChoiceClickListener() {


        @Override
        public void onClick(DialogInterface dial, int which, boolean isChecked ) {

            if (isChecked) {
                ListaPrincipal.add("Com "+getResources().getStringArray(R.array.gostinho)[which]);
            }
        }

    })
            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dial, int id) {

            adapterPadrao = new ArrayAdapter<String>(SetIngredientes.this,
                    android.R.layout.simple_list_item_1, android.R.id.text1, ListaPrincipal);
            preferencia_ingredientes.setAdapter(adapterPadrao);


        }
    })

            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dial, int id) {
            // removes the AlertDialog in the screen
        }
    })

            .show();

       /* ListView modeList = new ListView(this);
        valuesGostinho = getResources().getStringArray(R.array.gostinho);
        adapterGostinho = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, valuesGostinho);
        modeList.setAdapter(adapterGostinho);

        builder.setView(modeList);
        final Dialog dialog = builder.create();

        dialog.show();*/

    }
    public void AdicionarAoPedido(View view){
        Toast.makeText(this,"Adicionado ao Pedido", Toast.LENGTH_LONG).show();
        startActivity(new Intent(SetIngredientes.this,Cardapio.class));
        finish();

    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                overridePendingTransition(R.anim.slide_entrada_esquerda, R.anim.slide_saida_direita);
                break;
            default:

                return super.onOptionsItemSelected(item);
        }

        return true;
    }


}
