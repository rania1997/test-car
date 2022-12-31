package com.example.cartest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.cartest.datamodels.Car
import com.example.cartest.restapiservice.ApiService
import com.example.cartest.restapiservice.CarService
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CarActivity : AppCompatActivity() {

//    private var kilometrageEditText: EditText? = null
   // private var submitButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car)


        val marqueText = findViewById<EditText>(R.id.marque)
        val MiseEnCirculationText = findViewById<EditText>(R.id.miseEnCirculation)
        val kilometrageText = findViewById<EditText>(R.id.kilometrage)


//        kilometrageEditText = findViewById(R.id.kilometrageEditText)
//        submitButton = findViewById(R.id.afficherButton)

//        submitButton!!.setOnClickListener {
//            val intent = Intent(this@CarActivity, NotesVoitureActivity::class.java)
//            intent.putExtra("km", kilometrageEditText!!.text.toString().toInt())
//            startActivity(intent)
//        }
        val afficherButton = findViewById<Button>(R.id.afficherButton)
        afficherButton!!.setOnClickListener {
            startActivity(Intent(this@CarActivity, TestCarActivity::class.java))
        }
        val nexButton = findViewById<Button>(R.id.buttonnext)
        nexButton!!.setOnClickListener {
            startActivity(Intent(this@CarActivity, MapActivity::class.java))
        }

        val addeButton = findViewById<Button>(R.id.addbutton)

        addeButton.setOnClickListener {
            val car = Car(
                id = null,
                marque = marqueText.text.toString(),
                miseEnCirculation = MiseEnCirculationText.text.toString(),
                kilometrage = kilometrageText.text.toString()

            )
            System.out.println(car)
            addCar(car)
        }
}

fun addCar(car: Car) {
        ApiService.carService.register(
            CarService.addBody(
                car.marque!!,
                car.miseEnCirculation!!,
                car.kilometrage!!,


            )
        ).enqueue(
            object : Callback<CarService.MessageResponse> {
                override fun onResponse(
                    call: Call<CarService.MessageResponse>,
                    response: Response<CarService.MessageResponse>
                ) {
                    if (response.code() == 200) {
                        finish()
                        val intent =
                            Intent(this@CarActivity, TestCarActivity::class.java)
                        startActivity(intent)
                    } else {
                        MakeAlert().makeAlert(this@CarActivity, "Warning", "Please verify the informations")

                        println("status code is " + response.code())
                    }
                }

                override fun onFailure(
                    call: Call<CarService.MessageResponse>,
                    t: Throwable
                ) {
                    println("HTTP ERROR")
                    t.printStackTrace()
                }
            }
        )
    }


}