package levelup;

import levelup.aspect.MyTimer;
import levelup.print.Print;
import levelup.print.Printer;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext
                ("META-INF/spring/app-context.xml");
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new MyTimer());

        Print print = ctx.getBean("print", Print.class);

        pf.setTarget(print);
        Print proxy1 = (Print) pf.getProxy();
        Printer printer = proxy1.choosePrinter();

        pf.setTarget(printer);
        Printer proxy2 = (Printer) pf.getProxy();
        //printer.print();
        System.out.println();
        proxy2.print();

        ((ClassPathXmlApplicationContext) ctx).registerShutdownHook();
    }
}

