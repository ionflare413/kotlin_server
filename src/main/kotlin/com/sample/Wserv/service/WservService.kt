package com.sample.Wserv.service

import com.sample.Wserv.mapper.WservMapper
import com.sample.Wserv.model.GroupMemberModel
import com.sample.Wserv.model.UserModel

import com.sample.Wserv.model.WservModel

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import org.apache.ibatis.annotations.Param

@Service
@Transactional
class WservService(private val mapper: WservMapper) {

    fun find() : List<WservModel> = mapper.find()
    fun findUser() : List<UserModel> = mapper.findUser()
    fun findUserById(userId : Int) : List<UserModel> = mapper.findUserById(userId)
    fun findGroupMember() : List<GroupMemberModel> = mapper.findGroupMember()

    fun updateUserById(reqUser : UserModel) = mapper.updateUserById(reqUser)

    fun createUser(reqUser : UserModel) = mapper.createUser(reqUser)

}
