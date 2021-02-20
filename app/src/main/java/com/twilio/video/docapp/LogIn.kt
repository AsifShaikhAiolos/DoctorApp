package com.twilio.video.docapp

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.twilio.video.docapp.apiWork.NetworkInterface
import com.twilio.video.docapp.apiWork.RetrofitClient
import com.twilio.video.docapp.apiWork.networkPojo.apimodel.LoginModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

public class LogIn: AppCompatActivity() {
    var txtmail: TextView? = null
    var txtpassword:TextView? = null
    var signUp:TextView? = null
    var btn_login: Button? = null
    var get_mail: String? = null
    var get_passwrod: String? = null

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_login)
        //hooks
        txtmail = findViewById<TextView>(R.id.id_mail)
        txtpassword = findViewById<TextView>(R.id.id_password)
        btn_login = findViewById<Button>(R.id.btn_login)
        signUp = findViewById<TextView>(R.id.signUp) as TextView


        signUp!!.setOnClickListener(View.OnClickListener {
            val i = Intent(this, RegisterActivity::class.java)
            startActivity(i)
        })

        btn_login!!.setOnClickListener(View.OnClickListener {
            get_mail = txtmail!!.text.toString()
            get_passwrod = txtpassword!!.text.toString()
            if (get_mail!!.isEmpty()) {
                Toast.makeText(this, "Pelease enter your userName", Toast.LENGTH_LONG).show()
            } else if (get_passwrod!!.isEmpty()) {
                Toast.makeText(this, "Pelease enter your password", Toast.LENGTH_LONG).show()
            } else {
                checkingLoginDetails()
            }
        })
    }

    private fun checkingLoginDetails() {
        val retrofit = RetrofitClient.getRetrofit()
        val lgApi = retrofit.create(NetworkInterface::class.java)
        val call = lgApi.checkLogin(get_mail, get_passwrod)
        call.enqueue(object : Callback<LoginModel?> {
            override fun onResponse(call: Call<LoginModel?>, response: Response<LoginModel?>) {
                if (response.isSuccessful) {
                    Toast.makeText(this@LogIn, response.body()!!.message, Toast.LENGTH_LONG).show()
                    if (response.body() != null) {
                        SPManager.getInstance().accessToken = response.body()!!.data
                        val intent = Intent(this@LogIn, HomeActivity::class.java)
                        startActivity(intent)
                        finish()
                        Log.e("errorchecking", response.body().toString())
                    }
                } else {
                    Toast.makeText(this@LogIn, "User Not Exits", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<LoginModel?>, t: Throwable) {
                Toast.makeText(this@LogIn, t.toString(), Toast.LENGTH_LONG).show()
            }
        })
    }
}