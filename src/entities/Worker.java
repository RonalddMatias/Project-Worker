package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entitiesenum.levelworker;

public class Worker {
    //Atributos básicos do projeto principal
    private String name;
    private levelworker level;
    private Double baseSalary;

    //Associações ligadas ao projeto principal
    private department department;
    private List<hourContract> contracts = new ArrayList<>(); //A lista já deve ser instânciada

    public Worker(){
    }

    //Contrutor criado SEM atributo que contem LISTA.
    public Worker(String name, levelworker level, Double baseSalary, department department) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public levelworker getLevel() {
        return level;
    }

    public void setLevel(levelworker level) {
        this.level = level;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public department getDepartment() {
        return department;
    }

    public void setDepartment(department department) {
        this.department = department;
    }

    public List<hourContract> getContracts() {
        return contracts;
    }


    //Métodos do programa
    public void addContract(hourContract contract) {
        contracts.add(contract);
    }

    // "contract" --> informado como argumento do método
    public void removeContract(hourContract contract){
        contracts.remove(contract);
    }

    public double income(int year, int month){
        double sum = baseSalary;
        Calendar cal = Calendar.getInstance();
        for (hourContract c : contracts) {
            cal.setTime(c.getDate());
            int c_year = cal.get(Calendar.YEAR);
            int c_month = 1 + cal.get(Calendar.MONTH);
            if(year == c_year && month == c_month) {
                sum += c.totalValue();
            }
        }
    }

    
    
    
}
