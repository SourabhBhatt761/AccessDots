package com.srb.accessdots

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.afollestad.materialdialogs.LayoutMode
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.bottomsheets.BottomSheet
import com.afollestad.materialdialogs.color.colorChooser
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.srb.accessdots.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.heart.setOnClickListener {
            setBottomSheet(this, R.layout.like_bottomsheet, findViewById(R.id.like_layout))
        }


        binding.iBtn.setOnClickListener {
            setBottomSheet(this, R.layout.info_bottomsheet, findViewById(R.id.info_layout))
        }

        binding.history.setOnClickListener {
            setBottomSheet(this, R.layout.history_bottomsheet, findViewById(R.id.history_layout))
        }

        binding.settings.setOnClickListener {
            setBottomSheet(this, R.layout.settings_bottomsheet, findViewById(R.id.settings_layout))
        }




    }


    private fun setBottomSheet(context: Context, bottomSheet: Int, layout: ViewGroup?) {
        val sheet = BottomSheetDialog(context)

        val view = LayoutInflater.from(context).inflate(bottomSheet, layout)

        sheet.setContentView(view)
        sheet.show()

    }



     fun cardColor(view: View) {

        val colors = intArrayOf(
            Color.BLACK,
            Color.RED,
            Color.BLUE,
            Color.GREEN,
            Color.YELLOW,
            Color.MAGENTA,
            Color.GRAY,
            Color.CYAN,
            ContextCompat.getColor(this, R.color.beige),
            ContextCompat.getColor(this, R.color.orange),
            ContextCompat.getColor(this, R.color.greenLight),
            ContextCompat.getColor(this, R.color.purpleBlue)
        )

        val card = view.findViewById<CardView>(R.id.click1)
        card.isClickable = false


        MaterialDialog(this, BottomSheet(LayoutMode.WRAP_CONTENT)).show {
            title(R.string.chooseColor)
            colorChooser(
                colors,
                allowCustomArgb = true,
                showAlphaSelector = true,
                initialSelection = ContextCompat.getColor(context,R.color.green)
            ) { _, color ->
                card.setCardBackgroundColor(color)
            }
            positiveButton(R.string.dialog_select)
            negativeButton(R.string.dialog_negative)

        }

        Handler(Looper.getMainLooper()).postDelayed({
            card.isClickable = true
        }, 1000)



    }

    fun cardColor2(view: View) {

        val colors = intArrayOf(
            Color.BLACK,
            Color.RED,
            Color.BLUE,
            Color.GREEN,
            Color.YELLOW,
            Color.MAGENTA,
            Color.GRAY,
            Color.CYAN,
            ContextCompat.getColor(this, R.color.beige),
            ContextCompat.getColor(this, R.color.orange),
            ContextCompat.getColor(this, R.color.greenLight),
            ContextCompat.getColor(this, R.color.purpleBlue)
        )

        val card = view.findViewById<CardView>(R.id.click2)
        card.isClickable = false


        MaterialDialog(this, BottomSheet(LayoutMode.WRAP_CONTENT)).show {
            title(R.string.chooseColor)
            colorChooser(
                colors,
                allowCustomArgb = true,
                showAlphaSelector = true,
                initialSelection = ContextCompat.getColor(context,R.color.orange)
            ) { _, color ->
                card.setCardBackgroundColor(color)
            }
            positiveButton(R.string.dialog_select)
            negativeButton(R.string.dialog_negative)

        }

        Handler(Looper.getMainLooper()).postDelayed({
            card.isClickable = true
        }, 1000)
    }


}