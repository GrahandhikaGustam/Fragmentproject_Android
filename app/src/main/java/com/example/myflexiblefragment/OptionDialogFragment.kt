package com.example.myflexiblefragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.fragment_option_dialog.*

class OptionDialogFragment : DialogFragment(), View.OnClickListener {
    private lateinit var btnChoose: Button
    private lateinit var btnClose: Button
    private lateinit var rgOptions : RadioGroup
    private lateinit var rbjb: RadioButton
    private lateinit var rbbg: RadioButton
    private lateinit var rbao: RadioButton
    private lateinit var rbwb: RadioButton
    private lateinit var rbmz: RadioButton
    private var optionDialogListener: OnOptionDialogListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_option_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnChoose = view.findViewById(R.id.btn_choose)
        btnChoose.setOnClickListener(this)
        btnClose = view.findViewById(R.id.btn_close)
        btnClose.setOnClickListener(this)
        rgOptions = view.findViewById(R.id.rg_options)
        rbjb = view.findViewById(R.id.rb_jb)
        rbbg = view.findViewById(R.id.rb_bg)
        rbao = view.findViewById(R.id.rb_ao)
        rbwb = view.findViewById(R.id.rb_wb)
        rbmz = view.findViewById(R.id.rb_mz)
    }
        override fun onAttach(context: Context) {
            super.onAttach(context)
            val fragment = parentFragment
            if (fragment is DetailCategoryFragment) {
                val detailCategoryFragment = fragment
                this.optionDialogListener = detailCategoryFragment.optionDialogListener
            }
        }

    override fun onDetach() {
        super.onDetach()
        this.optionDialogListener = null
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_close -> dialog?.cancel()

            R.id.btn_choose -> {
                val checkedRadioButtonId = rg_options.checkedRadioButtonId
                if (checkedRadioButtonId != -1) {
                    var millionare: String? = null
                    when (checkedRadioButtonId) {
                        R.id.rb_jb -> millionare = rbjb.text.toString().trim()

                        R.id.rb_bg -> millionare = rbbg.text.toString().trim()

                        R.id.rb_ao -> millionare = rbao.text.toString().trim()

                        R.id.rb_wb -> millionare = rbwb.text.toString().trim()

                        R.id.rb_mz -> millionare = rbmz.text.toString().trim()
                    }

                    if (optionDialogListener != null){
                        optionDialogListener?.onOptionChosen(millionare)
                    }
                    dialog?.dismiss()
                }
            }
        }
    }
    interface  OnOptionDialogListener {
    fun onOptionChosen(text: String?)
    }
}

