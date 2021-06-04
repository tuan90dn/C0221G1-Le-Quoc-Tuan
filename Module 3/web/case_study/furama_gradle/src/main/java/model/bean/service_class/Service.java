package model.bean.service_class;

public class Service {
    protected int service_id;
    protected String service_name;
    protected String service_area;
    protected String service_cost;
    protected String service_max_people;
    protected RentType rent_type_id;
    protected ServiceType service_type_id;
    protected String standard_room;
    protected String description_other_convenience;
    protected String pool_area;
    protected String number_of_floor;

    public Service() {
    }

    public Service(int service_id, String service_name, String service_area, String service_cost, String service_max_people,
                   RentType rent_type_id, ServiceType service_type_id, String standard_room,
                   String description_other_convenience, String pool_area, String number_of_floor) {
        this.service_id = service_id;
        this.service_name = service_name;
        this.service_area = service_area;
        this.service_cost = service_cost;
        this.service_max_people = service_max_people;
        this.rent_type_id = rent_type_id;
        this.service_type_id = service_type_id;
        this.standard_room = standard_room;
        this.description_other_convenience = description_other_convenience;
        this.pool_area = pool_area;
        this.number_of_floor = number_of_floor;
    }

    public Service(int service_id, String service_name, RentType rent_type_id, ServiceType service_type_id, String number_of_floor) {
        this.service_id = service_id;
        this.service_name = service_name;
        this.rent_type_id = rent_type_id;
        this.service_type_id = service_type_id;
        this.number_of_floor = number_of_floor;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public String getService_area() {
        return service_area;
    }

    public void setService_area(String service_area) {
        this.service_area = service_area;
    }

    public String getService_cost() {
        return service_cost;
    }

    public void setService_cost(String service_cost) {
        this.service_cost = service_cost;
    }

    public String getService_max_people() {
        return service_max_people;
    }

    public void setService_max_people(String service_max_people) {
        this.service_max_people = service_max_people;
    }

    public RentType getRent_type_id() {
        return rent_type_id;
    }

    public void setRent_type_id(RentType rent_type_id) {
        this.rent_type_id = rent_type_id;
    }

    public ServiceType getService_type_id() {
        return service_type_id;
    }

    public void setService_type_id(ServiceType service_type_id) {
        this.service_type_id = service_type_id;
    }

    public String getStandard_room() {
        return standard_room;
    }

    public void setStandard_room(String standard_room) {
        this.standard_room = standard_room;
    }

    public String getDescription_other_convenience() {
        return description_other_convenience;
    }

    public void setDescription_other_convenience(String description_other_convenience) {
        this.description_other_convenience = description_other_convenience;
    }

    public String getPool_area() {
        return pool_area;
    }

    public void setPool_area(String pool_area) {
        this.pool_area = pool_area;
    }

    public String getNumber_of_floor() {
        return number_of_floor;
    }

    public void setNumber_of_floor(String number_of_floor) {
        this.number_of_floor = number_of_floor;
    }
}
