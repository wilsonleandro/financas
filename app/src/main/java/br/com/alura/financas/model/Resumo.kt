package br.com.alura.financas.model

import java.math.BigDecimal

class Resumo(private val transacoes : List<Transacao>) {
    // Single-Expression Function
    val receita get() = somaPor(Tipo.RECEITA)

    val despesa get() = somaPor(Tipo.DESPESA)

    val total get() = receita.subtract(despesa)

    // Lambda expression
    private fun somaPor(tipo : Tipo) : BigDecimal {
        val somaTransacoes = transacoes.filter{ it.tipo == tipo }
            .sumByDouble{ it.valor.toDouble() }
        return BigDecimal(somaTransacoes)
    }

}