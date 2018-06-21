package com.example.claytonandrade.lanchonetemodelo.cards;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.claytonandrade.lanchonetemodelo.SetIngredientes;
import com.example.claytonandrade.lanchonetemodelo.model.Lanche;
import com.example.claytonandrade.lanchonetemodelo.R;

import java.util.ArrayList;
import java.util.List;

public class CardCardapio extends RecyclerView.Adapter<CardCardapio.ViewHolder>  {

    private List<Lanche> io_lanche;
    private Activity io_acActivityCardapio;

    public CardCardapio(final Activity io_activity){
        this.io_acActivityCardapio = io_activity;

        io_lanche = new ArrayList<Lanche>();
        io_lanche.add(new Lanche(io_activity.getResources().getString(R.string.x_salada),io_activity.getResources().getString(R.string.valor_salada),io_activity.getResources().getString(R.string.x_salada_ingredientes), R.drawable.x_salada));
        io_lanche.add(new Lanche(io_activity.getResources().getString(R.string.x_burg),io_activity.getResources().getString(R.string.valor_burg),io_activity.getResources().getString(R.string.x_burg_ingredientes), R.drawable.x_burg));
        io_lanche.add(new Lanche(io_activity.getResources().getString(R.string.x_bacon),io_activity.getResources().getString(R.string.valor_bacon),io_activity.getResources().getString(R.string.x_bacon_ingredientes), R.drawable.x_bacon));
        io_lanche.add(new Lanche(io_activity.getResources().getString(R.string.x_calabresa),io_activity.getResources().getString(R.string.valor_calabresa),io_activity.getResources().getString(R.string.x_calabresa_ingredientes), R.drawable.x_calabresa));
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_cardapio,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Lanche lanche = io_lanche.get(position);
        holder.foto_lanche.setImageDrawable(io_acActivityCardapio.getResources().getDrawable(lanche.getFoto_lanche()));
        holder.nome_lanche.setText(lanche.getNome_lanche());
        holder.valor_lanche.setText(lanche.getValor_lanche());
        holder.descricao_lanche.setText(""+lanche.getDescricao_lanche());


    }

    @Override
    public int getItemCount() {
        return io_lanche.size();
    }

    class  ViewHolder extends RecyclerView.ViewHolder{

        ImageView foto_lanche;
        TextView nome_lanche;
        TextView valor_lanche;
        TextView descricao_lanche;
        ImageButton img_btn_addRedondo;

        public ViewHolder(View itemView) {
            super(itemView);

            foto_lanche = (ImageView)itemView.findViewById(R.id.foto_lanche);
            nome_lanche = (TextView)itemView.findViewById(R.id.nome_lanche);
            valor_lanche = (TextView)itemView.findViewById(R.id.valor_lanche);
            descricao_lanche = (TextView)itemView.findViewById(R.id.descricao_lanche);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    v.getContext().startActivity(new Intent(v.getContext(),SetIngredientes.class));
                    io_acActivityCardapio.finish();

                }

                {

                }
            });
        }




    }
}

