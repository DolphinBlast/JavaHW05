package com.dolphinblast.lab4

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var tvDrink: TextView
    private lateinit var buSelect: Button
    private lateinit var mStartForResult: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvDrink = findViewById(R.id.tv_drink)
        buSelect = findViewById(R.id.bu_select)
        buSelect.setOnClickListener {
            mStartForResult.launch(Intent(this, MainActivity2::class.java))
        }

        mStartForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val intent = result.data
                intent?.extras?.let { b ->
                    val str1 = b.getString("drink")
                    val str2 = b.getString("sugar")
                    val str3 = b.getString("ice")
                    tvDrink.text = "飲料: $str1\n\n甜度: $str2\n\n冰塊: $str3"
                }
            }
        }
    }
}
