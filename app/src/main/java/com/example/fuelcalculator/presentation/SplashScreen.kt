package com.example.fuelcalculator.presentation

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.fuelcalculator.MainActivity
import com.example.fuelcalculator.R

class SplashScreen: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.splash_screen)
        Handler().postDelayed({
            // Finaliza a exibição da tela de Splash
            finish()

            // Inicia a Activity de Login
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000 )
    }

}