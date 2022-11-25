package com.example.cartest.restapiservice

import android.content.Context
import android.widget.Toast
import com.example.cartest.datamodels.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class RestApiService {
    fun addUser(context: Context ,userData: User, onResult: (User?) -> Unit){
        val retrofit = ServiceBuilder.buildService(RestApi::class.java)
        retrofit.addUser(userData).enqueue(
            object : Callback<User> {
                override fun onFailure(call: Call<User>, t: Throwable) {
                    Toast.makeText(context, "Connexion error! \n"+t.toString(), Toast.LENGTH_SHORT).show()
                    System.out.println("on failure\n"+t.toString())
                }
                override fun onResponse( call: Call<User>, response: Response<User>) {
                    System.out.println(userData)
                    val body = response.body()
                    if(response.code() == 201) {
                        Toast.makeText(context, "User added!", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, "Connexion error!\n"+body, Toast.LENGTH_SHORT).show()
                        System.out.println("on response\n"+body+"\n"+response.code())

                    }
                    onResult(body)
                }
            }
        )
    }
}