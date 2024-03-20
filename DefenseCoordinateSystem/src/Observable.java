
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nadesshan
 */
public class Observable {
    
    private ArrayList<Observer> observerList=new ArrayList<>();
    
    private String message;
    private String name;
    private String command;
    private int strengthValue;
    private MainController maincontroller;
    private Helicopter helicopter;
    private Tank tank;
    private Submarine submarine;
    
    private static Observable instance =null;
    
    private Observable(){
        maincontroller=new MainController();
        helicopter= new Helicopter();
        tank=new Tank();
        submarine=new Submarine();
        
        maincontroller.setVisible(true);
        helicopter.setVisible(true);
        tank.setVisible(true);
        submarine.setVisible(true);
        
        addObserver(maincontroller);

    }
    
    public void getPositionMessage(int value){
        switch(value){
            case 0 : removeObserver(helicopter);break;
            case 1 : addObserver(helicopter);break;
            case 2 : addObserver(tank);break;
            case 3 : removeObserver(tank);break;
            case 4 : addObserver(submarine);break;
            case 5 : removeObserver(submarine);break;
            
        }
   }
    
    public void addObserver(Observer defenseUnit){
        System.out.println(defenseUnit);
        observerList.add(defenseUnit);
    }
    
    public void removeObserver(Observer defenseUnit){
        observerList.remove(defenseUnit);
    }
    
    public void getMessage(String value, String name ){
        this.name=name;
        this.message=value;
        notifyObservers1();
    }
    
    public void getCommand(String value){
        this.command=value;
        notifyObservers2();
    }
    
    public void getStrengthValue(int value){
        if(value>=0){
            this.strengthValue=value;
            notifyObserver3();
        }
    }
    
    private void notifyObserver3(){
        for(Observer ob: observerList){
            ob.sendStrengthValue(this.strengthValue);
        }
    }
    
    private void notifyObservers2(){
        for(Observer ob: observerList){
            ob.sendCommand(this.command);
        }
    }
    
    private void notifyObservers1(){
        for(Observer ob : observerList){
            ob.update(this.message, this.name);
        }
    }
    public static Observable getInstance(){
        if(instance==null){
            instance=new Observable();
        }
        return instance;
    }

}
    

