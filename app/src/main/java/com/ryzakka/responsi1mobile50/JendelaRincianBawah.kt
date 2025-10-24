package com.ryzakka.responsi1mobile50

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.ryzakka.responsi1mobile50.databinding.JendelarincianpemainBinding

class JendelaRincianBawah : BottomSheetDialogFragment() {

    private var _binding: JendelarincianpemainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = JendelarincianpemainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val player = arguments?.getParcelable<Player>("PLAYER_DATA")

        player?.let {
            binding.tvDetailPlayerName.text = it.name
            binding.tvDetailPlayerDob.text = it.dateOfBirth
            binding.tvDetailPlayerNationality.text = it.nationality
            binding.tvDetailPlayerPosition.text = it.position
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(player: Player): JendelaRincianBawah {
            val fragment = JendelaRincianBawah()
            val args = Bundle()
            args.putParcelable("PLAYER_DATA", player)
            fragment.arguments = args
            return fragment
        }
    }
}
