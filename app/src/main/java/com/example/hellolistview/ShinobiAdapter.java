package com.example.hellolistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ShinobiAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Shinobi> shinobis;

    public ShinobiAdapter(Context context) {
        this.context = context;
        this.shinobis = new ArrayList<>();
    }

    public void setShinobis(ArrayList<Shinobi> shinobis) {
        this.shinobis = shinobis;
    }

    @Override
    public int getCount() {
        return shinobis.size();
    }

    @Override
    public Object getItem(int i) {
        return shinobis.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(view);
        Shinobi shinobi = (Shinobi) getItem(i);
        viewHolder.bind(shinobi);
        return view;
    }

    private class ViewHolder {
        private TextView tv_nama;
        private TextView tv_deskripsi;
        private ImageView iv_gambar;

        public ViewHolder(View view) {
            tv_nama = view.findViewById(R.id.tv_nama);
            tv_deskripsi = view.findViewById(R.id.tv_deskripsi);
            iv_gambar = view.findViewById(R.id.iv_gambar);
        }

        void bind(Shinobi shinobi) {
            tv_nama.setText(shinobi.getNama());
            tv_deskripsi.setText(shinobi.getDeskripsi());
            iv_gambar.setImageResource(shinobi.getGambar());
        }
    }
}
