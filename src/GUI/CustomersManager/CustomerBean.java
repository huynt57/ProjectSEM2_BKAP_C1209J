/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.CustomersManager;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class CustomerBean {

    private int customerCode;
    private String customerName;
    private String customerType;
    private String customerPhone;
    private String customerFax;
    private String customerEmail;
    private String customerAddress;
    private String customerRelationship;

    public int getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(int customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerFax() {
        return customerFax;
    }

    public void setCustomerFax(String customerFax) {
        this.customerFax = customerFax;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerRelationship() {
        return customerRelationship;
    }

    public void setCustomerRelationship(String customerRelationship) {
        this.customerRelationship = customerRelationship;
    }

    public CustomerBean(int customerCode, String customerName, String customerType, String customerPhone, String customerFax, String customerEmail, String customerAddress, String customerRelationship) {
        this.customerCode = customerCode;
        this.customerName = customerName;
        this.customerType = customerType;
        this.customerPhone = customerPhone;
        this.customerFax = customerFax;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.customerRelationship = customerRelationship;
    }

    public CustomerBean() {
    }
}
