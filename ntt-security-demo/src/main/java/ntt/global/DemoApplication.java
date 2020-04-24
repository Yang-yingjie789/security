package ntt.global;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p></p>
 *
 * @Author Yang yingjie(杨英杰)
 * @Created 2020/4/24 9:19
 */
@SpringBootApplication
@RestController
public class DemoApplication {
    /**
     * Spring 项目启动项 固定模式
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class,args);
    }
    @GetMapping("/hello")
    public void hello(){
        System.out.println("Hello Security Restful");
    }

}
