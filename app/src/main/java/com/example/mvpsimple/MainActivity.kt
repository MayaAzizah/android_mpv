package com.example.mvpsimple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {
    private lateinit var etPanjang: EditText
    private lateinit var etLebar: EditText
    private lateinit var btnHitungLuas: Button
    private lateinit var btnHitungKeliling: Button
    private lateinit var tvHasil: TextView
    private lateinit var mainPresenter: MainPresenter
    private lateinit var etSisi: EditText
    private lateinit var btnHitungLuasPersegi : Button
    private lateinit var btnHitungKelilingPersegi : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainPresenter = MainPresenter(this)
        etPanjang = findViewById(R.id.et_panjang)
        etLebar = findViewById(R.id.et_lebar)
        btnHitungLuas = findViewById(R.id.btn_hitung_luas)
        btnHitungKeliling = findViewById(R.id.btn_hitung_keliling)
        tvHasil = findViewById(R.id.tv_hasil)
        etSisi = findViewById(R.id.et_sisi)
        btnHitungLuasPersegi = findViewById(R.id.btn_hitung_luaspersegi)
        btnHitungKelilingPersegi = findViewById(R.id.btn_hitung_kelilingpersegi)

        btnHitungLuas.setOnClickListener{
            val panjang = etPanjang.text.toString().toFloat()
            val lebar = etLebar.text.toString().toFloat()
            mainPresenter.hitungLuasPersegiPjg(panjang, lebar)
        }

        btnHitungKeliling.setOnClickListener{
            val panjang = etPanjang.text.toString().toFloat()
            val lebar = etLebar.text.toString().toFloat()
            mainPresenter.hitungKelilingPersegiPjg(panjang, lebar)
        }

        btnHitungLuasPersegi.setOnClickListener {
            val sisi = etSisi.text.toString().toFloat()
            mainPresenter.hitungLuasPersegi(sisi)
        }

        btnHitungKelilingPersegi.setOnClickListener {
            val sisi = etSisi.text.toString().toFloat()
            mainPresenter.hitungKelilingPersegi(sisi)
        }
    }

    override fun updateLuas(luas: Float){
        tvHasil.text = luas.toString()
    }

    override fun updateKeliling(keliling: Float){
        tvHasil.text = keliling.toString()
    }

    override fun updateLuasP(luaspersegi: Float) {
       tvHasil.text=luaspersegi.toString()
    }

    override fun updateKelilingP(kelilingpersegi: Float) {
        tvHasil.text=kelilingpersegi.toString()

    }

    override fun showError(errorMsg:String) {
        tvHasil.text = errorMsg
    }

}