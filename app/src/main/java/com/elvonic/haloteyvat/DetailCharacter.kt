package com.elvonic.haloteyvat

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class DetailCharacter : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_character)


        //enable back button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val imgCard: ImageView = findViewById(R.id.img_character_card)
        val tvName: TextView = findViewById(R.id.tv_card_name)
        val tvSex: TextView = findViewById(R.id.tv_card_sex)
        val tvNation: TextView = findViewById(R.id.tv_card_nation)
        val tvBirthday: TextView = findViewById(R.id.tv_card_birthday)
        val imgRarity: ImageView = findViewById(R.id.img_detail_character_rarity)
        val imgElement: ImageView = findViewById(R.id.img_character_element)
        val tvElement: TextView = findViewById(R.id.tv_character_element)
        val imgWeapon: ImageView = findViewById(R.id.img_character_weapon)
        val tvWeapon: TextView = findViewById(R.id.tv_character_weapon)
        val imgTalent: ImageView = findViewById(R.id.img_item_talent)
        val tvTalent: TextView = findViewById(R.id.tv_item_talent)
        val imgItemBoss: ImageView = findViewById(R.id.img_item_boss)
        val tvItemBoss: TextView = findViewById(R.id.tv_item_boss)
        val imgAscension: ImageView = findViewById(R.id.img_item_ascension)
        val tvAscension: TextView = findViewById(R.id.tv_item_ascension)
        val tvDetail: TextView = findViewById(R.id.tv_detail)

        // menerima data terkirim
        val char = intent.getSerializableExtra(EXTRA_CHARACTER) as Character
        val title = char.name
        setActionBarTitle(title)


        tvName.text = char.name
        imgCard.setImageResource(char.cardPhoto)
        tvSex.text = char.sex
        tvNation.text = char.nation
        tvBirthday.text = char.birthday
        imgRarity.setImageResource(char.rarity)
        imgElement.setImageResource(char.elementImage)
        tvElement.text = char.elementText
        imgWeapon.setImageResource(char.weaponImage)
        tvWeapon.text = char.weaponText
        imgTalent.setImageResource(char.itemTalent)
        tvTalent.text = char.itemTalentText
        imgItemBoss.setImageResource(char.itemBossMaterial)
        tvItemBoss.text = char.itemBossMaterialText
        imgAscension.setImageResource(char.itemAscension)
        tvAscension.text = char.itemAscensionText
        tvDetail.text = char.detail


        val btnFavorite: Button = findViewById(R.id.btn_detail_favorite)
        btnFavorite.setOnClickListener{
            Toast.makeText(it.context, "Favorite", Toast.LENGTH_LONG).show()
        }

        val btnShare: Button = findViewById(R.id.btn_detail_share)
        btnShare.setOnClickListener{
            val shareIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, """
                    Name: ${char.name}
                    Sex: ${char.sex}
                    Nation: ${char.nation}
                    Birthday: ${char.birthday}
                    Element: ${char.elementText}
                    Weapon: ${char.weaponText}
                    
                    Detail
                    ${char.detail}
                """.trimIndent())
                type = "text/plain"
            }

            startActivity(Intent.createChooser(shareIntent, null))

        }
    }

    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }

    companion object {
        const val EXTRA_CHARACTER = "extra_character"
    }
}