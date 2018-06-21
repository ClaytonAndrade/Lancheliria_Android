package com.example.claytonandrade.lanchonetemodelo;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.example.claytonandrade.lanchonetemodelo.lib.Util;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    LinearLayout linearLayout_anun_simples;
    LinearLayout linearLayout_anun_personalizado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        linearLayout_anun_simples = (LinearLayout)findViewById(R.id.layout_anuncio_simples);
        linearLayout_anun_personalizado = (LinearLayout)findViewById(R.id.layout_anuncio_personalizado);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(final MenuItem item) {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        Handler handler = new Handler();
        Runnable run = new Runnable() {
            @Override
            public void run() {
                // Handle navigation view item clicks here.
                int id = item.getItemId();

                if (id == R.id.nav_cardapio) {
                    startActivity(new Intent(MainActivity.this,Cardapio.class));
                    overridePendingTransition(R.anim.slide_entrada_direita,R.anim.slide_saida_esquerda);
                } else if (id == R.id.nav_bebidas) {
                    startActivity(new Intent(MainActivity.this,Bebidas.class));
                    overridePendingTransition(R.anim.slide_entrada_direita,R.anim.slide_saida_esquerda);
                //} else if (id == R.id.nav_home) {
                } else if (id == R.id.nav_pedido) {
                    startActivity(new Intent(MainActivity.this,Pedido.class));
                    overridePendingTransition(R.anim.slide_entrada_direita,R.anim.slide_saida_esquerda);
                } else if (id == R.id.nav_desenvolvedores) {
                    Util.MenssagemApresentar("Contato", "Ligue 48 99849 0551 ", MainActivity.this,
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });
                } else if (id == R.id.nav_contato) {
                    startActivity(new Intent(MainActivity.this,Contato.class));
                    overridePendingTransition(R.anim.slide_entrada_direita,R.anim.slide_saida_esquerda);
                } else if (id == R.id.nav_localidade) {
                    startActivity(new Intent(MainActivity.this,OndeEstamos.class));
                    overridePendingTransition(R.anim.slide_entrada_direita,R.anim.slide_saida_esquerda);
                } else if (id == R.id.nav_end_entrega){
                    startActivity(new Intent(MainActivity.this,Entrega.class));
                    overridePendingTransition(R.anim.slide_entrada_direita,R.anim.slide_saida_esquerda);
                }
            }
        };
        handler.postDelayed(run, 500);

        return true;
    }
    public Class chamaTela(Class c){
        return c;
    }

    public void ChamaAnuncioSimples(View view) {
        startActivity(new Intent(MainActivity.this, AnuncioSimples.class));
    }

    public void ChamaPersonalizado(View view){
        startActivity(new Intent(MainActivity.this,AnuncioPersonalizado.class));
    }


}
