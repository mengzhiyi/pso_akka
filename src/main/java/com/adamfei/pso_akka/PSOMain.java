package com.adamfei.pso_akka;

import akka.actor.ActorSystem;  
import akka.actor.Props;  
  
public class PSOMain {  
  
    public static final int BIRD_COUNT = 2000000;  
      
    public static void main(String args[]) {  
          
        // 创建Actor的管理和维护系统  
        ActorSystem system = ActorSystem.create("psoSystem");  
        // 创建Master粒子  
        system.actorOf(Props.create(MasterBird.class), "masterbird");  
        // 创建Bird粒子群  
        for(int i=0; i<BIRD_COUNT; i++) {  
            system.actorOf(Props.create(Bird.class), "bird_" + i);  
        }         
    }     
}  