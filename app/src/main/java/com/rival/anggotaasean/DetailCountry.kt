package com.rival.anggotaasean

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import com.bumptech.glide.Glide
import com.rival.anggotaasean.databinding.ActivityDetailCountryBinding

class DetailCountry : AppCompatActivity() {

    lateinit var binding: ActivityDetailCountryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetailCountryBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        // showing the back button in action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        var  data = intent.getParcelableExtra<dataCountries>("DATA")

        Glide.with(this@DetailCountry)
            .load(data?.image)
            .into(binding.profileImage)

        binding.tvNamaPresiden.text = data?.name
        binding.tvStatus.text = data?.description
        binding.tvNamaNegara.text = data?.namaNegara
        binding.tvKepalaNegara.text = data?.kepalaNegara
        binding.tvKepalaPemerintahan.text = data?.kepalaPemerintahan
        binding.tvIbukota.text = data?.ibukota
        binding.tvHariKemerdekaan.text = data?.hariKemerdekaan
        binding.tvBahasa.text = data?.bahasa
        binding.tvMataUang.text = data?.mataUang
        binding.tvPopulasi.text = data?.populasi
        binding.tvGdp.text = data?.gdp
        binding.tvGdpPerkapita.text = data?.gdpKapita
        binding.tvLuasWilayah.text = data?.luasWilayah

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when(item.itemId){
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }
}