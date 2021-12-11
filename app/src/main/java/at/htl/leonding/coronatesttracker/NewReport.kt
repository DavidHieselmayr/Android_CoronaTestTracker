package at.htl.leonding.coronatesttracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import at.htl.leonding.coronatesttracker.databinding.FragmentNewReportBinding
import at.htl.leonding.coronatesttracker.databinding.FragmentWelcomeBinding

/**
 * A simple [Fragment] subclass.
 * Use the [NewReport.newInstance] factory method to
 * create an instance of this fragment.
 */
class NewReport : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentNewReportBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_new_report, container, false
        )

        val offices = resources.getStringArray(R.array.offices)
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, offices)
        binding.autoCompleteTextView.setAdapter(arrayAdapter)

        binding.btSave.setOnClickListener{
            view -> view.findNavController().navigate(R.id.action_newReport_to_reportList)
        }

        return binding.root;

    }


}