package com.sample.Wserv.controller


//import com.sample.sample.service.SampleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong


@Controller
class SampleController(){

    @GetMapping("/")
    fun index(model: Model): String  {
        // 以下３行とも同じように動く
        // model.addAttribute("modelList", service.find())
        // model.set("modelList", service.find())
        //model["modelList"] = service.find()
        return "index"
    }
}
@Controller
class Sample2Controller(){

    @GetMapping("/test")
    fun index(model: Model): String  {
        return "test"
    }
}

data class Greeting(val id: Long, val content: String)

@CrossOrigin(origins = arrayOf("http://localhost:4200", "https://my-app-6e45b.web.app"), maxAge = 3600)
@RestController
class GreetingController {


    val counter = AtomicLong()
    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String) =
            Greeting(counter.incrementAndGet(), "Hello, $name")

}