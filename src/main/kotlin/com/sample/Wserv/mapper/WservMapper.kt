package com.sample.Wserv.mapper


import org.apache.ibatis.annotations.Mapper
import com.sample.Wserv.model.WservModel

@Mapper
interface WservMapper {
    // 抽象メソッドで定義する
    fun find(): List<WservModel>

}