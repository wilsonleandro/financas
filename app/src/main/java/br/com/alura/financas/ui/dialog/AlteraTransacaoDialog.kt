package br.com.alura.financas.ui.dialog

import android.content.Context
import android.view.ViewGroup
import br.com.alura.financas.R
import br.com.alura.financas.extension.formataParaBrasileiro
import br.com.alura.financas.model.Tipo
import br.com.alura.financas.model.Transacao

class AlteraTransacaoDialog(
    viewGroup: ViewGroup,
    private val context: Context) : FormularioTransacaoDialog(context, viewGroup) {

    override val tituloBotaoPositivo: String
        get() = "Alterar"

    override fun tituloPor(tipo: Tipo): Int {
        if (tipo == Tipo.RECEITA) {
            return R.string.altera_receita
        }
        return R.string.altera_despesa
    }

    fun chama(transacao: Transacao, delegate: (transacao: Transacao) -> Unit) {
        val tipo = transacao.tipo
        super.chama(tipo, delegate)
        inicializaCampos(transacao)
    }

    private fun inicializaCampos(transacao: Transacao) {
        val tipo = transacao.tipo
        campoValor.setText(transacao.valor.toString())
        campoData.setText(transacao.data.formataParaBrasileiro())
        val categorias = context.resources.getStringArray(categoriasPor(tipo))
        val posicao = categorias.indexOf(transacao.categoria)
        campoCategoria.setSelection(posicao, true)
    }

}
