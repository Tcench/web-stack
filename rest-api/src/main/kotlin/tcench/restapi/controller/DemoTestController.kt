package tcench.restapi.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import tcench.restapi.util.R
import tcench.restapi.vo.DemoVO

@RestController
@RequestMapping("/")
class DemoTestController {

    @PostMapping("/demo-add")
    fun demoAdd(@RequestBody demo: DemoVO): R {
        println(demo.toString())
        return R.ok("result : $demo")
    }
}