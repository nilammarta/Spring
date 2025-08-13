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

    /**
     * Pointcut untuk method yang MEMILIKI parameter String
     * Ini akan menangkap semua method di HelloService yang memiliki satu parameter bertipe String
     */
    @Pointcut("execution(* karinzz.spring.core.bagian5AOP.service.HelloService.*(java.lang.String))")
    public void pointcutHelloServiceStringParam(){

    }

    /**
     * Advice yang akan dijalankan sebelum method dengan parameter String
     * Ini akan mencetak log dengan nilai parameter yang diterima oleh method tersebut
     */
    @Before("pointcutHelloServiceStringParam()")
    public void logStringParameter(JoinPoint joinPoint) {
        String value = (String) joinPoint.getArgs()[0];
        log.info("Execute method with parameter: " + value);
    }

    /**
     * Advice yang akan dijalankan sebelum method dengan parameter String
     * dan akan menerima parameter tersebut sebagai argumen
     * Ini akan mencetak log dengan nilai parameter yang diterima oleh method tersebut
     * @param name
     */
    @Before("pointcutHelloServiceStringParam() && args(name)")
    public void logStringParam(String name){
        log.info("Execute method with parameter: " + name);
    }

    /**
     * MULTIPLE POINTCUTS
     */
    @Pointcut("execution(* karinzz.spring.core.bagian5AOP.service.*.*(..))")
    public void pointcutServicePackage() {
        // Pointcut untuk semua method di package karinzz.spring.core.bagian5AOP.service
    }

    @Pointcut("bean(*Service)")
    public void pointcutServiceBean() {
        // Pointcut untuk semua bean yang ada di package karinzz.spring.core.bagian5AOP.service
    }

    @Pointcut("execution(public * *(..))")
    public void pointcutPublicMethod() {
        // Pointcut untuk semua method public di package karinzz.spring.core.bagian5AOP.service
    }

    // ini akan menggabungkan ketiga pointcut di atas
    @Pointcut("pointcutServicePackage() && pointcutServiceBean() && pointcutPublicMethod()")
    public void publicMethodForService(){

    }

    @Before("publicMethodForService()")
    public void logAllPublicServiceMethods() {
        log.info("Log for all service methods");
    }


}

