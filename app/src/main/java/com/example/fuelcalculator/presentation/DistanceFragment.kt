package com.example.fuelcalculator.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.fuelcalculator.R


/**
 * A simple [Fragment] subclass.
 * Use the [DistanceFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DistanceFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_distance, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnCalculate = view.findViewById<Button>(R.id.btn_calculate)
        val consumoKmL = view.findViewById<EditText>(R.id.consumo_km_L)
        val combustivel = view.findViewById<EditText>(R.id.consumo_km_L)
        val precoCombustivel = view.findViewById<EditText>(R.id.preco_combustivel_L)


        btnCalculate.setOnClickListener {
            val consumoString = consumoKmL.text.toString()
            val combustivelString = combustivel.text.toString()
            val precoCombustivelString = precoCombustivel.text.toString()

            if (consumoString.isNotEmpty() && combustivelString.isNotEmpty() && precoCombustivelString.isNotEmpty()) {
                val consumo = consumoString.toDouble()
                val combustivel = combustivelString.toDouble()
                val precoCombustivel = precoCombustivelString.toDouble()

                val precoTotalCombustivel = combustivel * precoCombustivel
                val distancia = consumo * combustivel

            }
        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         */
        @JvmStatic
        fun newInstance() = DistanceFragment()
    }
}