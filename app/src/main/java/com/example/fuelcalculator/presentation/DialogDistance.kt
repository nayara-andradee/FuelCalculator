package com.example.fuelcalculator.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.fuelcalculator.R
import com.example.fuelcalculator.Resultado
import com.example.fuelcalculator.ResultadoDistance

class DialogDistance : DialogFragment() {

    private val resultado_extra = "resultado_de_resgate"

    companion object {
        const val ARGUMENT_KEY = "argument_key"

        fun newInstance(resultado: ResultadoDistance): DialogDistance {

            val fragment = DialogDistance()
            val args = Bundle().apply {
                putSerializable(ARGUMENT_KEY, resultado)
            }
            fragment.arguments = args
            return fragment
        }

        private fun resultado(resultado1: Resultado, resultado2: Resultado) {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_distance, container)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val resultado = arguments?.getSerializable(ARGUMENT_KEY) as? ResultadoDistance
        val resultadoDistancia = view.findViewById<TextView>(R.id.resultado_distancia)
        val resultadoPreco = view.findViewById<TextView>(R.id.resultado_preco)
        val autonomia: String = "%.2f Km".format(resultado?.autonomia)
        val custoviagem: String = "R$ %.2f".format(resultado?.precoTotalCombustivel)

        resultadoDistancia.text = autonomia
        resultadoPreco.text = custoviagem
    }
}
