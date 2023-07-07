import java.util.Date;

abstract class Insurance {
    String insuranceName;
    double insurancePrice;
    Date insuranceStartDate;
    Date insuranceFinishDate;

    public Insurance(String insuranceName, double insurancePrice, Date insuranceStartDate, Date insuranceFinishDate) {
        this.insuranceName = insuranceName;
        this.insurancePrice = insurancePrice;
        this.insuranceStartDate = insuranceStartDate;
        this.insuranceFinishDate = insuranceFinishDate;
    }

    public abstract void calculate();
}

class HealthInsurance extends Insurance {
    private int deductible;

    public HealthInsurance(String insuranceName, double insurancePrice, Date insuranceStartDate, Date insuranceFinishDate, int deductible) {
        super(insuranceName, insurancePrice, insuranceStartDate, insuranceFinishDate);
        this.deductible = deductible;
    }

    @Override
    public void calculate() {
        System.out.println(this.insuranceName);
        System.out.println("Teminat Tutarı: " + insurancePrice);
        System.out.println("Muafiyet Tutarı: " + deductible);
    }
}

class ResidenceInsurance extends Insurance {
    private String propertyType;

    public ResidenceInsurance(String insuranceName, double insurancePrice, Date insuranceStartDate, Date insuranceFinishDate, String propertyType) {
        super(insuranceName, insurancePrice, insuranceStartDate, insuranceFinishDate);
        this.propertyType = propertyType;
    }

    @Override
    public void calculate() {
        System.out.println(this.insuranceName);
        System.out.println("Teminat Tutarı: " + insurancePrice);
        System.out.println("Mülk Tipi: " + propertyType);
    }
}

class TravelInsurance extends Insurance {
    private int destination;

    public TravelInsurance(String insuranceName, double insurancePrice, Date insuranceStartDate, Date insuranceFinishDate, int destination) {
        super(insuranceName, insurancePrice, insuranceStartDate, insuranceFinishDate);
        this.destination = destination;
    }

    @Override
    public void calculate() {
        System.out.println(this.insuranceName);
        System.out.println("Teminat Tutarı: " + insurancePrice);
        System.out.println("Mesafe: " + destination);
    }
}

class CarInsurance extends Insurance {
    private String carModel;

    public CarInsurance(String insuranceName, double insurancePrice, Date insuranceStartDate, Date insuranceFinishDate, String carModel) {
        super(insuranceName, insurancePrice, insuranceStartDate, insuranceFinishDate);
        this.carModel = carModel;
    }

    @Override
    public void calculate() {
        System.out.println(this.insuranceName);
        System.out.println("Teminat Tutarı: " + insurancePrice);
        System.out.println("Arabanın Modeli: " + carModel);
    }
}
