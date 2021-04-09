/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source;

import java.util.Collections;
import java.util.Vector;

/**
 *
 * @author DELL
 */
public class ManageDoctor extends Vector<Doctor> {
    Validate vv = new Validate();
     public ManageDoctor(){
        super();
    }
    private int find(String aCode){
        for(int i=0; i<this.size(); i++){
            if(this.get(i).getCode().equals(aCode)){
                return i;
            }
        }
        return -1;
    }
    private int findName(String aName){
        for(int i=0; i<this.size(); i++){
            if(this.get(i).getName().contains(aName)){
                return i;
            }
        }
        return -1;
    }
   
    public void addDoc(){
        System.out.println("--------- Add Doctor ----------");
        String code,name,spec;
        int ava,pos;
        do{
            code=vv.checkCode();
            pos=find(code);
            if(pos>=0) System.err.println("This code is duplicate");
        }while(pos>=0);
        name=vv.checkString("Enter name: ", "Name not null");
        spec=vv.checkString("Enter Specialization: ", "Specialization not null");
        ava=vv.checkAva();
        this.add(new Doctor(code,name,spec,ava));
        System.out.println("New Doctor "+code +" has been added");
    }
    public void updateDoc(){
//        if(this.size()==0){
//            System.err.println("Empty List");
//            return;
//        }
         System.out.println("--------- Update Doctor -------");
         String code=vv.checkCode();
         int pos=find(code);
         if(pos<0){
             System.err.println("This code does not exist");
         }
         else{
             String newName=vv.checkString("Enter new name: ", "Name not null");
             String newSpec=vv.checkString("Enter new Spec: ", "Spec not null");
             int ava=vv.checkAva();
             this.get(pos).setName(newName);
             this.get(pos).setSpecialization(newSpec);
             this.get(pos).setAvailability(ava);
             System.out.println("The Doctor "+code+" has been updated");
         }
    }
    public void deleteDoc(){
//        if(this.size()==0){
//            System.err.println("Empty List");
//            return;
//        }
        System.out.println("------ Delete Doctor -------");
        String code = vv.checkCode();
        int pos=find(code);
        if(pos<0){
            System.err.println("this code does not exist");
        }
        else{
            this.remove(pos);
            System.out.println("The Doctor "+code+" has been deleted");
        }
    }
    public void searchDoc(){
//        if(this.size()==0){
//            System.err.println("Empty List");
//            return;
//        }
        System.out.println("---------- Search Doctor --------");
        String name=vv.checkString("Enter name: ", "Name not null");
        int pos=findName(name);
        if(pos<0){
            System.err.println("this name "+name+" does not exist");
        }
        else{
            System.out.println("--------- Result ------------");
            System.out.printf("%7s%20s%20s%20s\n","Code","Name","Specialization","Availability");
            for(int i=0; i<this.size(); i++){
                if(this.get(i).getName().contains(name)){
                    this.get(i).print();
                }
            }
            System.out.println("-------------------------------");
//            System.out.println("--------- Result ------------");
//            this.get(pos).print();
        }
    }
    public void display(){
        if(this.size()==0){
            System.err.println("Empty List");
            return;
        }
        Collections.sort(this);
        System.out.println("---------------DOCTOR LIST---------------");
        System.out.printf("%7s%20s%20s%20s\n","Code","Name","Specialization","Availability");
        for(Doctor x:this) x.print();
    }
}
