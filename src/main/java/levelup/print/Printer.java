package levelup.print;

public class Printer {
    private String name, ip, description;
    private long start, end;

//    @PostConstruct
    private void init() {
        start = System.nanoTime();
        System.out.println("\t--- " + name + " initialized. Time = " + start);
    }

//    @PreDestroy
    private void destroy() {
        System.out.print("\t--- " + name + " is destroying. ");
        end = System.nanoTime();
        System.out.println("Time = " + end + ". Lifetime = " + toSeconds(end - start) + " s");
    }

    private double toSeconds(long ns) {
        return ns/1000000000;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void print() {
        System.out.println("Printing at " + name + ", IP-address: " + ip + " (" + description + ")");
    }
}
