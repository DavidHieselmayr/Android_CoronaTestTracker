package at.htl.leonding.coronatesttracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import at.htl.leonding.coronatesttracker.databinding.FragmentReportListBinding

/**
 * A simple [Fragment] subclass.
 * Use the [ReportList.newInstance] factory method to
 * create an instance of this fragment.
 */
class ReportList : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentReportListBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_report_list, container, false
        )
        binding.homeBtn.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_reportList_to_welcomeFragment)
        }


        binding.btNewReport.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_reportList_to_newReport)
        }

        return binding.root
    }


}