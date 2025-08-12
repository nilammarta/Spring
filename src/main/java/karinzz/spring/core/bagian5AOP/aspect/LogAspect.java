package karinzz.spring.core.bagian5AOP.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Cara membuat Aspect:
 * 1. Buat class dengan anotasi @Aspect
 * 2. Tambahkan anotasi @Component agar Spring dapat mendeteksi class ini sebagai bean
 */
@Slf4j
@Aspect
@Component
public class LogAspect {

    /**
     * Pointcut adalah anotasi yang digunakan untuk mendefinisikan titik potong (join point)
     * Dimana pointcut ini akan digunakan untuk menentukan kapan advice akan dijalankan.
     * dan akan mengacu pada semua method yang ada di dalam class HelloService.
     */
    @Pointcut("target(karinzz.spring.core.bagian5AOP.service.HelloService)")
    public void helloServiceMethod() {
    }

    /**
     * Advice adalah anotasi yang digunakan untuk menentukan tindakan yang akan dilakukan
     * dibawah ini adalah advice yang akan dijalankan sebelum method yang ditentukan oleh pointcut.
     *
     * kemudian Parameter JoinPoint digunakan untuk mendapatkan informasi tentang join point
     * seperti nama class, nama method, dan parameter yang diterima.
     */
    @Before("helloServiceMethod()")
    public void beforeHelloServiceMethod(JoinPoint joinPoint) {
        // Mendapatkan nama class dan nama method yang sedang dieksekusi
        String className = joinPoint.getTarget().getClass().getName();
        // Mendapatkan nama method yang sedang dieksekusi
        String methodName = joinPoint.getSignature().getName();
        log.info("Before executing " + className + ". " + methodName + "method");
    }

    @Before("helloServiceMethod()")
    public void beforeHelloServiceMethod2() {
        log.info("Before executing HelloService method again");
    }

    /**
     * PENGGUNAAN @Around ADVICE, DIMANA AKAN DIJALANKAN SEBELUM DAN SESUDAH METHOD YANG DIJADIKAN TARGET
     */
    @Around("helloServiceMethod()")
    public Object aroundHelloServiceMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();

        try{
            log.info("Around Before executing " + className + ". " + methodName + "()");
            return joinPoint.proceed(joinPoint.getArgs());
        }catch (Throwable e){
            log.info("Around Error in " + className + ". " + methodName + "()");
            throw e;
        }finally {
            log.info("Around After executing " + className + ". " + methodName + "()");
        }
    }
}
