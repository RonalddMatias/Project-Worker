package entities;

import java.util.Date;

public class hourContract {
    private Date date;
    private Double valuePerHour;
    private Integer hours;

    public hourContract() {   
    }

    public hourContract(Date date, Double valuePerHour, Integer hours) {
        this.date = date;
        this.valuePerHour = valuePerHour;
        this.hours = hours;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getValuePerHour() {
        return valuePerHour;
    }

    public void setValuePerHour(Double valuePerHour) {
        this.valuePerHour = valuePerHour;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    //Método que vai dizer a quantidade de horas do contrato.
    public double totalValue() {
        return valuePerHour * hours;
    }
}
