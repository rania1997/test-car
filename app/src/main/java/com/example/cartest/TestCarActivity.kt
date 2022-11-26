package com.example.cartest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cartest.cars.Car
import com.example.cartest.cars.CarAdapter

class TestCarActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carlist)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerview)
        val cars = listOf(
            Car("Marque 1", "Model 1", "MEC 1", "10"),
            Car("Marque 2", "Model 2", "MEC 2", "20"),
            Car("Marque 3", "Model 3", "MEC 3", "30"),
            Car("Marque 4", "Model 4", "MEC 4", "40"),
        )

        recyclerView.adapter = CarAdapter(this, cars)
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }
}