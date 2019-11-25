package com.sample.Wserv.model

import java.util.*

data class WservModel(var id: Int, var name: String, var price: Int, var type: Int)

data class UserModel(
        var id: Int,
        var name: String,
        var groupMemberId: Int,
        var birthDate: Date,
        var address: String,
        var note: String,
        var isAddInfo : Boolean,
        var isDeleted: Boolean,
        var isActive: Boolean,
        var createTime: Date,
        var updateTime: Date)

data class GroupMemberModel(var id: Int, var name: String, var note: String, var isDeleted: Boolean,
                            var isActive: Boolean, var createTime: Date, var updateTime: Date)

data class Student (
        var name: String? = null,
        var address: String? = null) {
}
