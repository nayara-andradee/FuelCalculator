package com.example.fuelcalculator.presentation

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.fuelcalculator.R
import com.example.fuelcalculator.Resultado


/**

 * create an instance of this fragment.
 */
class TravelCostFragment : Fragment() {

    var viewModel = FuelCalculatorViewModel.creat()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_travel_cost, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val edt_consumo = view.findViewById<EditText>(R.id.edt_travel_consumo)
        val edt_distancia = view.findViewById<EditText>(R.id.edt_travel_distancia)
        val edt_preco = view.findViewById<EditText>(R.id.edt_travel_preco)
        val edt_pessoas = view.findViewById<EditText>(R.id.edt_travel_pessoas)
        val btn_calcular = view.findViewById<Button>(R.id.btn_travel_calcular)



        btn_calcular.setOnClickListener {
            //pegando entrada do usuáio
            val consumo = edt_consumo.text.toString()
            val distancia = edt_distancia.text.toString()
            val preco = edt_preco.text.toString()
            val pessoas = edt_pessoas.text.toString()

            if (consumo.isNotEmpty() && distancia.isNotEmpty()
                && preco.isNotEmpty() && pessoas.isNotEmpty()){
                //convertendo os dados inseridos em "Int" e "Float"
                val consumoInt = viewModel.convertDouble(consumo)
                val distanciaDouble = viewModel.convertDouble(distancia)
                val precoDouble = viewModel.convertDouble(preco)
                val pessoasDouble = viewModel.convertDouble(pessoas)
                // calculando resultados.
                val litrosPorViagem = viewModel.calcLitrosPorViagem(distanciaDouble,consumoInt)
                val custoViagem = viewModel.calcCustoViagem(litrosPorViagem, precoDouble)
                val custoPorPessoas = viewModel.custoPorPessoa(custoViagem,pessoasDouble)
                val resultado = Resultado(litrosPorViagem,distanciaDouble,custoViagem,custoPorPessoas)

                    val argument = resultado
                    val dialog = DialogCusto.newInstance(argument)
                    dialog.show(requireFragmentManager(), "MeuDialogFragment")


            }else{viewModel.showmessege(view,"Preencha todos os campos para calcular")}

        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         */

        @JvmStatic
        fun newInstance() = TravelCostFragment()
            }
    }


