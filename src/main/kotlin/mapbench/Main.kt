package mapbench

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan

@EnableAutoConfiguration
@ComponentScan
class Main

fun main(args: Array<String>) {
    SpringApplication.run(Main::class.java, *args)
}