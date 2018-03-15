package br.com.kituteprogramador.biblioteca.commons.utils.Extensions

import android.widget.EditText

/**
 * Created by brunoalmeida on 15/03/18.
 */

fun EditText.verifyIsFilled() : Boolean{

        if (this.text.isEmpty()) {
            return false
        }

        return true
}