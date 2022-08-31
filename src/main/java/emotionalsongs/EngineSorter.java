package emotionalsongs;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author big
 */
public class EngineSorter {
    /*
    public static void main(String[] args) {
        int[] interi ={1,9,4,7,36,259,123,234,345,1000,33,29465};

        EngineSorter e = new EngineSorter();
        e.riordinaArrayInt(interi);
        String stringaOrdinata = "";
        for (int i = 0; i < interi.length; i++) {
            stringaOrdinata += i<interi.length-1? interi[i]+",":interi[i]+".";
        }
        System.out.println(stringaOrdinata);
    }
    */
    //metodi di ordinamento
    public void sortDatabaseById(DataBaseUtenti database){
        sortUserArrayById(database.getArrayData()); 
    }//Tramite heapSort riordina il database secondo UserId
    
    public void sortDatabaseByCf(DataBaseUtenti database){
        HeapUtentiCf heap = new HeapUtentiCf(database);
        heap.buildBU();
        for(int i = database.getDimensione()-1;i>=0;i++){ 
            database.sostituisciIndice(i, heap.delete());
        }  
    }//Tramite heapSort riordina un array di utenti secondo CF

    void riordinaArrayInt(int[] arrayInt) {
        HeapInt heap = new HeapInt(arrayInt);
        heap.buildBU();
        for (int i = arrayInt.length-1; i>=0; i--) {
            arrayInt[i] = heap.delete();
        }
    }//Tramite heapSort riordina un array di interi
    
    void sortRepoByTags(Brano[] arrayBrani){
        HeapTagBrani heap = new HeapTagBrani(arrayBrani);
        heap.buildBU();
        for(int i = 0;i<arrayBrani.length;i++){
            arrayBrani[i] = heap.delete();
        }
    }

    void sortUserArrayById(Utente[] arrayUtenti) {
        HeapUtentiId heap = new HeapUtentiId(arrayUtenti);
        heap.buildBU();
        for(int i = arrayUtenti.length-1;i>=0;i--){
            arrayUtenti[i] = heap.delete();
        } 
    }
    
    //Strutture dati speciali Utente
    private class HeapUtentiId {
        private Utente[] arrayUtenti;
        private Utente[] pq;
        private int n=0;
    
        public HeapUtentiId(Utente[] array){
            arrayUtenti = array;
            pq = new Utente[array.length+1];
        }
        
        public HeapUtentiId(DataBaseUtenti database){
           this(database.getArrayData());
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
            return (pq[i].getUserId().toLowerCase()).compareTo(pq[j].getUserId().toLowerCase())<0;
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
    
        public void buildBU(){
            if(arrayUtenti.length<pq.length){
                n=arrayUtenti.length;
                for(int i=0;i<arrayUtenti.length;i++) pq[i+1]=arrayUtenti[i];
                for(int i=n/2;i>=1;i--) sink(i);
            } 
        }   
    }
    
    private class HeapUtentiCf {
        private Utente[] arrayUtenti;
        private Utente[] pq;
        private int n=0;
    
        public HeapUtentiCf(Utente[] array){
            arrayUtenti = array;
            pq = new Utente[array.length+1];
        }
        
        public HeapUtentiCf(DataBaseUtenti database){
           this(database.getArrayData());
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
            return (pq[i].getCF().toLowerCase()).compareTo(pq[j].getCF().toLowerCase())<0;
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
    
        public void buildBU(){
            if(arrayUtenti.length<pq.length){
                n=arrayUtenti.length;
                for(int i=0;i<arrayUtenti.length;i++) pq[i+1]=arrayUtenti[i];
                for(int i=n/2;i>=1;i--) sink(i);
            } 
        }   
    }
    
    //Strutture dati speciali Brano
    private class HeapTagBrani{
        
        private Brano[] arrayBrani;
        private Brano[] pq;
        private int n=0;
    
        public HeapTagBrani(Brano[] brani){
            arrayBrani = brani;
            pq = new Brano[brani.length+1];
        }
        
        public boolean isEmpty(){
            return n==0;
        }
    
        public int size(){
            return n;
        }
 
        public void insert(Brano brano){
            pq[++n]=brano;
            swim(n);
        }
        
        public Brano read(){
            return pq[1];
        }
    
        public Brano delete(){
            Brano max=pq[1];
            exch(1,n--);
            pq[n+1]=null;
            sink(1);
            return max;
        }
    
        private boolean precede(int i,int j){
            return (pq[i].getTag()).compareTo(pq[j].getTag())<0;
        }
    
        private void exch(int i,int j){
            Brano t=pq[i];
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
    
        public void buildBU(){
            if(arrayBrani.length<pq.length){
                n=arrayBrani.length;
                for(int i=0;i<arrayBrani.length;i++) pq[i+1]=arrayBrani[i];
                for(int i=n/2;i>=1;i--) sink(i);
            } 
        }   
    }
    
    //Strutture dati generali
    private class HeapInt{
        private int[] arrayInt;
        private int[] pq;
        private int n=0;
    
        public HeapInt(int[] array){
            arrayInt = array;
            pq = new int[array.length+1];
        }
        
        public boolean isEmpty(){
            return n==0;
        }
    
        public int size(){
            return n;
        }
 
        public void insert(int v){
            pq[++n]=v;
            swim(n);
        }
        
        public int read(){
            return pq[1];
        }
    
        public int delete(){
            int max=pq[1];
            exch(1,n--);
            pq[n+1]=0;
            sink(1);
            return max;
        }
    
        private boolean less(int i,int j){
            return pq[i]<pq[j];
        }
    
        private void exch(int i,int j){
            int t=pq[i];
            pq[i]=pq[j];
            pq[j] = t;
        }
    
        private void swim(int k){
            while(k>1&&less(k/2,k)){
                exch(k/2,k);
                k=k/2;
            }
        }
    
        private void sink(int k){
            while(2*k<=n){
                int j=2*k;
                if(j<n&&less(j,j+1))j++;
                if(!less(k,j))break;
                exch(k,j);
                k=j;
            }
        }   
    
        public void buildBU(){
            if(arrayInt.length<pq.length){
                n=arrayInt.length;
                for(int i=0;i<arrayInt.length;i++) pq[i+1]=arrayInt[i];
                for(int i=n/2;i>=1;i--) sink(i);
            } 
        } 
    }
}

