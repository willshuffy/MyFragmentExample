package com.willshuffyproject.myfragmentexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

/**
 * A simple [Fragment] subclass.
 */
class CategoryFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnDetailCategory:Button = view.findViewById(R.id.btn_detail_category)
        btnDetailCategory.setOnClickListener(this)
    }

    override fun onClick(v: View) {

        if (v.id == R.id.btn_detail_category){

            val mDetailCategoryFragment = DetailCategoryFragment()

            //mengirim data dengan objek bundle
            val mBundle = Bundle()
            mBundle.putString(DetailCategoryFragment.EXTRA_NAME, "Lifestyle")
            mDetailCategoryFragment.arguments = mBundle

            //mengirim data menggunakan setter getter
            val description = "Kategori akan berisi produk-produk lifestyle"
            mDetailCategoryFragment.description = description

            val mFragManager = fragmentManager
            mFragManager?.beginTransaction()?.apply {
                replace(R.id.frame_container, mDetailCategoryFragment, DetailCategoryFragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }

        }
    }

}
