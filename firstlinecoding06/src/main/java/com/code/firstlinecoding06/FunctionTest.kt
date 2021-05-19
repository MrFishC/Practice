package com.code.firstlinecoding06


/**
 * @创建者 Jack
 * @创建时间 2021/4/27 10:57
 * @描述
 */
class FunctionTest {

    fun example(func : (String,Int) -> Unit){
        func("hello",18)
    }

    fun func(string: String,int: Int){

    }

    fun num1AndNum2(num1: Int, num2: Int,operation: (Int,Int) -> Int): Int{
        val result = operation(num1,num2)
        return result
    }

}