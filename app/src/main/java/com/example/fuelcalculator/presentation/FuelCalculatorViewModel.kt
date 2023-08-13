package com.example.fuelcalculator.presentation

import android.view.View
import androidx.lifecycle.ViewModel
import com.google.android.material.snackbar.Snackbar

class FuelCalculatorViewModel: ViewModel(){
    //criando o ViewModel
    companion object {
        fun creat(): FuelCalculatorViewModel {
            return FuelCalculatorViewModel()
        }
    }
        //  calculo do sua viagem requer
        fun calcLitrosPorViagem(distancia: Double, medconsumo: Double): Double{
            val result: Double = distancia / medconsumo
            return result
        }

        // calculo custo viagem
        fun calcCustoViagem(quantLitros: Double, valor: Double): Double{
            val result: Double = quantLitros * valor
            return result
        }

        //calculo custo por pessoa
        fun custoPorPessoa(custoViagem: Double, quantPessoas: Double): Double{
            val result: Double = custoViagem / quantPessoas
            return result
        }

        //calculo autonomia
        fun autonomia(consumo: Double, combustivel: Double): Double{
            val result = consumo * combustivel
            return result
        }

    //convertendo de string para Float
    fun convertDouble(string: String): Double{
        val result = string.toDouble()
        return result
    }
    //mansagem de erro.
    fun showmessege(view: View, mensagem:String){
        Snackbar.make(view, mensagem, Snackbar.LENGTH_LONG)
            .setAction("Action", null)
            .show()
    }

    }



