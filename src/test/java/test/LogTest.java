package test;


import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=LogTest.class)
@Slf4j
public class LogTest {
    private  final Logger logger = LoggerFactory.getLogger(LogTest.class);
    /**
     * 一、传统方式实现日志
     */
    @Test
    public  void test1(){
        logger.debug("debug message");
        logger.warn("warn message");
        logger.info("info message");
        logger.error("error message");
        logger.trace("trace message");
    }


    /**
     * 二、注解方式实现日志
     */
    @Test
   public  void test2(){
        log.debug("debug message");
        log.warn("warn message");
        log.info("info message");
        log.error("error message");
        log.trace("trace message");
    }
}
