package com.example.calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnClearAll.setOnClickListener {
            binding.txtResult.text = ""
            binding.txtSolution.text = ""
        }
        binding.btnClear.setOnClickListener {
          val string = binding.txtResult.text.toString()
            if(string.isNotEmpty()){
                binding.txtResult.text = string.substring(0,string.length-1)
            }
            binding.txtSolution.text = ""
        }
        binding.btnNum1.setOnClickListener {
            binding.txtResult.append("1")
        }
        binding.btnNum2.setOnClickListener {
            binding.txtResult.append("2")
        }
        binding.btnNum3.setOnClickListener {
            binding.txtResult.append("3")
        }
        binding.btnNum4.setOnClickListener {
            binding.txtResult.append("4")
        }
        binding.btnNum5.setOnClickListener {
            binding.txtResult.append("5")
        }
        binding.btnNum6.setOnClickListener {
            binding.txtResult.append("6")
        }
        binding.btnNum7.setOnClickListener {
            binding.txtResult.append("7")
        }
        binding.btnNum8.setOnClickListener {
            binding.txtResult.append("8")
        }
        binding.btnNum9.setOnClickListener {
            binding.txtResult.append("9")
        }
        binding.btnZero.setOnClickListener {
            binding.txtResult.append("0")
        }
        binding.btnAdd.setOnClickListener {
            binding.txtResult.append("+")
        }
        binding.btnMinus.setOnClickListener {
            binding.txtResult.append("-")
        }
        binding.btnMultiply.setOnClickListener {
            binding.txtResult.append("*")
        }
        binding.btnDivide.setOnClickListener {
            binding.txtResult.append("/")
        }
        binding.btnPoint.setOnClickListener {
            binding.txtResult.append(".")
        }
        binding.btnPercentage.setOnClickListener {
            binding.txtResult.append("%")
        }

        binding.btnEquals.setOnClickListener {
            val expression = ExpressionBuilder(binding.txtResult.text.toString()).build()
            try {
                val result = expression.evaluate()
                val longResult = result.toLong()
                if(result == longResult.toDouble()){
                    binding.txtSolution.text = longResult.toString()
                }
                else{
                    binding.txtSolution.text = result.toString()
                }
            }catch (e: Exception){
                binding.txtSolution.text = "Error"
            }

        }
    }
}


