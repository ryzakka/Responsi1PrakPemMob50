package com.ryzakka.responsi1mobile50

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.ryzakka.responsi1mobile50.databinding.ActivityPelatihBinding

class PelatihActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPelatihBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPelatihBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val coachData = intent.getParcelableExtra<Coach>("COACH_DATA")

        if (coachData != null) {
            binding.tvCoachName.text = coachData.name
            binding.tvCoachDob.text = coachData.dateOfBirth
            binding.tvCoachNationality.text = coachData.nationality

            Glide.with(this)
                .load(R.drawable.coachimage)
                .into(binding.ivCoachPhoto)
        }
    }
}
    