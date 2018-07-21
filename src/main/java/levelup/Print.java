package levelup;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Scanner;

public class Print {
    private Printer printer;
    @Resource(name = "printersmap")
    private HashMap<String, Printer> printersMap;

    public Printer choosePrinter() {
        System.out.println("Choose a printer");
        if (printersMap == null) {
            System.out.println("printersMap == null!!!");
            ApplicationContext ctx = new ClassPathXmlApplicationContext
                    ("META-INF/spring/app-context.xml");
            printersMap = ctx.getBean("printersmap", HashMap.class);
          //  return ctx.getBean("printer1", Printer.class);
        }
        for(String s: printersMap.keySet()) {
            System.out.println(s + ". " + printersMap.get(s).getName());
        }
        //TODO: Scanner to Spring style
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();
        printer = printersMap.get(choice);
//        printer = printersMap.get("2");
        return printer;
    }
}
