package com.example.fuelcalculator

import java.io.Serializable

class Resultado(val totallitros: Double, val totalkm: Double, val custviagem:Double, val custopessoa:Double): Serializable

class ResultadoDistance(val autonomia:Double, val precoTotalCombustivel:Double ):Serializable