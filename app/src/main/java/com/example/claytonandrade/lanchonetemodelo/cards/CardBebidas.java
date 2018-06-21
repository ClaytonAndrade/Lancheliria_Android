package com.example.claytonandrade.lanchonetemodelo.cards;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.claytonandrade.lanchonetemodelo.model.BebidaModel;
import com.example.claytonandrade.lanchonetemodelo.R;


import java.util.ArrayList;
import java.util.List;

import static android.app.PendingIntent.getActivity;
import static android.support.v7.widget.AppCompatDrawableManager.get;

public class CardBebidas extends  RecyclerView.Adapter<CardBebidas.ViewHolder> {

    private List<BebidaModel> io_bebidaModel;
    private Activity io_acActivityBEbidas;

    public CardBebidas(final Activity io_activity){
        this.io_acActivityBEbidas = io_activity;

        io_bebidaModel = new ArrayList<BebidaModel>();
        io_bebidaModel.add(new BebidaModel(io_activity.getResources().getString(R.string.coca),io_activity.getResources().getString(R.string.valor_refri_lata),io_activity.getResources().getString(R.string.lata), R.drawable.coca_lata));
        io_bebidaModel.add(new BebidaModel(io_activity.getResources().getString(R.string.pepsi),io_activity.getResources().getString(R.string.valor_refri_lata),io_activity.getResources().getString(R.string.lata), R.drawable.pepsi_lata));
        io_bebidaModel.add(new BebidaModel(io_activity.getResources().getString(R.string.fanta_laranja),io_activity.getResources().getString(R.string.valor_refri_lata),io_activity.getResources().getString(R.string.lata), R.drawable.fanta_laranja_lata));
        io_bebidaModel.add(new BebidaModel(io_activity.getResources().getString(R.string.sukita_uva),io_activity.getResources().getString(R.string.valor_refri_lata),io_activity.getResources().getString(R.string.lata), R.drawable.sukita_uva_lata));
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_bebidas,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        BebidaModel bebidaModel = io_bebidaModel.get(position);
        holder.foto_bebida.setImageDrawable(io_acActivityBEbidas.getResources().getDrawable(bebidaModel.getFoto_bebida()));
        holder.nome_bebida.setText(bebidaModel.getNome_bebida());
        holder.valor_bebida.setText(bebidaModel.getValor_lata());
        holder.descricao_bebida.setText(""+bebidaModel.getDescricao_tipo());
        //holder.img_btn_addRedondo.setImageDrawable(io_acActivityBEbidas.getResources().getDrawable(R.drawable.add_redondo));

    }

    @Override
    public int getItemCount() {
        return io_bebidaModel.size();
    }

    class  ViewHolder extends RecyclerView.ViewHolder{

        ImageView foto_bebida;
        TextView nome_bebida;
        TextView valor_bebida;
        TextView descricao_bebida;
        ImageView img_btn_addRedondo;
        ImageView img_btn_remover;
        TextView txv_qut_refri;
        int qnt = 0;

        public ViewHolder(final View itemView) {
            super(itemView);

            foto_bebida = (ImageView)itemView.findViewById(R.id.foto_bebida);
            nome_bebida = (TextView)itemView.findViewById(R.id.nome_bebida);
            valor_bebida = (TextView)itemView.findViewById(R.id.valor_refri_lata);
            descricao_bebida = (TextView)itemView.findViewById(R.id.descricao_bebida);
            txv_qut_refri = (TextView) itemView.findViewById(R.id.edt_qnt_refri);
            img_btn_remover = (ImageView)itemView.findViewById(R.id.img_btn_remover);
            img_btn_remover.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (qnt==0){

                        Toast.makeText(v.getContext(), "Pedido Vazio, clique em adicionar", Toast.LENGTH_LONG).show();
                    }else {
                        qnt--;
                        txv_qut_refri.setText(String.valueOf(qnt));
                        Toast.makeText(v.getContext(), "Retirado do pedido 1 unidade" + " " + nome_bebida.getText() +" "+ descricao_bebida.getText(), Toast.LENGTH_LONG).show();

                        if (qnt>0){
                            Toast.makeText(v.getContext(), "Adicionado ao pedido " + qnt + " " + nome_bebida.getText() +" "+ descricao_bebida.getText(), Toast.LENGTH_LONG).show();
                        }
                    }

                }
            });
            img_btn_addRedondo = (ImageView)itemView.findViewById(R.id.img_btn_adicionar);
            img_btn_addRedondo.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    qnt++;
                    txv_qut_refri.setText(String.valueOf(qnt));
                    Toast.makeText(v.getContext(), "Adicionado ao pedido " + qnt + " " + nome_bebida.getText() +" "+ descricao_bebida.getText(), Toast.LENGTH_LONG).show();


                }
            });
        }
    }
}
