package com.if4a.footballplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TambahActivity extends AppCompatActivity {

    private EditText etNama, etKlub, etNomor;
    private Button btnTambah;
    MyDatabaseHelper myDB = new MyDatabaseHelper(TambahActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        etNama = findViewById(R.id.et_nama);
        etKlub = findViewById(R.id.et_klub);
        etNomor = findViewById(R.id.et_nomor);
        btnTambah = findViewById(R.id.btn_tambah);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama, nomor, klub;

                nama = etNama.getText().toString();
                nomor = etNomor.getText().toString();
                klub = etKlub.getText().toString();

                if(nama.trim().equalsIgnoreCase("")){
                    etNama.setError("Nama Tidak Boleh Kosong");
                } else if(nomor.trim().equalsIgnoreCase("")){
                    etNomor.setError("Nomor Punggung Tidak Boleh Kosong");
                } else if(klub.trim().equalsIgnoreCase("")){
                    etKlub.setError("Klub Tidak Boleh Kosong");
                } else {
                    long eks = myDB.tambahPlayer(nama, nomor, klub);
                    if(eks == -1){
                        Toast.makeText(TambahActivity.this, "Gagal Menambah Data", Toast.LENGTH_SHORT).show();
                        etNama.requestFocus();
                    }
                    else {
                        Toast.makeText(TambahActivity.this, "Berhasil Menambah Data", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }

            }
        });

    }
}