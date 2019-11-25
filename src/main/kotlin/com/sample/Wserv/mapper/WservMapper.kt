package com.sample.Wserv.mapper

import org.apache.ibatis.annotations.Mapper

import com.sample.Wserv.model.WservModel
import com.sample.Wserv.model.UserModel
import com.sample.Wserv.model.GroupMemberModel

@Mapper
interface WservMapper {
    // 抽象メソッドで定義する
    fun find(): List<WservModel>
    fun findUser(): List<UserModel>
    fun findUserById(userId : Int): List<UserModel>
    fun findGroupMember(): List<GroupMemberModel>

    fun updateUserById(reqUser : UserModel)

    fun createUser(reqUser : UserModel)

}