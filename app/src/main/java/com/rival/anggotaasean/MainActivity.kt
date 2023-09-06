package com.rival.anggotaasean

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rival.anggotaasean.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private val list = ArrayList<dataCountries>()
    private lateinit var binding: ActivityMainBinding
    private lateinit var rvCountries: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        installSplashScreen()
        setContentView(binding.root)

        rvCountries = binding.rvCountries
        rvCountries.setHasFixedSize(true)

        list.addAll(getListCountries())

        showRecyclerList()

    }

    private fun showRecyclerList() {
        // Memeriksa apakah aplikasi berjalan dalam mode landscape
        val isLandscape = resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

        // Menentukan layout manager berdasarkan orientasi
        if (isLandscape) {
            rvCountries.layoutManager = GridLayoutManager(this, 2)
        } else {
            rvCountries.layoutManager = LinearLayoutManager(this)
        }

        // Membuat dan mengatur adapter untuk RecyclerView
        val listCountriesAdapter = ListCountriesAdapter(list){ onClicked ->
            val intentToDetail = Intent(this@MainActivity, DetailCountry::class.java)
            intentToDetail.putExtra("DATA", onClicked)
            startActivity(intentToDetail)
        }
        rvCountries.adapter = listCountriesAdapter
    }

    private fun getListCountries(): ArrayList<dataCountries> {

        val namaNegara = resources.getStringArray(R.array.data_nama_negara)
        val namaPersiden = resources.getStringArray(R.array.data_name)
        val status = resources.getStringArray(R.array.data_description)
        val mataUang = resources.getStringArray(R.array.data_mata_uang)
        val bahasa = resources.getStringArray(R.array.data_bahasa)
        val photo = resources.obtainTypedArray(R.array.data_name_photo)
        val hariKemerdekaan = resources.getStringArray(R.array.data_hari_kemerdekaan)
        val kepalaNegara = resources.getStringArray(R.array.data_kepala_negara)
        val kepalaPemerintahan = resources.getStringArray(R.array.data_kepala_pemerintahan)
        val ibukota = resources.getStringArray(R.array.data_ibuKota)
        val populasi = resources.getStringArray(R.array.data_populasi)
        val gdp = resources.getStringArray(R.array.data_gdp)
        val gdpKapita = resources.getStringArray(R.array.data_gdp_kapita)
        val luasWilayah = resources.getStringArray(R.array.data_luas_wilayah)

        val listCountry = ArrayList<dataCountries>()

        for (i in namaNegara.indices) {
            val country = dataCountries(
                namaPersiden[i],
                status[i],
                namaNegara[i],
                kepalaNegara[i],
                kepalaPemerintahan[i],
                ibukota[i],
                hariKemerdekaan[i],
                bahasa[i],
                mataUang[i],
                populasi[i],
                gdp[i],
                gdpKapita[i],
                luasWilayah[i],
                photo.getResourceId(i, -1)
            )
            listCountry.addAll(listOf(country))
        }

        return listCountry
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.about_page){
            val intent = Intent(this@MainActivity, About::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }

}