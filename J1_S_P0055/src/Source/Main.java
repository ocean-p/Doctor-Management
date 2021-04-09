/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source;

/**
 *
 * @author DELL
 */
public class Main {
    public static void main(String[] args) {
        Validate v = new Validate();
        ManageDoctor md=new ManageDoctor();
        while(true){
            md.display();
            System.out.println("========= Doctor Management ==========");
            System.out.println("1.	Add Doctor");
            System.out.println("2.	Update Doctor");
            System.out.println("3.	Delete Doctor");
            System.out.println("4.	Search Doctor");
            System.out.println("5.	Exit");
            int choice=v.checkChoice();
            switch(choice){
                case 1: md.addDoc();break;
                case 2: md.updateDoc();  break;
                case 3: md.deleteDoc();  break;
                case 4: md.searchDoc();  break;
                case 5: return;
            }
        }
    }
}
