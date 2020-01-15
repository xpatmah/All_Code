package com.sprinboot.starter.project.springbootdemo.aspect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class ExampleService {

    @Autowired
    private HandlerClass handlerClass;

    /*
     * @Autowired
     *
     * @Qualifier(value="localRunnabl") private Runnable localRunnable;
     */


    @RequestMapping("/home")
    String home() {
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {

            service.submit(new Runnable() {

                @Override
                public void run() {
                    handlerClass.mainMethod();
                }
            });

            /* service.submit(localRunnable); */
            //localRunnable.run();
        }
        return "Hello World!";
    }
}