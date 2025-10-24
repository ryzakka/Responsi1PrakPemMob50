package com.ryzakka.responsi1mobile50

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.ryzakka.responsi1mobile50.databinding.ActivityHistoryBinding

class HistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbarHistory.setNavigationOnClickListener {
            finish()
        }

        val clubName = intent.getStringExtra("CLUB_NAME")

        binding.tvHistoryTitle.text = "${clubName ?: "Club"}'s History"

        Glide.with(this)
            .load(R.drawable.historyimage2)
            .load(R.drawable.historyimage3)
            .load(R.drawable.historyimage4)
            .load(R.drawable.historyimage1)
            .into(binding.ivHistoryHeader)
    }
}
    