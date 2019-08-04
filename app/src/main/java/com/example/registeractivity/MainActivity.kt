package com.example.registeractivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var nama1:EditText?=null
    var gender1:Spinner?=null
    var email1:EditText?=null
    var telepon1:EditText?=null
    var alamat1:EditText?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nama1=findViewById(R.id.nama)
        gender1=findViewById(R.id.gender)
        email1=findViewById(R.id.email)
        telepon1=findViewById(R.id.telepon)
        alamat1=findViewById(R.id.alamat)
        buttonsave.setOnClickListener{
            validasiInput()
        }
        setDataSpinner()
    }
    fun setDataSpinner(){
        val adapter=ArrayAdapter.createFromResource(this,R.array.genderlist, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        gender?.adapter=adapter
    }
    fun validasiInput() {
        val namaInput = nama1?.text.toString()
        val emailInput = email1?.text.toString()
        val teleponInput = telepon1?.text.toString()
        val alamatInput = alamat1?.text.toString()
        val genderInput = gender1?.selectedItem.toString()
        when{
            genderInput.equals("pilih jenis kelamin") ->
                Toast.makeText(this,"kelamin anda mana?",Toast.LENGTH_SHORT).show()
            namaInput.isEmpty()->nama1?.error="diisilah "
            namaInput.isEmpty()->email1?.error="diisilah "
            namaInput.isEmpty()->telepon1?.error="diisilah "
            namaInput.isEmpty()->alamat1?.error="diisilah "

        else->{
            Toast.makeText(this,"data terkirim",Toast.LENGTH_SHORT).show()
        }
        }
    }

}

