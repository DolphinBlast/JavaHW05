package com.dolphinblast.lab4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    private lateinit var setDrink: EditText
    private lateinit var rg1: RadioGroup
    private lateinit var rg2: RadioGroup
    private lateinit var buSend: Button

    private var sugar: String = "無糖"
    private var iceOpt: String = "去冰"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        rg1 = findViewById(R.id.radioGroup1)
        rg1.setOnCheckedChangeListener { _, i ->
            sugar = when (i) {
                R.id.radoiButton1 -> "無糖"
                R.id.radoiButton2 -> "少糖"
                R.id.radoiButton3 -> "半糖"
                R.id.radoiButton4 -> "全糖"
                else -> sugar
            }
        }

        rg2 = findViewById(R.id.radioGroup2)
        rg2.setOnCheckedChangeListener { _, i ->
            iceOpt = when (i) {
                R.id.radoiButton5 -> "去冰"
                R.id.radoiButton6 -> "微冰"
                R.id.radoiButton7 -> "少冰"
                R.id.radoiButton8 -> "正常冰"
                else -> iceOpt
            }
        }

        buSend = findViewById(R.id.bu_send)
        buSend.setOnClickListener {
            setDrink = findViewById(R.id.ed_drink)
            val drink = setDrink.text.toString()
            val intent = Intent().apply {
                putExtras(Bundle().apply {
                    putString("drink", drink)
                    putString("sugar", sugar)
                    putString("ice", iceOpt)
                })
            }
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}