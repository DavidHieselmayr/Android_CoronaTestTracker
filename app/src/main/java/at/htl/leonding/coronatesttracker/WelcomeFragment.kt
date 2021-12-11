package at.htl.leonding.coronatesttracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import at.htl.leonding.coronatesttracker.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentWelcomeBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_welcome, container, false
        )

        binding.createNewReport.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_welcomeFragment_to_newReport)
        }

        binding.viewReportList.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_welcomeFragment_to_reportList)
        }
        return binding.root
    }
}