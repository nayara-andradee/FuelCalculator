package com.example.fuelcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.replace
import androidx.fragment.app.commit
import com.example.fuelcalculator.presentation.DistanceFragment
import com.example.fuelcalculator.presentation.FuelCalculatorViewModel
import com.example.fuelcalculator.presentation.TravelCostFragment

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragmentTravelcost = TravelCostFragment.newInstance()
        val distanceFragment = DistanceFragment.newInstance()

        supportFragmentManager.commit {
            replace(R.id.fragment_container_view,fragmentTravelcost)
            setReorderingAllowed(true)
        }

   }

}