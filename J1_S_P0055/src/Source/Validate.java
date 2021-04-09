/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source;

import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Validate {
    Scanner sc = new Scanner(System.in);
    
    public int checkChoice(){
        while(true){
            try {
                System.out.print("Your choice: ");
                int choice = Integer.parseInt(sc.nextLine());
                if(choice>=1 && choice<=5){
                    return choice;
                }
                else{
                    System.err.println("Choice within 1-5");
                }
            } catch (Exception e) {
                System.err.println("Invalid number");
            }
        }
    }
    public String checkString(String a, String b){
        while(true){
            System.out.print(a);
            String check = sc.nextLine().toUpperCase();
            if(check.trim().isEmpty()){
                System.err.println(b);
            }
             else if(check.matches("^.*[ ]{2,}.*$")){
                System.err.println("Too much space!!");
            }
            else if(!check.matches("^[A-Za-z ]+$")){
                System.err.println("Not contains special character and number");
            }
            else{
                return check;
            }
        }
    }
    public int checkAva(){
        while(true){
            try {
                System.out.print("Enter Availability: ");
                int ava = Integer.parseInt(sc.nextLine());
                if(ava>=1){
                    return ava;
                }
                else{
                    System.err.println("Must be greater than 0");
                }
            } catch (Exception e) {
                System.err.println("Invalid availability");
            }
        }
    }
    public String checkCode(){
        while(true){
            System.out.print("Enter code: ");
            String s= sc.nextLine().toUpperCase();
            if(s.trim().isEmpty()){
                System.err.println("Code not null");
            }
           
            else if(!s.matches("^DOC[0-9]+$")){
                System.err.println("Code must be DOC and number");
            }
            else{
                return s;
            }
        }
    }
    
}
