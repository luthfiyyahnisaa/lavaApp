package com.luthfi.lavaapp.data;

import com.luthfi.lavaapp.R;

public class MateriBinatang {
    public Integer gambar[] = {
            R.drawable.img_harimau,
            R.drawable.img_kuda,
            R.drawable.img_lembu,
            R.drawable.img_monyet,
            R.drawable.img_singa,
    };

    public String nama[] = {
            "Harimau",
            "Kuda",
            "Lembu",
            "Monyet",
            "Singa",
    };

    public String makanan[] = {
            "Daging",
            "Rumput",
            "Rumput",
            "Buah-buahan dan umbi-umbian",
            "Daging",
    };

    public String jenis[] = {
            "Karnivora",
            "Herbivora",
            "Herbivora",
            "Omnivora",
            "Karnivora",
    };

    public String karakteristik[] = {
            "Yang terbesar dari semua kucing",
            "Bentuk perototan sangat padat",
            "memiliki 4 kaki, badannya memanjang dengan leher pendek",
            "berkembangbiak dengan cara Vivipar (melahirkan) Memiliki bulu sebagai penutup tubuh",
            "badan yang besar, kepala besar dan kaki pendek",
    };

    public Integer suara[] = {
            R.raw.harimau,
            R.raw.kuda,
            R.raw.sapi,
            R.raw.monyet,
            R.raw.singa,
    };

    public String deskripsi[] = {
            "Harimau (nama ilmiah: Panthera tigris; disebut juga sebagai macan, meskipun lebih sering digunakan untuk hewan dari spesies Panthera pardus beserta subspesiesnya) adalah hewan yang tergolong dalam filum Chordata, subfilum vertebrata, kelas mamalia, pemakan daging (karnivora), keluarga felidae (kucing), genus panthera, dan tergolong dalam spesies tigris.",
            "Kuda (Equus caballus atau Equus ferus caballus) adalah salah satu dari sepuluh spesies modern mamalia dari genus Equus. Hewan ini telah lama merupakan salah satu hewan peliharaan yang penting secara ekonomis dan historis, dan telah memegang peranan penting dalam pengangkutan orang dan barang selama ribuan tahun.",
            "Sapi adalah hewan ternak anggota suku Bovidae dan anak suku Bovinae. Sapi yang telah dikebiri dan biasanya digunakan untuk membajak sawah dinamakan lembu. Sapi dipelihara terutama untuk dimanfaatkan susu dan dagingnya sebagai pangan manusia.\n",
            "Monyet adalah istilah untuk semua anggota primata yang bukan prosimia (\"pra-kera\", seperti lemur dan tarsius) atau kera, baik yang tinggal di Dunia Lama maupun Dunia Baru. Hingga saat ini dikenal 264 jenis monyet yang hidup di dunia. Tidak seperti kera, monyet biasanya berekor dan berukuran lebih kecil.",
            "Singa (bahasa Sanskerta: Siṃha, atau nama ilmiahnya Panthera leo) adalah spesies hewan dari keluarga felidae atau jenis kucing. Singa merupakan hewan yang hidup berkelompok. Biasanya terdiri dari seekor jantan dan banyak betina. Kelompok ini menjaga daerah kekuasaannya.",
    };

    public Integer getGambar(int x) {
        Integer g = gambar[x];
        return g;
    }

    public String getNama(int x) {
        String n = nama[x];
        return n;
    }

    public String getMakanan(int x) {
        String m = makanan[x];
        return m;
    }


    public String getJenis(int x) {
        String j = jenis[x];
        return j;
    }

    public String getKarakteristik(int x) {
        String k = karakteristik[x];
        return k;
    }

    public Integer getSuara(int x) {
        Integer s = suara[x];
        return s;
    }

    public String getDeskripsi(int x) {
        String d = deskripsi[x];
        return d;
    }
}
