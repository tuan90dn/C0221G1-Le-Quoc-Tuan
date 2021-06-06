package model.bean.contract;

public class ContractDetail {
    public int contract_detail_id;
    public Contract contract_id;
    public AttachService attach_service_id;
    public int quantity;

    public ContractDetail() {
    }

    public ContractDetail(int contract_detail_id, Contract contract_id, AttachService attach_service_id, int quantity) {
        this.contract_detail_id = contract_detail_id;
        this.contract_id = contract_id;
        this.attach_service_id = attach_service_id;
        this.quantity = quantity;
    }

    public int getContract_detail_id() {
        return contract_detail_id;
    }

    public void setContract_detail_id(int contract_detail_id) {
        this.contract_detail_id = contract_detail_id;
    }

    public Contract getContract_id() {
        return contract_id;
    }

    public void setContract_id(Contract contract_id) {
        this.contract_id = contract_id;
    }

    public AttachService getAttach_service_id() {
        return attach_service_id;
    }

    public void setAttach_service_id(AttachService attach_service_id) {
        this.attach_service_id = attach_service_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
