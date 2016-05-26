package patterns.Creational;

public class AbstarctFactoryMain {

    private Computer comp;

    public static void main(String[] args) {
        AbstarctFactoryMain type = new AbstarctFactoryMain();
        Computer computer = type.getComputer("Server");
        System.out.println("Monitor: " + computer.getMonitor().getSpecification());
        System.out.println("RAM: " + computer.getRAM().getSpecification());
        System.out.println("Processor: " + computer.getProcessor().getSpecification());
    }

    public Computer getComputer(String computerType) {
        if (computerType.equals("PC"))
            comp = new PC();
        else if (computerType.equals("Workstation"))
            comp = new Workstation();
        else if (computerType.equals("Server"))
            comp = new Server();
        return comp;

    }
}

abstract class Computer {
    public abstract Parts getRAM();

    public abstract Parts getProcessor();

    public abstract Parts getMonitor();

}

interface Parts {

    public String getCompanyName();

    public String getSpecification();

}

class GenuineParts implements Parts {
    private String specification;

    private String compName;

    public GenuineParts(String spec, String compName) {
        this.specification = spec;
        this.compName = compName;
    }

    @Override
    public String getCompanyName() {
        return compName + " Genuine Company";
    }

    @Override
    public String getSpecification() {
        return specification + " Good Quality";
    }
}

class CheapParts implements Parts {
    private String specification;

    private String compName;

    public CheapParts(String spec, String compName) {
        this.specification = spec;
        this.compName = compName;
    }

    @Override
    public String getCompanyName() {
        return compName + " is a Chinese Company";
    }

    @Override
    public String getSpecification() {
        return specification + " Low Quality ";
    }
}

class PartsProvider {
    public static Parts getParts(String type, String compName, String spec) {
        if ("Genuine".equals(type))
            return new GenuineParts(spec, compName);
        if ("Cheap".equals(type))
            return new CheapParts(spec, compName);

        return null;
    }

}

class Server extends Computer {

    public Parts getRAM() {
        return PartsProvider.getParts("Genuine", "INtel", "4 GB");
    }

    public Parts getProcessor() {
        return PartsProvider.getParts("Genuine", "INtel", "Intel P 4");
    }

    public Parts getMonitor() {
        return PartsProvider.getParts("Genuine", "INtel", "17 inches");
    }

}

class PC extends Computer {

    public Parts getRAM() {
        return PartsProvider.getParts("CheaP", "AGV", "512 MB");
    }

    public Parts getProcessor() {
        return PartsProvider.getParts("CheaP", "AGV", "Celeron");
    }

    public Parts getMonitor() {
        return PartsProvider.getParts("CheaP", "AGV", "15 inches");
    }
}

class Workstation extends Computer {

    public Parts getRAM() {
        return PartsProvider.getParts("CheaP", "AGV", "1 GB");
    }

    public Parts getProcessor() {
        return PartsProvider.getParts("CheaP", "AGV", "Intel P 3");
    }

    public Parts getMonitor() {
        return PartsProvider.getParts("CheaP", "AGV", "19 inches");
    }

}