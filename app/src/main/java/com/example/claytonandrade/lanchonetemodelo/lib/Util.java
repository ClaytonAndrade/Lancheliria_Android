package com.example.claytonandrade.lanchonetemodelo.lib;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;

import com.example.claytonandrade.lanchonetemodelo.MainActivity;

/**
 * Created by comp8 on 09/03/2017.
 */

public class Util {
    public static void MenssagemApresentar(final String as_titulos, final String as_menssagem, final Activity ao_activity,DialogInterface.OnClickListener ao_button_ok) {

        AlertDialog.Builder builder = new AlertDialog.Builder(ao_activity);
        builder.setTitle(as_titulos);
        builder.setMessage(as_menssagem);
        builder.setPositiveButton("OK", ao_button_ok);
        builder.create().show();
    }

}
