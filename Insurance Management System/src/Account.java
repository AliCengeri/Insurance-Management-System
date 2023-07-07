import java.util.*;
import java.util.Date;


abstract class Account {
    private AuthenticationStatus authenticationStatus;
    private User user;
    protected static ArrayList<Insurance> insurances = new ArrayList<>();

    public Account(User user) {
        this.user = user;
        this.insurances = new ArrayList<>();
    }

    public enum AuthenticationStatus {
        SUCCESS,
        FAIL
    }

    public void login(String email, String password) throws InvalidAuthenticationException {
        if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
            this.authenticationStatus = authenticationStatus.SUCCESS;
        } else {
            throw new InvalidAuthenticationException("Geçersiz Hesap");
        }
    }

    public final void showUserInfo(User user) {
        System.out.println(user.getName() + " " + user.getSurName() + "\n" +
                user.getEmail() + "\n" +
                "Şifre: " + user.getPassword() + "\n" +
                "Meslek: " + user.getJob() + "\n" +
                "Yaş: " + user.getAge() + "\n" +
                "Son giriş tarihi: " + user.getLastLog());
        for (Address address : user.getAddress()) {
            address.displayAddress();
            System.out.println();
        }
        for (Insurance insurance : insurances) {
            insurance.calculate();
        }
    }

    public void addAddress(Address address) {
        if (authenticationStatus == authenticationStatus.SUCCESS) {
            user.addAddress(address);
        }
    }

    public void removeAddress(Address address) {
        if (authenticationStatus == authenticationStatus.SUCCESS) {
            user.removeAddress(address);
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.authenticationStatus = authenticationStatus;
        this.user = user;
        this.insurances = insurances;
    }

    public ArrayList<Insurance> getInsurances() {
        return insurances;
    }

    public void setInsurances(ArrayList<Insurance> insurances) {
        this.insurances = insurances;
    }

    public AuthenticationStatus getAuthenticationStatus() {
        return authenticationStatus;
    }

    public abstract void addInsurance(Insurance insurance);
}

class Individual extends Account {
    public Individual(User user) {
        super(user);
    }

    @Override
    public void addInsurance(Insurance insurance) {
        insurances.add(insurance);
    }
}

class Enterprise extends Account {
    private String companyName;

    public Enterprise(User user, String companyName) {
        super(user);
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public void addInsurance(Insurance insurance) {
        insurances.add(insurance);
    }
}

class User {
    private String name;
    private String surName;
    private String email;
    private String password;
    private String job;
    private int age;
    private ArrayList<Address> address;
    private Date lastLog;

    public User(String name, String surName, String email, String password, String job, int age, Date lastLog) {
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.password = password;
        this.job = job;
        this.age = age;
        this.address = new ArrayList<Address>(2);
        this.lastLog = lastLog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<Address> getAddress() {
        return address;
    }

    public void setAddress(ArrayList<Address> address) {
        this.address = address;
    }

    public Date getLastLog() {
        return lastLog;
    }

    public void setLastLog(Date lastLog) {
        this.lastLog = lastLog;
    }

    public void addAddress(Address address) {
        this.address.add(address);
    }

    public void removeAddress(Address address) {
        this.address.remove(address);
    }
}
