package xyz.lzbin.shop.pojo;

public class Logistics {
    private Integer id;

    private String logisticsNumber;

    private String receiver;

    private String tel;

    private String logisticsCom;

    private String logisticsAddr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogisticsNumber() {
        return logisticsNumber;
    }

    public void setLogisticsNumber(String logisticsNumber) {
        this.logisticsNumber = logisticsNumber;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getLogisticsCom() {
        return logisticsCom;
    }

    public void setLogisticsCom(String logisticsCom) {
        this.logisticsCom = logisticsCom;
    }

    public String getLogisticsAddr() {
        return logisticsAddr;
    }

    public void setLogisticsAddr(String logisticsAddr) {
        this.logisticsAddr = logisticsAddr;
    }
}