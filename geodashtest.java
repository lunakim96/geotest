import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class geodashtest extends PApplet {

int sizeX = 900;
int sizeY = 400;
float deg = 0;
float velY = 0;
float Px = 100;
float Py = sizeY - 113; 
float Pxc1= 850;
float Pyc1= sizeY -110;
float Pxc2= 850;
float Pyc2= sizeY -110;
int time;
int cloneNum=1;

public void setup(){
 
time = millis();
}

public void draw(){
 background(100,100,100);
 velY = velY - .2f;
 rectMode(CORNER);
 fill(0,0,0);
 rect(0,sizeY-100, 900,175);
 fill(255,255,255);
 rectMode(CENTER);
 if(Py > (sizeY-113)){
  velY = 0; 
  if(keyPressed == true){ if(keyCode == UP){
   velY = 5; 
  }}}
   Py = Py - velY;
  
     if(millis() - time >1000){
       if(cloneNum == 1){
    clone1();
    }
    else if(cloneNum == 2){
    clone2();
    }
         if(millis() - time >2400){
    time = millis();
     if(cloneNum == 1){
    cloneNum =2;
    }
    else if(cloneNum == 2){
    cloneNum =1;
    }
       Pxc1 = 850;
       Pxc2 = 850;

     }}
     pushMatrix();
   translate(Px, Py);

 if(velY > 0){
  for (int i = 0; i < 361; i++){
  deg = deg +3;
    rotate(radians(deg)); 
  }
 }
 else if (velY < 0){
     for (int j = 0; j < 361; j++){
deg=deg+3;
 rotate(radians(deg)); 
      }
 }
 fill(0,0,0);
 rect(0,0, 25,25);
 popMatrix();
}

public void clone1(){
  Pxc1 = Pxc1 - 10; 
 if(Pxc1<0){
   Pxc1 = 850;
 }
 fill(255,0,0);
 rect (Pxc1, Pyc1, 20, 20);
 
}public void clone2(){
  Pxc2 = Pxc2 - 10; 
 if(Pxc2<0){
   Pxc2 = 850;
 }
 fill(255,0,0);
 rect (Pxc2, Pyc2, 40, 20);
 
}
  public void settings() { 
size(900, 400); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "geodashtest" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
