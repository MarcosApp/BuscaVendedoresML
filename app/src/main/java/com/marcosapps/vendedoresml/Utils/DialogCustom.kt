package com.marcosapps.vendedoresml.Utils

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import com.marcosapps.vendedoresml.R
import kotlinx.android.synthetic.main.fragment_dialog.view.*

class DialogCustom {

    fun DialogMessage (context:Context, title:String, descMessage:String){

        val mDialogView = LayoutInflater.from(context).inflate(R.layout.fragment_dialog, null)

        val mBuilder = AlertDialog.Builder(context)
                .setView(mDialogView)

        mDialogView.textTitle.text = title

        mDialogView.textDescricao.text = descMessage

        val mAlertDialog = mBuilder.show()

        mDialogView.btnCancel.setOnClickListener {

            mAlertDialog.dismiss()
        }
    }
}