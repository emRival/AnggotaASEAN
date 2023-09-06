package com.rival.anggotaasean

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.rival.anggotaasean.databinding.ActivityAboutBinding

class About : AppCompatActivity() {

    lateinit var binding: ActivityAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val name = "Muhammad Rival"
        val email = "em.rival282@gmail.com"
        binding.myName.text = name

        binding.email.text = email

        binding.email.setOnClickListener {
            val implicitIntent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:$email"))
            startActivity(implicitIntent)
        }
        val photo = binding.profileImage

        Glide.with(this)
            .load(R.drawable.my_foto)
            .into(photo)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item?.itemId){
            android.R.id.home -> {
                finish()
                true
            } else -> super.onOptionsItemSelected(item)
        }

    }
}