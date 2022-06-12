package com.example.mvpsimple

interface MainView {
    fun updateLuas(luas: Float)
    fun updateKeliling(keliling: Float)
    fun updateLuasP(sisi: Float)
    fun updateKelilingP(sisi: Float)
    fun showError(errorMsg: String)

}