package model.bean.service_class;

public class ServiceType {
    public int service_type_id;
    public String service_type_name;

    public ServiceType() {
    }

    public ServiceType(int service_type_id, String service_type_name) {
        this.service_type_id = service_type_id;
        this.service_type_name = service_type_name;
    }

    public int getService_type_id() {
        return service_type_id;
    }

    public void setService_type_id(int service_type_id) {
        this.service_type_id = service_type_id;
    }

    public String getService_type_name() {
        return service_type_name;
    }

    public void setService_type_name(String service_type_name) {
        this.service_type_name = service_type_name;
    }
}
