/* Name : Rahul Ranjan ID# : 111448179*/
package programs;

import java.util.*;
import java.lang.Object;

public class CardStack {
    
    final int CAPACITY = 52;
    Card [] data;
    int top;
    char type;
    
    public CardStack(char type) {
        top = -1;
        data = new Card [CAPACITY];
        this.type = type;
    }
    
    public void push(Card newCard) throws Exception {
        if (top >= CAPACITY ) {
           // System.out.println(top+CAPACITY);
            throw new Exception( "Full Stack Exception");
        }
        top++;
        data[top] = newCard;
    }

    
    public Card pop() {
        Card answer;
        if (top == -1) { // isEmpty()
            throw new EmptyStackException();
        }
        answer = data[top];
        top--;
        return answer;
    }
    public Card peek() {
        Card answer;
        if (top == -1) { // isEmpty()
            throw new EmptyStackException();
        }
        answer = data[top];
        return answer;
    }
    
    public int size() {
        int counter = 0;
        for (int i = 0; i < data.length; i++) {
            counter = counter + 1;
        }
        return counter;
    }
    
    public void printStack(char type,int fcnt) {
        if (type == 's') {
            if (this.top == -1) {
                System.out.print("[ ] ");
            }
            else {
            System.out.print("[XX] ");
            }
        }
        if (type == 'w') {
            if (this.top != -1) {                
            System.out.print(this.peek().toString1() + " ");
            
            }
            else{
              System.out.print("W[ ] "); 
            }
            
        }
        if (type == 'f') {
            if (top!=-1)
            System.out.print(this.peek().toString1() +" ");
            else
                 System.out.print(" [F" +fcnt +"] "); 
                
        }
        if (type == 't') {
            
            int top = this.top;
            String tabStr = "";
            if (this.top != -1 && this.peek().isFaceUp() == false) {
                this.peek().setFaceUp(true);
            }
            if (this.top == -1) {
                System.out.print("[  ]");
                return;
            }
            for (int i = 0; i <= top; i++) {  
               // System.out.print(this.data.length);
                //if (i==this.top)
                Card crd = this.pop();
                if (crd.isFaceUp() == true) {
                    tabStr = crd.toString1() + " " + tabStr;
                    //System.out.print(crd.toString1()+" ");
                }
                else {
                    tabStr = "[XX] " + tabStr;
                    //System.out.print("[XX] ");
                }
            }
            System.out.print(tabStr);
               // else if (this.top==-1)
                //  System.out.print("[ ] "); 
                //else
                     // System.out.print("[XX] "); 
            this.top=top;
        }
    }
}
