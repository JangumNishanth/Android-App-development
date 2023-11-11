package com.example.snacksquad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.snacksquad.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private val binding: ActivitySignUpBinding by lazy {
        ActivitySignUpBinding.inflate(layoutInflater)
    }
    private lateinit var uname : EditText
    private lateinit var pword : EditText
    private lateinit var cpword : EditText
    private lateinit var signupbutton : Button
    private lateinit var db : DBHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.tValreadyAccount.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        uname = findViewById(R.id.eTName)
        pword = findViewById(R.id.eTMail)
        cpword = findViewById(R.id.eTPass)
        signupbutton = findViewById(R.id.btnSignUp)
        db = DBHelper(this)

        signupbutton.setOnClickListener {
            val unametext = uname.text.toString()
            val pwordtext = pword.text.toString()
            val cpwordtext = cpword.text.toString()
            val savedata = db.insertdata(unametext, pwordtext)

            if(TextUtils.isEmpty(unametext) || TextUtils.isEmpty(pwordtext)){
                Toast.makeText(this,"Enter Username, password and Confirm Password ", Toast.LENGTH_SHORT).show()
            }
            else{
                if(pwordtext.equals(cpwordtext)){
                    if(savedata==true){
                        Toast.makeText(this,"Account Sucessfully created Now you can login", Toast.LENGTH_SHORT).show()
                        val intent = Intent(applicationContext, LoginActivity::class.java)
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(this,"User Already Exists", Toast.LENGTH_SHORT).show()
                    }
                }
                else{
                    Toast.makeText(this,"Passwords are not matched", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}