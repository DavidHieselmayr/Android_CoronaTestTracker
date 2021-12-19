package at.htl.leonding.coronatesttracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import at.htl.leonding.coronatesttracker.Model.CoronaReportAppModel
import at.htl.leonding.coronatesttracker.databinding.FragmentWelcomeBinding
import java.time.LocalDate

class WelcomeFragment : Fragment() {
    private val coronaReportAppModel: CoronaReportAppModel by activityViewModels()

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

        binding.btcreateNewReport.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_welcomeFragment_to_newReport)
        }

        binding.btViewReportList.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_welcomeFragment_to_reportList)
        }

        var positive = 0
        var negative = 0
        var linz = 0
        var leonding = 0
        var haid = 0

        var dateNow: LocalDate = LocalDate.now();

        // it.dateAndTime.dayOfMonth == dateNow.dayOfMonth && it.dateAndTime.dayOfMonth == dateNow.dayOfMonth && it.dateAndTime.monthValue == dateNow.monthValue && it.dateAndTime.year == dateNow.year
        coronaReportAppModel.reportList.value?.filter { //TODO only today
            true
        }?.forEach {
            println(it.dateAndTime.monthValue)
            println(dateNow.monthValue)

            if (it.dateAndTime.monthValue == dateNow.monthValue) {
                println("true")
            }
            if (it.isPositive) {
                positive++;
            } else {
                negative++;
            }

            when (it.office) {
                "Linz-Stadtplatz" -> linz++
                "Leonding-Meixnerkreuzung" -> leonding++
                "Parkplatz-Haidcenter" -> haid++
            }
        }

        // binding.progressBar.progress = positive / (positive + negative) * 100;
        binding.progressBar.max = positive + negative;
        binding.progressBar.min = 0
        binding.progressBar.progress = positive;


        binding.tvQuantityLinzStadtplatz.text = linz.toString()
        binding.tvQuantityLeonding.text = leonding.toString()
        binding.tvQuantityHaid.text = haid.toString()
        return binding.root
    }
}