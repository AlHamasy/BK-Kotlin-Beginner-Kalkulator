package id.asad.kalkulator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    // deklarasi view / widget
    lateinit var edtAwal : EditText
    lateinit var edtAkhir : EditText
    lateinit var btnTambah : Button
    lateinit var btnKurang : Button
    lateinit var btnKali : Button
    lateinit var btnBagi : Button
    lateinit var tvHasil : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // calling id
        edtAwal = findViewById(R.id.edt_awal)
        edtAkhir = findViewById(R.id.edt_akhir)
        btnTambah = findViewById(R.id.btn_tambah)
        btnKurang = findViewById(R.id.btn_kurang)
        btnKali = findViewById(R.id.btn_kali)
        btnBagi = findViewById(R.id.btn_bagi)
        tvHasil = findViewById(R.id.tv_hasil)

        btnKurang.setOnClickListener {
            validasi(edtAwal.text.toString(), edtAkhir.text.toString(), '-')
        }
        btnBagi.setOnClickListener {
            validasi(edtAwal.text.toString(), edtAkhir.text.toString(), '/')
        }
        btnTambah.setOnClickListener {
            validasi(edtAwal.text.toString(), edtAkhir.text.toString(), '+')
        }
        btnKali.setOnClickListener {
            validasi(edtAwal.text.toString(), edtAkhir.text.toString(), '*')
        }

    }

    // function validasi
    fun validasi(awal : String, akhir : String, operator : Char){

        if (awal.isEmpty()){
            edtAwal.error = "awal tidak boleh kosong"
        }
        if (akhir.isEmpty()){
            edtAkhir.error = "akhir tidak boleh kosong"
        }
        if (awal.isNotEmpty() && akhir.isNotEmpty()){
            kalkulasi(awal.toDouble(), akhir.toDouble(), operator)
        }
    }

    // function kalkuasi
    fun kalkulasi(awal : Double, akhir : Double, operator: Char){

        var hasil = 0.0
        when(operator){
            '+' -> hasil = awal + akhir
            '-' -> hasil = awal - akhir
            '*' -> hasil = awal * akhir
            '/' -> hasil = awal / akhir
        }
        tvHasil.text = hasil.toString()
    }

}