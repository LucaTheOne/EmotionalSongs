package emotionalsongs;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author big
 */
public class SortEngine {
    
}

class HeapUtenti{
    UserDatabase database = EMOTIONALSONGS.userDatabase;
    private Utente[] imported = database.getArray();
    private Utente[] pq;
    private int n=0;
    
    public HeapUtenti(){
        pq = new Utente[imported.length+1];
    }
    
    public boolean isEmpty(){
        return n==0;
    }
    
    public int size(){
        return n;
    }
 
    public void insert(Utente v){
        pq[++n]=v;
        swim(n);
    }
    public Utente read(){
        return pq[1];
    }
    
    public Utente delete(){
        Utente max=pq[1];
        exch(1,n--);
        pq[n+1]=null;
        sink(1);
        return max;
    }
    
    private boolean precede(int i,int j){
        return (pq[i].getUserId()).compareTo(pq[j].getUserId())<0;
    }
    
    private void exch(int i,int j){
        Utente t=pq[i];
        pq[i]=pq[j];
        pq[j] = t;
    }
    
    private void swim(int k){
        while(k>1&&precede(k/2,k)){
            exch(k/2,k);
            k=k/2;
        }
    }
    
    private void sink(int k){
        while(2*k<=n){
            int j=2*k;
            if(j<n&&precede(j,j+1))j++;
            if(!precede(k,j))break;
            exch(k,j);
            k=j;
        }
    }
    
    public void buildBU(Utente[] array){
        if(array.length<pq.length){
            n=array.length;
            for(int i=0;i<array.length;i++) pq[i+1]=array[i];
            for(int i=n/2;i>=1;i--) sink(i);
        } 
    }
    
}