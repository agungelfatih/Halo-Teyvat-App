package com.elvonic.haloteyvat

import java.io.Serializable

data class Character(
    val uid: Int = 0,
    var name: String = "",
    var detail: String = "",
    var photo: Int = 0,
    var rarity: Int = 0,
    var elementImage: Int = 0,
    var elementText: String = "",
    var weaponImage: Int = 0,
    var weaponText:String = "",
    var cardPhoto: Int = 0,
    var sex: String = "",
    var nation: String = "",
    var birthday: String = "",
    var itemTalent: Int = 0,
    var itemTalentText: String = "",
    var itemAscension: Int = 0,
    var itemAscensionText: String = "",
    var itemBossMaterial: Int = 0,
    var itemBossMaterialText: String = ""
) : Serializable {

}

