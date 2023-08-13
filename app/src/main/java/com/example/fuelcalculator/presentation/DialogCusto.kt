package com.example.fuelcalculator.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.fuelcalculator.R
import com.example.fuelcalculator.Resultado

class DialogCusto : DialogFragment() {

    private val resultado_extra = "resultado_de_resgate"

    companion object {
        const val ARGUMENT_KEY = "argument_key"

        fun newInstance(resultado: Resultado): DialogCusto {
            val fragment = DialogCusto()
            val args = Bundle().apply {
                putSerializable(ARGUMENT_KEY, resultado)
            }
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_custo, container)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tv_totallitros = view.findViewById<TextView>(R.id.tv_dialogcusto_totallitros)
        val tv_totalkms = view.findViewById<TextView>(R.id.tv_dialogcusto_totalkm)
        val tv_custoviagem = view.findViewById<TextView>(R.id.tv_dialogcusto_custoviagem)
        val tv_custopessoa = view.findViewById<TextView>(R.id.tv_dialogcusto_custopessoa)
        val resultado = arguments?.getSerializable(ARGUMENT_KEY) as? Resultado
        val totalLitros: String = "%.2fLt".format(resultado?.totallitros)
        val totalkm: String = "%.2fKm".format(resultado?.totalkm)
        val custoviagem: String = "R$%.2f".format(resultado?.custviagem)
        val custopessoa: String = "R$%.2f".format(resultado?.custopessoa)



        if(resultado != null){
            tv_totallitros.text = totalLitros
            tv_totalkms.text = totalkm
            tv_custoviagem.text = custoviagem
            tv_custopessoa.text = custopessoa

        }


    }
}