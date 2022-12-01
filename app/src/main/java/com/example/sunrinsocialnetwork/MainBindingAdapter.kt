package com.example.sunrinsocialnetwork

import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.BindingAdapter
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.sunrinsocialnetwork.data.MealResponse
import com.google.android.material.card.MaterialCardView

object MainBindingAdapter {
    @BindingAdapter("bindNicknameConfirmText")
    @JvmStatic
    fun bindNicknameConfirmText(view: TextView, isConfirm: Boolean) {
        if (isConfirm) {
            view.setTextColor(Color.parseColor("#3d3d3d"))
        } else {
            view.setTextColor(Color.parseColor("#ED1B1B"))
        }
    }

    @BindingAdapter("bindEmailConfirmText")
    @JvmStatic
    fun bindEmailConfirmText(view: TextView, isConfirm: Boolean) {
        if (isConfirm) {
            view.visibility = View.INVISIBLE
        } else {
            view.visibility = View.VISIBLE
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    @BindingAdapter(
        value = ["position", "selectPosition"],
        requireAll = false
    )
    @JvmStatic
    fun selectBottomNavigationItem(
        view: ImageView,
        position: Int,
        selectPosition: Int,
    ) {
        if (position == selectPosition) {
            view.setColorFilter(Color.parseColor("#69C98A"))
        } else {
            view.setColorFilter(Color.parseColor("#3d3d3d"))
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    @BindingAdapter(value = ["position", "selectPosition"], requireAll = false)
    @JvmStatic
    fun selectBottomNavigationItem(view: TextView, position: Int, selectPosition: Int) {
        if (position == selectPosition) {
            view.setTextColor(Color.parseColor("#69C98A"))
            view.typeface = ResourcesCompat.getFont(view.context, R.font.pretendardb)
        } else {
            view.setTextColor(Color.parseColor("#3d3d3d"))
            view.typeface = ResourcesCompat.getFont(view.context, R.font.pretendardm)
        }
    }


    @BindingAdapter("setPagerCallback")
    @JvmStatic
    fun setPagerChangeFunction(view: ViewPager2, function: (Int) -> Unit) {
        view.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                function(position)
            }
        })
    }

    @BindingAdapter("currentItem")
    @JvmStatic
    fun setAdapter(view: ViewPager2, position: Int) {
        view.currentItem = position
    }

    @BindingAdapter("setAdapter")
    @JvmStatic
    fun setAdapter(view: ViewPager2, activity: Activity) {
        view.adapter = MainViewPagerAdapter(activity as FragmentActivity)
    }


    @BindingAdapter("loadImage")
    @JvmStatic
    fun loadImage(view: ImageView, url: String?) {
        if (url == null) {
            return
        }
        Glide.with(view.context)
            .load(url)
            .centerCrop()
            .into(view)
    }

    @BindingAdapter("bindMeal")
    @JvmStatic
    fun bindMeal(view: TextView, data: MealResponse?) {
        var mealText = ""
        val meals = data?.meal?.split("<br/>")
        if (meals != null) {
            for (i in meals) {
                mealText += i + "\n"
            }
            view.text = mealText
        }

    }


}