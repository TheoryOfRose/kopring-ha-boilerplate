package org.example.cmd

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication(scanBasePackages = ["org.example"])
@EnableJpaRepositories(basePackages = ["org.example.adapter.outbound.jpa.interfaces"])
@EntityScan(basePackages = ["org.example.adapter.outbound.jpa.entities"])
@ComponentScan(basePackages = ["org.example"])
class Application {

//    @Bean
//    fun commandLineRunner(ctx: ApplicationContext): CommandLineRunner {
//        return CommandLineRunner {
//            println("Registered Beans:")
//            val beanNames = ctx.beanDefinitionNames
//            beanNames.sorted().forEach { println(it) }
//        }
//    }
//
//    @Bean(name = ["TestBean"])
//    fun helloTestBean() {
//        println("Hello from test bean")
//    }
}

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}