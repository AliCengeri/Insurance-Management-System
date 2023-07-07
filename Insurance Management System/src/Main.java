import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = dateFormat.parse("01/02/2023");

        User user1 = new User("Ali", "Cengeri", "ali@hotmail.com", "123", "zort", 22, date);
        Address homeAdress = new HomeAddress("Zeki Sokak", "Adana", 35340);
        Address businessAdress = new BusinessAddress("Mülayim Sokak", "Eskişehir", 33450);
        AddressManager.addAddress(user1, homeAdress);
        AddressManager.addAddress(user1, businessAdress);

        Account account = new Individual(user1);
        Insurance healthInsurance = new HealthInsurance("Sağlık Sigortası", 25000, date, date, 2500);
        Insurance ResidenceInsurance = new ResidenceInsurance("Mülkiyet Sigortası", 25000, date, date, "Özel Mülk");
        Insurance TravelInsurance = new TravelInsurance("Seyahat Sigortası", 25000, date, date, 2500);
        Insurance CarInsurance = new CarInsurance("Araba Sigortası", 25000, date, date, "Fiat Egea");
        account.addInsurance(healthInsurance);
        account.addInsurance(ResidenceInsurance);
        account.addInsurance(TravelInsurance);
        account.addInsurance(CarInsurance);

        AccountManager.addAccount(account);

        System.out.print("Email'ınızı giriniz: ");
        String email = input.next();
        System.out.print("Şifrenizi giriniz: ");
        String password = input.next();
        if (AccountManager.login(email, password) != null) {
            account.showUserInfo(user1);
        }
    }
}