package br.com.alura.financas.dao

import br.com.alura.financas.model.Transacao

class TransacaoDao {

    val transacoes: List<Transacao> = Companion.transacoes

    // atributo statico
    companion object {
        private val transacoes: MutableList<Transacao> = mutableListOf();
    }

    fun adiciona(transacao: Transacao) {
        Companion.transacoes.add(transacao)
    }

    fun altera(transacao: Transacao, posicao: Int) {
        Companion.transacoes[posicao] = transacao
    }

    fun remove(posicao: Int) {
        Companion.transacoes.removeAt(posicao)
    }
}
