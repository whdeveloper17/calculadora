package com.example.calculadora

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text1.setOnClickListener { agregarExpresion("1",true) }
        text2.setOnClickListener { agregarExpresion("2",true) }
        text3.setOnClickListener { agregarExpresion("3",true) }
        text4.setOnClickListener { agregarExpresion("4",true) }
        text5.setOnClickListener { agregarExpresion("5",true) }
        text6.setOnClickListener { agregarExpresion("6",true) }
        text7.setOnClickListener { agregarExpresion("7",true) }
        text8.setOnClickListener { agregarExpresion("8",true) }
        text9.setOnClickListener { agregarExpresion("9",true) }
        text0.setOnClickListener { agregarExpresion("0",true) }

        textsumas.setOnClickListener { agregarExpresion("+",false) }
        textresta.setOnClickListener { agregarExpresion("-",false) }
        textmultiplicacion.setOnClickListener { agregarExpresion("*",false) }
        textdividir.setOnClickListener { agregarExpresion("/",false) }
        textabrir.setOnClickListener { agregarExpresion("(",false) }
        textcerrar.setOnClickListener { agregarExpresion(")",false) }
        textpunto.setOnClickListener { agregarExpresion(".",false) }

        textlimpiar.setOnClickListener {
            textexpresiones.text=""
            textresultado.text=""
        }

        imageborrar.setOnClickListener {
            val value = textexpresiones.text
            if (value.isNotEmpty()){
                textexpresiones.text=value.substring(0,value.length-1)
            }
            textresultado.text=""
        }

        textigual.setOnClickListener {
           try {
               val expresionen=ExpressionBuilder(textexpresiones.text.toString()).build()
               val result =expresionen.evaluate()
               val longresultado=result.toLong()
               if (result==longresultado.toDouble())
                   textresultado.text=longresultado.toString()
               else
                   textresultado.text=result.toString()
           }catch (e:Exception){

           }
        }
    }

    fun agregarExpresion(value:String, limpiar:Boolean){
        if(textresultado.text.isNotEmpty()){
            textexpresiones.text=" "
        }

        if(limpiar){
            textresultado.text=""
            textexpresiones.append(value)
        }else{
            textexpresiones.append(textresultado.text)
            textexpresiones.append(value)
            textresultado.text=""
        }
    }
}