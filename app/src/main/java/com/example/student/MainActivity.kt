package com.example.student

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.*
import com.example.student.ApIinterface.ApIClient
import com.example.student.databinding.ActivityMainBinding
import com.example.student.models.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.PasswordAuthentication
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupSpinner()
        clickReigister()



    }
    fun setupSpinner() {

        val nationality = arrayOf("select nationality", "kenya", "south sudanese", "uganda")
        val adapter =
            ArrayAdapter<String>(baseContext, android.R.layout.simple_spinner_item, nationality)
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        binding.spNationality.adapter =spNationalityadpter
    }
    fun clickReigister(){
        var error=false
        binding.btnregistration.setOnClickListener{
            var name=binding.etnameLbl.text.toString()
            if (name.isEmpty()) {
                error = true
                binding.etnameLbl.setError("this field required")
            }
            var dob=binding.etDate.text.toString()
            if (dob.isEmpty()) {
                error = true
                binding.etDate.setError("field required")
            }
            var nationality=""
            if (binding.spNationality.selectedItemPosition!=0){
          binding.pdregistration.setOnClickListener {
              var phone = binding.etphoneNumber.text.toString()
              var email = binding.etEmail.text.toString()
              var password = binding.tvpasswordLbl.text.toString()
          }
            if (!error){
                binding.pdregistration.visibility=View.VISIBLE
                var registrationRequest=RegistrationRequest(
                    name=name,
//                     phoneNumber =phonenumber,
//                    email =email,
                    dateOfbirth = dob,
                    nationality = nationality,
                    password =password,
                )
                var retrofit=ApIClient.buildService(ApIClient::class.java)
                var request=retrofit.registerStudent(registrationRequest)
                request.enqueve(object : Callback<RegistrationRespones> {
                    override fun onResponse(
                        call: Call<RegistrationRespones>,
                        response: Response<RegistrationRespones>
                    ) {
                        binding.pdregistration.visibility = View.GONE
                        if (response.isSuccessful)
                            Toast.makeText(baseContext, "Registration Succesful", Toast.LENGTH_LONG)
                                .show()
                    }
                    else

                }
                        Toast.makeText(baseContext,Response.errorBody()?.String(), Toast.LENGTH_LONG).show()
                        binding.pdregistration.visibility = View.GONE

            }
            }
                    override fun onFailure(call: Call<RegistrationRespones>, t: Throwable) {
                        Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                        binding.pdregistration.visibility = View.GONE

                    }


                }
        }}






