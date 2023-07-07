interface Address {
    void displayAddress();
}

class BusinessAddress implements Address {
    private String street;
    private String city;
    private int zipCode;

    public BusinessAddress(String street, String city, int zipCode) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }

    @Override
    public void displayAddress() {
        System.out.println("İş adresi\n" +
                "Sokak: " + street + "\n" +
                "Şehir: " + city + "\n" +
                "Zip Kodu: " + zipCode);
    }
}

class HomeAddress implements Address {
    private String street;
    private String city;
    private int zipCode;

    public HomeAddress(String street, String city, int zipCode) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }

    @Override
    public void displayAddress() {
        System.out.println("Ev adresi\n" +
                "Sokak: " + street + "\n" +
                "Şehir: " + city + "\n" +
                "Zip Kodu: " + zipCode);
    }
}

class AddressManager {

    public static void addAddress(User user, Address newAddress) {
        user.getAddress().add(newAddress);
    }

    public static void removeAddress(User user, Address oldAddress) {
        user.getAddress().remove(oldAddress);
    }
}