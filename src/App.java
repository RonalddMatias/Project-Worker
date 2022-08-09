import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Worker;
import entities.department;
import entities.hourContract;
import entitiesenum.levelworker;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sDateFormat= new SimpleDateFormat("dd/MM/yyyy"); //Essa instância vai servir para ler o falor da data nesse formato de dia, mês e ano.

        System.out.print("Enter department's name: ");
        String departmentName = sc.nextLine();
        System.out.println("Enter worker data: ");
        System.out.print("Name: ");
        String workerName = sc.nextLine();
        System.out.print("Enter worker level: ");
        String workerLevel = sc.nextLine();
        System.out.print("Base Salary: ");
        double baseSalary = sc.nextDouble();

        //é necessário botar o valueOf quando a variavel for string do tipo ENUM
        Worker worker = new Worker(workerName, levelworker.valueOf(workerLevel), baseSalary, new department(departmentName));

        System.out.print("How many contracts to this worker? ");
        int n = sc.nextInt();

        System.out.println();
        for (int i = 1; i<=n; i++) {
            System.out.println("Enter contract #" + i + " data");
            System.out.print("Date (DD/MM/YYYY): ");
            Date contractDate = sDateFormat.parse(sc.next());
            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();
            System.out.print("Duration (hours): ");
            int hours = sc.nextInt();

            //Instanciando o hourContract
            hourContract contract = new hourContract(contractDate, valuePerHour, hours);
            worker.addContract(contract); //O contrato foi associado com o trabalhador atráves de um método criado na class worker.

        }

        System.out.println();
        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0,2)); //Recortando o String e passando para inteiro com o ParseInt
        int year = Integer.parseInt(monthAndYear.substring(3));
        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName()); //O getName() foi necessário para achar o nome do department.
        System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));



        sc.close();
    }
}
