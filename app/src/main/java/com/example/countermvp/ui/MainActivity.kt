package com.example.countermvp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.countermvp.R
import com.example.countermvp.databinding.ActivityMainBinding
import com.example.countermvp.helper.Injector
import com.example.countermvp.view.CounterView

class MainActivity : AppCompatActivity(), CounterView {

    lateinit var binding: ActivityMainBinding
    private val presenter = Injector.getPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.attachView(this)
        initClicker()
    }

    private fun initClicker() {
        with(binding) {
            buttonIncrement.setOnClickListener {
                presenter.increment()
            }
            buttonDescrement.setOnClickListener {
                presenter.decrement()
            }
        }
    }

    override fun updateText(count: Int) {
        binding.textViewCounter.text = count.toString()
    }


    override fun showToast() {
        Toast.makeText(this, "Поздравляем!", Toast.LENGTH_SHORT).show()
    }


    @SuppressLint("ResourceAsColor")
    override fun changeTextColor(color: Int) {
        binding.textViewCounter.setTextColor(color)
    }
}