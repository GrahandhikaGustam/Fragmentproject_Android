package com.example.myflexiblefragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.fragment_category.*


class CategoryFragment : Fragment(), View.OnClickListener {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnDetailCategory: Button = view.findViewById(R.id.btn_detail_category)
        btnDetailCategory.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null)
            if (v.id == R.id.btn_detail_category) {
                val mDetailCategoryFragment = DetailCategoryFragment()

                val mBundle = Bundle()
                mBundle.putString(DetailCategoryFragment.EXTRA_NAME, "Lifestyle")
                val description = "Kategori ini akan berisi produk-produk lifestyle"

                mDetailCategoryFragment.arguments = mBundle
                mDetailCategoryFragment.description = description

                val mFramentManager = fragmentManager
                mFramentManager?.beginTransaction()?.apply {
                    replace(
                        R.id.frame_container,
                        mDetailCategoryFragment,
                        mDetailCategoryFragment::class.java.simpleName
                    )
                    addToBackStack(null)
                    commit()

                }
            }
    }
}





