package com.example.cartest

import android.app.AlertDialog
import android.content.Context

class MakeAlert {

    fun makeAlert(context: Context, title: String, description: String) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle(title)
        builder.setMessage(description)
        builder.setNegativeButton("Ok") { dialog, which ->
            dialog.cancel()
        }
        builder.show()
    }
}