package furuma_resort.models;

public class ExtraServices {
    private String nameOfExtraService;
    private String unit;
    private double priceOfExtraService;

    public ExtraServices(String nameOfExtraService, String unit, double priceOfExtraService) {
        this.nameOfExtraService = nameOfExtraService;
        this.unit = unit;
        this.priceOfExtraService = priceOfExtraService;
    }

    public String getNameOfExtraService() {
        return nameOfExtraService;
    }

    public void setNameOfExtraService(String nameOfExtraService) {
        this.nameOfExtraService = nameOfExtraService;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getPriceOfExtraService() {
        return priceOfExtraService;
    }

    public void setPriceOfExtraService(double priceOfExtraService) {
        this.priceOfExtraService = priceOfExtraService;
    }

    @Override
    public String toString() {
        return "ExtraServices{" +
                "nameOfExtraService='" + nameOfExtraService + '\'' +
                ", unit='" + unit + '\'' +
                ", priceOfExtraService=" + priceOfExtraService +
                '}';
    }
}
