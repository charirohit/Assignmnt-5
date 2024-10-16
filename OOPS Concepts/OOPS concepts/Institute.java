

// Interface for Institute operations
interface InstituteOperations {
    void display();
}

// Base class
abstract class Institute implements InstituteOperations {
    private String instituteName;
    private String city;
    private String state;
    private String ministry;
    private String act;

    public Institute(String name, String city, String state, String act, String ministry) {
        this.instituteName = name;
        this.city = city;
        this.state = state;
        this.act = act;
        this.ministry = ministry;
    }

    public String getName() {
        return this.instituteName;
    }

    public String getCity() {
        return this.city;
    }

    public String getState() {
        return this.state;
    }

    public String getMinistry() {
        return this.ministry;
    }

    public String getAct() {
        return this.act;
    }

    @Override
    public void display() {
        System.out.println("=======================================================");
        System.out.println("Institute Name : " + this.getName());
        System.out.println("City : " + this.getCity());
        System.out.println("State : " + this.getState());
        System.out.println("Ministry : " + this.getMinistry());
        System.out.println("Act : " + this.getAct());
        System.out.println("=======================================================");
    }
}

// Derived class for public institutes
class PublicInstitute extends Institute {
    public PublicInstitute(String name, String city, String state, String act, String ministry) {
        super(name, city, state, act, ministry);
    }
}

// Derived class for private institutes
class PrivateInstitute extends Institute {
    public PrivateInstitute(String name, String city, String state, String act, String ministry) {
        super(name, city, state, act, ministry);
    }
}

