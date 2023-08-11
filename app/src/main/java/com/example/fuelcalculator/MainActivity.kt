package com.example.fuelcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.example.fuelcalculator.presentation.DistanceFragment
import com.example.fuelcalculator.presentation.FuelCalculatorViewModel
import com.example.fuelcalculator.presentation.TravelCostFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val gastosFragment = TravelCostFragment.newInstance()
        val distanceFragment = DistanceFragment.newInstance()
        val bottonNavView = findViewById<BottomNavigationView>(R.id.bottonNaigationView)

        supportFragmentManager.commit {
            replace(R.id.fragment_container_view,gastosFragment)
            setReorderingAllowed(true)
        }

        bottonNavView.setOnItemSelectedListener{menuItem ->
            val fragment = when(menuItem.itemId){
                R.id.item_menu_gastos -> gastosFragment
                R.id.item_menu_distancia -> distanceFragment
                else -> gastosFragment
            }
            supportFragmentManager.commit {
                replace(R.id.fragment_container_view,fragment)
                setReorderingAllowed(true)
            }

            true
        }

   }

}