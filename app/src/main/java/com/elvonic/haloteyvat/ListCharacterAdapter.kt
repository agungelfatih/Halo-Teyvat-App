package com.elvonic.haloteyvat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListCharacterAdapter(private val listCharacter : ArrayList<Character>) :RecyclerView.Adapter<ListCharacterAdapter.ListViewHolder>() {
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var tvName: TextView = itemView.findViewById(R.id.tv_character_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_character_detail)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_character_photo)
        var imgRarity: ImageView = itemView.findViewById(R.id.img_character_rarity)
        var imgElement: ImageView = itemView.findViewById(R.id.img_character_element)
        var tvElement: TextView = itemView.findViewById(R.id.tv_character_element)
        var imgWeapon: ImageView = itemView.findViewById(R.id.img_character_weapon)
        var tvWeapon: TextView = itemView.findViewById(R.id.tv_character_weapon)

    }

    // ketika item di klik
    private lateinit var onItemClickDetail: OnItemClickDetail

    interface OnItemClickDetail {
        fun onItemClicked(data: Character)
    }

    fun setOnItemClickDetail(onItemClickDetail: OnItemClickDetail) {
        this.onItemClickDetail = onItemClickDetail
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_characters, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val character = listCharacter[position]
        holder.tvName.text = character.name
        holder.tvDetail.text = character.detail
        Glide.with(holder.itemView.context)
            .load(character.photo)
            .apply(RequestOptions().override(70,70))
            .into(holder.imgPhoto)

        Glide.with(holder.itemView.context)
            .load(character.rarity)
            .into(holder.imgRarity)

        Glide.with(holder.itemView.context)
            .load(character.elementImage)
            .into(holder.imgElement)

        holder.tvElement.text = character.elementText

        Glide.with(holder.itemView.context)
            .load(character.weaponImage)
            .into(holder.imgWeapon)

        holder.tvWeapon.text = character.weaponText

//        Glide.with(holder.itemView.context)
//            .load(character.cardPhoto)
//            .into(holder.imgCard)
//
//        holder.tvSex.text = character.sex
//        holder.tvNation.text = character.nation
//        holder.tvBirthday.text = character.birthday
//
//        Glide.with(holder.itemView.context)
//            .load(character.itemTalent)
//            .into(holder.imgTalent)
//
//        holder.tvTalent.text = character.itemTalentText
//
//        Glide.with(holder.itemView.context)
//            .load(character.itemAscension)
//            .into(holder.imgAscension)
//
//        holder.tvAscension.text = character.itemAscensionText
//
//        Glide.with(holder.itemView.context)
//            .load(character.itemBossMaterial)
//            .into(holder.imgBossMaterial)
//
//        holder.tvBossMaterial.text = character.itemBossMaterialText

        holder.itemView.setOnClickListener {
            onItemClickDetail.onItemClicked(character)
        }
    }

    override fun getItemCount(): Int {
        return listCharacter.size
    }
}