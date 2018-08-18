package levelup.aspect;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyTimer implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        long start, end;
        start = System.nanoTime();
        System.out.println("[ method start: " + start + " ]");
        Object retVal = invocation.proceed();
        end = System.nanoTime();
        System.out.println("[ method end: " + end + " ]");
        System.out.println("[ method time: " + (end - start) + " ns ]\n");
        return retVal;
    }
}
