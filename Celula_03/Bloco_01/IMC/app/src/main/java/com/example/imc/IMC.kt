package com.example.imc

import android.os.Parcel
import android.os.Parcelable
import java.math.RoundingMode
import java.text.DecimalFormat


class IMC(var nome: String?, var peso: Float, var altura: Float, var imc: Float) :Parcelable {


    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readFloat(), //imc
        parcel.readFloat(), //peso
        parcel.readFloat() //altura
    ) {
    }

    constructor(name: String, peso: Float, altura: Float) : this(name,peso,altura,0.2f)

    fun calcular() : String{

                val alt = altura/100
                val calc = peso / (alt*alt)
                val msg = when (calc){
                in 0 ..16  -> "Magreza grave"
                in 16 ..17 -> "Magreza moderada"
                in 17 ..19 -> "Magreza leve"
                in 19 ..25 -> "Saúdavel"
                in 25 ..30 -> "Sobrepeso"
                in 30 ..35 -> "Nível I de proteção contra o frio"
                in 35 ..40 -> "Nível II de proteção contra o frio"
                else -> "Nível III ou mais."
            }

        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.CEILING

        imc = df.format(calc).toFloat()
        return msg
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nome)
        parcel.writeFloat(peso)
        parcel.writeFloat(altura)
        parcel.writeFloat(imc)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<IMC> {
        override fun createFromParcel(parcel: Parcel): IMC {
            return IMC(parcel)
        }

        override fun newArray(size: Int): Array<IMC?> {
            return arrayOfNulls(size)
        }
    }


}