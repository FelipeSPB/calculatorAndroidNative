package com.example.calculadora.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculadora.R
import com.example.calculadora.methods.Methods
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Methods {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    fun setListeners(){
        var painel: String = view_calculator.text as String
        btn_clean.setOnClickListener{
            painel = "0"
            view_calculator.text = painel
        }
        btn_soma.setOnClickListener{
            if(checkExpressionLength(painel) && !alreadyHasMathSymbol(painel) && !painel.equals("")){
                painel += btn_soma.text
                view_calculator.text = painel
            }
        }
        btn_sub.setOnClickListener{
            if(checkExpressionLength(painel) && !alreadyHasMathSymbol(painel) && !painel.equals("")){
                painel += btn_sub.text
                view_calculator.text = painel
            }
        }
        btn_multiplication.setOnClickListener{
            if(checkExpressionLength(painel) && !alreadyHasMathSymbol(painel) && !painel.equals("")){
                painel += btn_multiplication.text
                view_calculator.text = painel
            }
        }
        btn_division.setOnClickListener{
            if(checkExpressionLength(painel) && !alreadyHasMathSymbol(painel) && !painel.equals("")){
                painel += btn_division.text
                view_calculator.text = painel
            }
        }
        btn_dot.setOnClickListener{
            if(painel.equals("0")){
                painel += btn_dot.text
                view_calculator.text = painel
            }
            else if (checkExpressionLength(painel) && checkingDecimals(painel)){
                painel += btn_dot.text
                view_calculator.text = painel
            }
        }
        btn_equal.setOnClickListener{
            view_calculator.text = calculate(painel)
            painel = view_calculator.text as String
        }
        btn_porcentage.setOnClickListener{
            view_calculator.text = porcentage(painel)
            painel = view_calculator.text as String
        }
        btn_seven.setOnClickListener{
            if(painel.equals("0")){
                painel=""
                view_calculator.text = painel
            }
            if(checkExpressionLength(painel)){
                painel += btn_seven.text
                view_calculator.setText(painel)
            }
        }
        btn_eight.setOnClickListener{
            if(painel.equals("0")){
                painel=""
                view_calculator.text = painel
            }
            if(checkExpressionLength(painel)){
                painel += btn_eight.text
                view_calculator.text = painel
            }
        }
        btn_nine.setOnClickListener{
            if(painel.equals("0")){
                painel=""
                view_calculator.text = painel
            }
            if(checkExpressionLength(painel)){
                painel += btn_nine.text
                view_calculator.text = painel
            }
        }
        btn_four.setOnClickListener{
            if(painel.equals("0")){
                painel=""
                view_calculator.text = painel
            }
            if(checkExpressionLength(painel)){
                painel += btn_four.text
                view_calculator.text = painel
            }
        }
        btn_five.setOnClickListener{
            if(painel.equals("0")){
                painel=""
                view_calculator.text = painel
            }
            if(checkExpressionLength(painel)){
                painel += btn_five.text
                view_calculator.text = painel
            }
        }
        btn_six.setOnClickListener{
            if(painel.equals("0")){
                painel=""
                view_calculator.text = painel
            }
            if(checkExpressionLength(painel)){
                painel += btn_six.text
                view_calculator.text = painel
            }
        }
        btn_one.setOnClickListener{
            if(painel.equals("0")){
                painel=""
                view_calculator.text = painel
            }
            if(checkExpressionLength(painel)){
                painel += btn_one.text
                view_calculator.text = painel
            }
        }
        btn_two.setOnClickListener{
            if(painel.equals("0")){
                painel=""
                view_calculator.text = painel
            }
            if(checkExpressionLength(painel)){
                painel += btn_two.text
                view_calculator.text = painel
            }
        }
        btn_three.setOnClickListener{
            if(painel.equals("0")){
                painel=""
                view_calculator.text = painel
            }
            if(checkExpressionLength(painel)){
                painel += btn_three.text
                view_calculator.text = painel
            }
        }
        btn_zero.setOnClickListener{
            if(painel.equals("0")){
                painel="0"
                view_calculator.text = painel
            }
            else if(checkExpressionLength(painel)){
                painel += btn_zero.text
                view_calculator.text = painel
            }
        }

    }

}