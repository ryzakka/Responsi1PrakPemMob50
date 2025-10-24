package com.ryzakka.responsi1mobile50

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.semantics.error
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.ryzakka.responsi1mobile50.databinding.ActivityLamanBerandaBinding
import kotlinx.coroutines.launch

class LamanBeranda : AppCompatActivity() {

    private lateinit var binding: ActivityLamanBerandaBinding
    //tokenakunsitusinformsiapiboladisini
    private val apiToken = "e73f51f7c199469ea26218624e799a9c"

    private var currentTeamData: TeamResponse? = null
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLamanBerandaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadTeamDetailsFromApi()
        initListeners()
    }

    private fun loadTeamDetailsFromApi() {
        binding.progressBar.visibility = View.VISIBLE
        binding.mainContent.visibility = View.GONE
        Log.d("LamanBeranda_API", "Mulai memuat data dari API...")

        lifecycleScope.launch {
            try {
                val response = RetrofitInstance.api.getTeamDetails(apiToken)
                Log.d("LamanBeranda_API", "Respons diterima, Kode: ${response.code()}")

                if (response.isSuccessful && response.body() != null) {
                    val teamData = response.body()!!
                    currentTeamData = teamData
                    setupViewWithData(teamData)
                } else {
                    Log.e("LamanBeranda_API", "Respons GAGAL: ${response.message()}")
                    setupDefaultView("Gagal memuat data: Error ${response.code()}")
                }
            } catch (e: Exception) {
                Log.e("LamanBeranda_API", "Terjadi Exception: ${e.message}", e)
                setupDefaultView("Gagal memuat data. Periksa koneksi internet Anda.")
            } finally {
                Log.d("LamanBeranda_API", "Proses selesai, menyembunyikan ProgressBar.")
                binding.progressBar.visibility = View.GONE
                binding.mainContent.visibility = View.VISIBLE
            }
        }
    }
    private fun setupViewWithData(data: TeamResponse) {
        binding.tvClubName.text = data.name
        binding.tvClubDescription.text = "Didirikan pada tahun ${data.founded ?: "-"}, bermain di stadion ${data.venue ?: "-"} dengan warna kebanggaan ${data.clubColors ?: "-"}."
        binding.layoutLocation.latar.text = "Club History"
        binding.layoutEmail.latar.text = "Head Coach"
        binding.layoutIg.latar.text = "Team Squad"

        Glide.with(this)
            .load(data.crest)
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_arrow_back)
            .into(binding.ivClubLogo)

        binding.ivHeaderBackground.setImageResource(R.drawable.clubimage1)
        binding.layoutLocation.imgIcon.setImageResource(R.drawable.iconhistory)
        binding.layoutEmail.imgIcon.setImageResource(R.drawable.iconcoach)
        binding.layoutIg.imgIcon.setImageResource(R.drawable.iconteam)
    }
    private fun initListeners() {
        binding.btnBack.setOnClickListener {
            finish()
        }
        binding.layoutLocation.root.setOnClickListener {
            handleMenuClick("HISTORY")
        }
        binding.layoutEmail.root.setOnClickListener {
            handleMenuClick("COACH")
        }
        binding.layoutIg.root.setOnClickListener {
            handleMenuClick("SQUAD")
        }
    }
    private fun handleMenuClick(menuType: String) {
        if (currentTeamData == null) {
            Toast.makeText(this, "Data tim belum selesai dimuat.", Toast.LENGTH_SHORT).show()
            return
        }

        when (menuType) {
            "HISTORY" -> {
                val intent = Intent(this, HistoryActivity::class.java)
                intent.putExtra("CLUB_NAME", currentTeamData!!.name)
                startActivity(intent)
            }
            "COACH" -> {
                currentTeamData?.coach?.let { coach ->
                    val intent = Intent(this, PelatihActivity::class.java)
                    intent.putExtra("COACH_DATA", coach)
                    startActivity(intent)
                } ?: Log.w("LamanBeranda", "Data pelatih tidak tersedia.")
            }
            "SQUAD" -> {
                currentTeamData?.squad?.let { squad ->
                    if (squad.isNotEmpty()) {
                        val intent = Intent(this, TimActivity::class.java)
                        intent.putParcelableArrayListExtra("SQUAD_LIST", ArrayList(squad))
                        startActivity(intent)
                    } else {
                        Log.w("LamanBeranda", "Data skuad kosong.")
                    }
                } ?: Log.w("LamanBeranda", "Data skuad tidak tersedia.")
            }
        }
    }
    private fun setupDefaultView(errorMessage: String) {
        binding.tvClubName.text = "Gagal Memuat"
        binding.tvClubDescription.text = errorMessage
        binding.ivClubLogo.visibility = View.GONE
    }
}
