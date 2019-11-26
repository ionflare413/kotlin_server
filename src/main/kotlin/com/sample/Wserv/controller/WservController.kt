package com.sample.Wserv.controller


import com.google.gson.Gson
import com.sample.Wserv.model.GroupMemberModel
import com.sample.Wserv.model.Student
import com.sample.Wserv.model.UserModel
import com.sample.Wserv.model.WservModel
import com.sample.Wserv.service.WservService
import org.springframework.beans.factory.annotation.Autowired

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.*
import java.util.concurrent.atomic.AtomicLong


import java.util.HashMap

@Controller
class WservController(private val service: WservService) {

    @GetMapping("/")
    fun index(model: Model): String {
        // 以下３行とも同じように動く
        // model.addAttribute("modelList", service.find())
        // model.set("modelList", service.find())
        model["modelList"] = service.find()
        return "index"
    }
}

@Controller
class Sample2Controller() {

    @GetMapping("/test")
    fun index(model: Model): String {
        return "test"
    }
}

data class Greeting(val id: Long, val content: String)
@CrossOrigin(origins = arrayOf("http://localhost:4200", "https://my-app-6e45b.web.app", "https://my-app-6e45b.firebaseapp.com"), maxAge = 3600)
@RestController
class GreetingController(private val service: WservService)  {

    val counter = AtomicLong()
    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String) =
            Greeting(counter.incrementAndGet(), "Hello, $name")

    @GetMapping("/getdata")
    fun getsampleData(): List<WservModel> {
        return service.find();
    }

}

@CrossOrigin(origins = arrayOf("http://localhost:4200","https://my-app-6e45b.web.app", "https://my-app-6e45b.firebaseapp.com"), maxAge = 3600)
@RestController
class GroupMemberController(private val service: WservService) {

    @GetMapping("/get_groupMember")
    fun getGroupMember(): List<GroupMemberModel> {
        return service.findGroupMember();
    }
}

@CrossOrigin(origins = arrayOf("http://localhost:4200","https://my-app-6e45b.web.app", "https://my-app-6e45b.firebaseapp.com"), maxAge = 3600)
@RestController
class UserController(private val service: WservService) {

    @GetMapping("/get_user")
    fun getUser(): List<UserModel> {
        return service.findUser();
    }

    @GetMapping("/get_userById")
    fun getUserById(@RequestParam(value = "id") id: String): List<UserModel> {

        val userId = id.toInt() // 11
        //val b: Int? = "abc".toIntOrNull() // null
        //val c: Int? = null?.toIntOrNull() // null
        return service.findUserById(userId);
    }

    @PostMapping("/update_userById")
    fun updateUser(@RequestBody dataReq: Any): Any {

        //val student = Student("Alex", "Rome, 1500") // instance
        val jsonObj = Gson().toJson(dataReq)  // json string
        val reqUser = Gson().fromJson(jsonObj, UserModel::class.java)
        service.updateUserById(reqUser);
        return jsonObj;
    }

    @PostMapping("/create_user")
    fun createUser(@RequestBody dataReq: Any): Any {

        //val student = Student("Alex", "Rome, 1500") // instance
        val jsonObj = Gson().toJson(dataReq)  // json string
        val reqUser = Gson().fromJson(jsonObj, UserModel::class.java)
        service.createUser(reqUser);
        return jsonObj;
    }



    //@RequestMapping("", method = arrayOf(RequestMethod.POST))
    /* ====***[Post Sample]***===
   @PostMapping("/update_userById")
   fun addBook(@RequestBody dataReq: Any): Any {

       val student = Student("Alex", "Rome, 1500") // instance
       val jsonString = Gson().toJson(student)  // json string
       val student2 = Gson().fromJson(jsonString, Student::class.java)
       val jsonString2 = Gson().toJson(student2)
       return jsonString2;
    }

     */





}
