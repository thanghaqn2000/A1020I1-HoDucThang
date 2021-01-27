package furama_resorts.models;

public abstract class Services {
    private String id;
    private String tenDichVu;
    private String kieuThue;
    private int chiPhiThue;
    private int amountMaxPeople;

    public Services() {
    }

    public Services(String id, String tenDichVu, String kieuThue, int chiPhiThue, int amountMaxPeople) {
        this.id = id;
        this.tenDichVu = tenDichVu;
        this.kieuThue = kieuThue;
        this.chiPhiThue = chiPhiThue;
        this.amountMaxPeople = amountMaxPeople;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public String getKieuThue() {
        return kieuThue;
    }

    public void setKieuThue(String kieuThue) {
        this.kieuThue = kieuThue;
    }

    public int getChiPhiThue() {
        return chiPhiThue;
    }

    public void setChiPhiThue(int chiPhiThue) {
        this.chiPhiThue = chiPhiThue;
    }

    public int getAmountMaxPeople() {
        return amountMaxPeople;
    }

    public void setAmountMaxPeople(int amountMaxPeople) {
        this.amountMaxPeople = amountMaxPeople;
    }

    public abstract void showInfor();

}
