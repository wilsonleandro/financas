package br.com.alura.financas.extension

import java.text.SimpleDateFormat
import java.util.*

fun Calendar.formataParaBrasileiro(): String {
    val formato = SimpleDateFormat("dd/MM/yyyy")
    return formato.format(this.time)
}
