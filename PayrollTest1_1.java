// Daniel Jimenez 3/20/2022 
// Revised 11/11/23

import java.util.Scanner;
import java.text.DecimalFormat;

public class PayrollTest1_1{
   public static void main (String[] args){
       Payroll info1 = new Payroll();
       Scanner payInfo = new Scanner(System.in);   
       int hours;
       double payRate;
       double wages;      
       int[] employeeID = {5658845, 4520125, 7895122,
               8477541, 8451277, 1302850,
               7580489
       };
       for (int x = 0; x < employeeID.length; x++) {
           //System.out.println("Employee :" + (i + 1) );
           do {
               System.out.println("Enter the hours worked by employee number " + employeeID[x]+":");
               hours = Integer.parseInt(payInfo.nextLine());
               if (hours < 0){
                System.out.println("Hours must me less than 0!");
               }
           }while (hours < 0);
               info1.setHours(x, hours);

               payRate = 0;
           do {
               
               System.out.println("Enter the hourly pay rate for employee number :" + employeeID[x]+":" );
               payRate = Double.parseDouble(payInfo.nextLine());
               

               if(payRate<6.00)
                   System.out.println("ERROR: Enter 6.00 or greater for pay rate: ");
              
           }
           while (payRate < 6.00);
          
               info1.setPayRate(x, payRate);
               int empid = info1.getEmployeeID(x);
               wages = info1.calculateGrossPay(empid);
               info1.setWages(x, wages);
       }
       DecimalFormat df=new DecimalFormat("##,###.00");
       
       for (int x = 0; x < 7; x++) {
           System.out.println("\tEmployee ID: " + info1.getEmployeeID(x));
           System.out.println("\tGross pay: $" + df.format(info1.getWages(x)));
           System.out.println("");
       }
   }

}

class Payroll{
   private int[] hours = new int[7];
   private double[] payRate = new double[7];
   private double[] wages = new double[7];
   private int[] employeeID = {5658845, 4520125, 7895122,8477541, 
         8451277, 1302850, 7580489
   };
   
   public void setEmployeeID(int index, int ID) {
       employeeID[index] = ID;
   }
   public void setHours(int index, int hour) {
       hours[index] = hour;
   }
   public void setPayRate(int index, double payrate) {
       payRate[index] = payrate;
   }

   public void setWages(int index, double wage) {
       wages[index] = wage;
   }

   public int getEmployeeID(int index) {
       return employeeID[index];
   }

   public int getHours(int index) {
       return hours[index];
   }

   public double getPayRate(int index) {
       return payRate[index];
   }

   public double getWages(int index) {
       return wages[index];
   }
   public double calculateGrossPay(int theEmployeeID) {
       double grossPay = 0;
       int employeeIndex = - 1; 
       for (int x = 0; x < employeeID.length; x++) {
           if (employeeID[x] == theEmployeeID) {
               employeeIndex = x;
           }
       }
       if (employeeIndex != - 1) {
           int h = hours[employeeIndex];
           double r = payRate[employeeIndex];
           grossPay = (h * r); 
       }
       return grossPay;
   }
}