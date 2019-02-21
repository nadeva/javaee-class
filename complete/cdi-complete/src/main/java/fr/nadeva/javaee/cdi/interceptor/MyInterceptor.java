package fr.nadeva.javaee.cdi.interceptor;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@BigBrowser
@Priority(Interceptor.Priority.APPLICATION)
public class MyInterceptor {

    @AroundInvoke
    private Object aroundInvoke(InvocationContext ic) throws Exception {
        System.out.println("Big Brother interceptor " + ic.getMethod().getName());
        return ic.proceed();
    }
}
