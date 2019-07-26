package br.com.alura.financas.ui.activiy

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.alura.financas.R
import br.com.alura.financas.model.Tipo
import br.com.alura.financas.model.Transacao
import br.com.alura.financas.ui.adapter.ListaTransacoesAdapter
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import java.math.BigDecimal
import java.util.*

class ListaTransacoesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)
        val transacoes = transacoesDeExemplo()
        configuraLista(transacoes)
    }

    private fun configuraLista(transacoes: List<Transacao>) {
        lista_transacoes_listview.adapter = ListaTransacoesAdapter(transacoes, this)
    }

    private fun transacoesDeExemplo(): List<Transacao> {
        // constructor using named parameter
        val comida = Transacao(
            categoria = "Comida",
            tipo = Tipo.DESPESA,
            data = Calendar.getInstance(),
            valor = BigDecimal(20.5)
        )
        val economia = Transacao(BigDecimal(100.0), "Economia", Tipo.RECEITA)
        val despesa = Transacao(valor = BigDecimal(200.0), tipo = Tipo.DESPESA)
        val receita = Transacao(valor = BigDecimal(500.0), tipo = Tipo.RECEITA, categoria = "Prêmio")

        val transacoes = listOf(comida, economia, despesa, receita)
        return transacoes
    }

}
