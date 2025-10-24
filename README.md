<b> Proyek Responsi 1 Praktikum Pemrograman Mobile </b><br>
<b> Dhimas Wildan Nur Zakariya - H1D023050 </b><br>
Kelas H ke Kelas C

Tangkapan Layar

![](TangkapanLayar/RekamanLayar1.gif)

<h3>Bagaimana proses data API dari fase pemanggilan dilakukan hingga dapat direpresentasikan pada aplikasi?</h3>

<p>
Pada awalnya, di LamanBeranda.kt, ia akan menjalankan salah satu fungsi yang akan melakukan pemuatan data dari API sesuai yang diminta, lau permintaan tersbeut akan diteruskan melalui layanan API dan Instansi retrofit di latar belakang. Pada titik inilah instansi ini akan melakukan pengambilan data dari konfigurasi alamat API sebelumnya. Pasca proses ini, retrofit akan mencari fungsi-fungsi yang cocok dari layanan API; GET ke titik tim dengan identitas 77. Selama proses ini, dibutuhkan token API yang sudah didapat dari situs terkait.
</p>

<p>
Server API akan merespon permintaan tersebut dan retrofit akan kembali menerima jawaban permintaan di awal. Kemudian, data yang masuk akan dicocokkan dengan TextAPI.kt yang sudah dibuat. Setelah selesai, aplikasi akan kembali ke fungsi pertama, fungsi pemuatan data API, jika data didapati adalah benar, maka aplikasi akan memanggil fungsi setupView selagi membawa objek data tim yang sudah terisi. Setelah semua proses selesai, aplikasi akan merespon interaksi pengguna. seperti ketika pengguna mengetuk tombol pelatih tim atau pemain, ini akan membuat aplikasi melakukan pendeteksian klik dan mulai mengambil data terkait dan memasukkannya melalui intent yang kemudian akan ditampilkan pada laman terkait, misalnya TimActivity.kt. Di laman akhir, intent akan dibuka dan diserahkan pada fungsi SquadAdapter yang akan menampilkan data terkait dalam format daftar berwarna.
</p>

<br>

<pre><code>
Laman Beranda Buka -> Pemuatan data dari API [loadTeamDetailsfromAPI()] -> 
instansi retrofit GET -> verifikasi token -> API menyocokkan permintaan dan 
memberikan data -> periksa benar tidaknya data -> setupview proses data -> 
data dimuat [SELESAI] -> interaksi pengguna (tombol) -> menyocokkan permintaan -> 
data ke intent -> intent ke laman lain -> intent dibuka -> squadAdapter -> data disajikan
</code></pre>
