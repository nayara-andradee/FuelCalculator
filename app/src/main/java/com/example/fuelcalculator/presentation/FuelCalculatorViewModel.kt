package com.example.fuelcalculator.presentation

import androidx.lifecycle.ViewModel

class FuelCalculatorViewModel: ViewModel(){
    //criando o ViewModel
    companion object{
        fun creat (): FuelCalculatorViewModel{
            return FuelCalculatorViewModel()
        }

        //  calculo do sua viagem requer
        fun calcLitrosPorViagem(distancia: Int, medconsumo: Int): Int{
            val result: Int = distancia / medconsumo
            return result
        }

        // calculo custo viagem
        fun calcCustoViagem(quantLitros: Int, valor: Float): Float{
            val result: Float = quantLitros * valor
            return result
        }

        //calculo custo por pessoa
        fun custoPorPessoa(custoViagem: Float, quantPessoas: Int): Float{
            val result: Float = custoViagem / quantPessoas
            return result
        }

        //calculo autonomia
        fun autonomia(litrosPorViagem: Int, consumo: Int): Int{
            val result = litrosPorViagem * consumo
            return result
        }

    }



}