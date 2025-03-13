package com.example.myapplication.datasource

object Calculation {

    fun calculateIMC(heigth: String, weight:String, response: (String, Boolean)-> Unit){
        if(heigth.isNotEmpty() && weight.isNotEmpty()){
            var weigthFormated = weight.replace(",",".").toDoubleOrNull()
            var heightFormated = heigth.toDoubleOrNull()

            if(weigthFormated != null && heightFormated != null){
                val imc = weigthFormated / (heightFormated / 100 * heightFormated / 100)

                when{
                    imc < 18.5 -> response("IMC: $imc \n Abaixo do Peso",false)
                    imc in 18.5 .. 24.9 -> response("IMC: $imc \n Peso Normal",false)
                    imc in 25.0 .. 29.9 -> response("IMC: $imc \n Sobre Peso",false)
                    imc in 30.0 .. 34.9 -> response("IMC: $imc \n Obesidade Grau I",false)
                    imc in 35.0 .. 39.9 -> response("IMC: $imc \n Obesidade Grau II",false)
                    imc > 39.9 -> response("IMC: $imc \n Obesidade Grau III",false)
                }
            }
        }else{
            response("Valores Inválidos, Preencha os Campos", true)
        }

    }
}