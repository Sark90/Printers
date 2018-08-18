package levelup.print;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Scanner;

public class Print {
    private Printer printer;
    //@Resource(name = "printersmap")
    private HashMap<String, Printer> printersmap;

    public Printer choosePrinter() {
        System.out.println("Choose a printer");
        if (printersmap == null) {
            System.out.println("printersmap == null!!!");
            ApplicationContext ctx = new ClassPathXmlApplicationContext
                    ("META-INF/spring/app-context.xml");
            printersmap = ctx.getBean("printersmap", HashMap.class);
          //  return ctx.getBean("printer1", Printer.class);
        }
        for(String s: printersmap.keySet()) {
            System.out.println(s + ". " + printersmap.get(s).getName());
        }
        //TODO: Scanner to Spring style
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();
        printer = printersmap.get(choice);
        if (printer == null) {
            printer = printersmap.get("1");
            System.out.println("No such printer(((\nTake " + printer.getName() + "\n");
        }
        return printer;
    }

    public void setPrintersmap(HashMap<String, Printer> printersmap) {
        this.printersmap = printersmap;
    }
}
