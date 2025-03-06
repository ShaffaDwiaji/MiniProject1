package com.currency.miniproject1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.currency.miniproject1.databinding.ActivityKabaddiBinding

class KabaddiActivity : AppCompatActivity() {

    // Deklarasi + Inisialisasi
//    var scoreA : Int = 0
//    var scoreB : Int = 0

    // Deklarasi pakai lateinit
    private lateinit var skorA: TextView
    private lateinit var skorB: TextView

    //Menggunakan ViewModel (Deklarasi + Inisialisasi)
    val viewModel: ScoreViewModel by viewModels()

    private lateinit var binding:ActivityKabaddiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_kabaddi)
        binding  = DataBindingUtil.setContentView(this, R.layout.activity_kabaddi)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.kabaddi)) { v, insets ->
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

        binding.skorA.text = viewModel.scoreA.toString()
        binding.skorB.text = viewModel.scoreB.toString()

        binding.tambah1a.setOnClickListener {
            incrementSkorA()
        }

        binding.tambah2a.setOnClickListener {
            incrementSkorA()
            incrementSkorA()
        }

        binding.tambah1b.setOnClickListener {
            incrementSkorB()
        }

        binding.tambah2b.setOnClickListener {
            incrementSkorB()
            incrementSkorB()
        }

        binding.btnreset.setOnClickListener {
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
        binding.skorA.text = viewModel.scoreA.toString()
    }

    fun incrementSkorB() {
//        scoreB++
        viewModel.incrementSkorB()
        binding.skorB.text = viewModel.scoreB.toString()

    }
}