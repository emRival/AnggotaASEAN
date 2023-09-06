package com.rival.anggotaasean

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rival.anggotaasean.databinding.ItemRowCountryBinding

class ListCountriesAdapter(
    private val listCountry: ArrayList<dataCountries>,
    private val onClick: (dataCountries) -> Unit) :
    RecyclerView.Adapter<ListCountriesAdapter.ListViewHolder>() {

  inner class ListViewHolder(var binding: ItemRowCountryBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(country: dataCountries){

            Glide.with(itemView.context)
                .load(country.image)
                .into(binding.imgPhotoPresiden)
            binding.tvNegara.text = country.namaNegara
            binding.tvNamePresiden.text = country.name
            binding.tvStatus.text = country.description
            binding.tvMataUang.text = country.mataUang
            binding.tvNamaBahasa.text = country.bahasa

            binding.root.setOnClickListener {
                onClick(country)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding =
            ItemRowCountryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listCountry.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val country = listCountry[position]

        holder.bind(country)
    }


}