package is.hi.tripplanner.vinnsla;

public class User {
    private boolean isAdmin;
    private String firstName;
    private String lastName;
    private String ssn;
    private String username;
    private String email;
    private int userRef;

    public User(boolean admin, String fn, String ln, String ssn, String un, String email, int uid) {
        this.isAdmin=admin;
        this.firstName=fn;
        this.lastName=ln;
        this.ssn=ssn;
        this.username=un;
        this.email=email;
        this.userRef=uid;
    }

    public int getUserRef() {
        return this.userRef;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getSsn() {
        return this.ssn;
    }

    public String getUsername() {
        return this.username;
    }

    public String getEmail() {
        return this.email;
    }

    public boolean getAdmin() {
        return this.isAdmin;
    }
}
