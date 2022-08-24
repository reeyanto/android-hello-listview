package com.example.hellolistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static String[] nama = {"Hinata Hyuga", "Aburame Shino", "Konohamaru", "Sakura Haruno", "Sasuke Uchiha", "Naruto Uzumaki"};
    private static String[] deskripsi = {
            "Ia memiliki Byakugan, dan kemampuannya ketika menggunakan Byakugan itu sangatlah mengerikan",
            "Kemampuannya untuk mengeluarkan ribuan serangga dari tubuhnya sangatlah mengerikan dan dianggap sangat kuat",
            "Konohamaru adalah cucu dari Hokage ketiga, Hiruzen Sarutobi, yang kini telah menjadi salah satu Shinobi terkuat di Konoha",
            "Sebagai penerus Tsunade, Sakura adalah salah satu Kunoichi (ninja cewek) terkuat yang ada di Konoha saat ini",
            "Sasuke dianggap sebagai satu-satunya ninja yang dapat menandingi Naruto dalam sebuah pertandingan",
            "ialah ninja terkuat di Konoha! Ia memiliki kekuatan chakra Kyubi dan memiliki kekuatan dari Hagoromo"
    };
    private static int[] gambar = {
          R.drawable.hinata,
          R.drawable.shino,
          R.drawable.konohamaru,
          R.drawable.sakura,
          R.drawable.sasuke,
          R.drawable.naruto
    };

    private ArrayList<Shinobi> shinobiList;
    private ListView listView;
    private ShinobiAdapter shinobiAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shinobiAdapter = new ShinobiAdapter(this);
        listView = findViewById(R.id.lv_listview);
        listView.setAdapter(shinobiAdapter);

        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            Toast.makeText(this, nama[i], Toast.LENGTH_SHORT).show();
        });

        ambilDataShinobi();
    }

    private void ambilDataShinobi() {
        shinobiList = new ArrayList<>();

        for (int i = 0; i < nama.length; i++) {
            Shinobi shinobi = new Shinobi();
            shinobi.setNama(nama[i]);
            shinobi.setDeskripsi(deskripsi[i]);
            shinobi.setGambar(gambar[i]);

            shinobiList.add(shinobi);
        }
        shinobiAdapter.setShinobis(shinobiList);
    }
}