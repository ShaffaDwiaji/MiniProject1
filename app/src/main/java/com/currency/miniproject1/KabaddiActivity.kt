package com.currency.miniproject1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class KabaddiActivity : AppCompatActivity() {

    // Deklarasi + Inisialisasi
//    var scoreA : Int = 0
//    var scoreB : Int = 0

    // Deklarasi pakai lateinit
    private lateinit var skorA: TextView
    private lateinit var skorB: TextView

    //Menggunakan ViewModel (Deklarasi + Inisialisasi)
    val viewModel: ScoreViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_kabaddi)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Deklasrasi + Inisialisasi
        val buttonPlus1A = findViewById<Button>(R.id.tambah1a)
        val buttonPlus2A = findViewById<Button>(R.id.tambah2a)
        val buttonPlus1B = findViewById<Button>(R.id.tambah1b)
        val buttonPlus2B = findViewById<Button>(R.id.tambah2b)
        val buttonReset = findViewById<Button>(R.id.btnreset)

        // Inisialisasi
        skorA = findViewById(R.id.skorA)
        skorB = findViewById(R.id.skorB)

        skorA.text = viewModel.scoreA.toString()
        skorB.text = viewModel.scoreB.toString()

        buttonPlus1A.setOnClickListener {
            incrementSkorA()
        }

        buttonPlus2A.setOnClickListener {
            incrementSkorA()
            incrementSkorA()
        }

        buttonPlus1B.setOnClickListener {
            incrementSkorB()
        }

        buttonPlus2B.setOnClickListener {
            incrementSkorB()
            incrementSkorB()
        }

        buttonReset.setOnClickListener {
            resetSkor()
        }

    }

    private fun resetSkor() {
        viewModel.resetSkor()
        skorA.text = viewModel.scoreA.toString()
        skorB.text = viewModel.scoreB.toString()
//        scoreA = 0
//        scoreB = 0
//        skorA.text = scoreA.toString()
//        skorB.text = scoreB.toString()
    }
    fun incrementSkorA() {
//        scoreA++
        viewModel.incrementSkorA()
        skorA.text = viewModel.scoreA.toString()
    }

    fun incrementSkorB() {
//        scoreB++
        viewModel.incrementSkorB()
        skorB.text = viewModel.scoreB.toString()

    }
}