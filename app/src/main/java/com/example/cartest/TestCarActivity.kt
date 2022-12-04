package com.example.cartest

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cartest.cars.Car
import com.example.cartest.cars.CarAdapter
import com.example.cartest.restapiservice.ApiService
import com.example.cartest.restapiservice.CarService
import com.example.cartest.restapiservice.UserService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TestCarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carlist)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        ApiService.carService.getAll()
            .enqueue(
                object : Callback<CarService.CarsResponse> {
                    override fun onResponse(
                        call: Call<CarService.CarsResponse>,
                        response: Response<CarService.CarsResponse>
                    ) {
                        if (response.code() == 200) {
                            recyclerView.adapter =
                                CarAdapter(baseContext, response.body()?.cars as MutableList<Car>)
                        } else {
                            println("status code is " + response.code())
                        }
                    }

                    override fun onFailure(
                        call: Call<CarService.CarsResponse>,
                        t: Throwable
                    ) {
                        println("HTTP ERROR")
                        t.printStackTrace()
                    }

                }
            )
    }
}