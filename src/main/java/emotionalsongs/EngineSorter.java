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
        e.sortIntArray(interi);
        String stringaOrdinata = "";
        for (int i = 0; i < interi.length; i++) {
            stringaOrdinata += i<interi.length-1? interi[i]+",":interi[i]+".";
        }
        System.out.println(stringaOrdinata);
    }
    */
    
    //User sort methods
    public void sortUsersById(DataBaseUsers dataBaseUsers){
        HeapUtentiId heap = new HeapUtentiId(dataBaseUsers);
        heap.buildBU();
        for(int i = dataBaseUsers.getSize()-1;i>=0;i++){ 
            dataBaseUsers.replace(i, heap.delete());
        } 
    }
    
    public void sortUserByCf(DataBaseUsers dataBaseUsers){
        HeapUtentiCf heap = new HeapUtentiCf(dataBaseUsers);
        heap.buildBU();
        for(int i = dataBaseUsers.getSize()-1;i>=0;i++){ 
            dataBaseUsers.replace(i, heap.delete());
        }  
    }
    
    void sortUserArrayById(User[] usersArray) {
        HeapUtentiId heap = new HeapUtentiId(usersArray);
        heap.buildBU();
        for(int i = usersArray.length-1;i>=0;i--){
            usersArray[i] = heap.delete();
        } 
    }
    
    void sortUserArrayByCf(User[] usersArray){
        HeapUtentiCf heap = new HeapUtentiCf(usersArray);
        heap.buildBU();
        for(int i = usersArray.length-1;i>=0;i++){ 
            usersArray[i] = heap.delete();
        }
    }
    
    void sortTracksByTags(Song[] arrayBrani){
        HeapTagBrani heap = new HeapTagBrani(arrayBrani);
        heap.buildBU();
        for(int i = 0;i<arrayBrani.length;i++){
            arrayBrani[i] = heap.delete();
        }
    }
   
    //Tracks sort methods
    void sortTracksByTitles(Song[] arrayBrani) {
        HeapTitleBrani heap = new HeapTitleBrani(arrayBrani);
        heap.buildBU();
        for(int i = 0;i<arrayBrani.length;i++){
            arrayBrani[i] = heap.delete();
        }
    }

    void sortTracksByAuthors(Song[] arrayBrani) {
        HeapAuthorBrani heap = new HeapAuthorBrani(arrayBrani);
        heap.buildBU();
        for(int i = 0;i<arrayBrani.length;i++){
            arrayBrani[i] = heap.delete();
        }
    }
    
    // records sort method
    void sortRecords(DataBaseRecords dataBaseEmozioni){
        Record[] array = dataBaseEmozioni.getArray();
        HeapRecords heap = new HeapRecords(dataBaseEmozioni);
        heap.buildBU();
        for(int i = dataBaseEmozioni.getSize()-1;i>=0;i--){
            array[i] = heap.delete();
        }
    }
    
    //Playlist sort methods
    void sortPlaylistSet(PlaylistSet playlistSet){
        HeapPlayListSet heap = new HeapPlayListSet(playlistSet);
        heap.buildBU();
        Playlist[] ordered = playlistSet.getArray();
        for (int i = playlistSet.getSize(); i >=0; i++) {
            ordered[i] = heap.delete();
        }
    }
    
    void sortDataBase(DataBasePlaylists dataBasePlaylists){
        HeapDataBaseSets heap = new HeapDataBaseSets(dataBasePlaylists);
        heap.buildBU();
        PlaylistSet[] ordered = dataBasePlaylists.getArray();
        for (int i = dataBasePlaylists.getSize()-1; i >=0; i++) {
            ordered[i] = heap.delete();
        }
    }
    
    void sortDatabase(DataBasePlaylists dataBase){
        HeapDataBaseSets heap = new HeapDataBaseSets(dataBase);
        heap.buildBU();
        PlaylistSet[] ordered = dataBase.getArray();
        for (int i = dataBase.getSize(); i >=0; i++) {
            ordered[i] = heap.delete();
        }
    }
    
    //General sort methods
    void sortIntArray(int[] arrayInt) {
        HeapInt heap = new HeapInt(arrayInt);
        heap.buildBU();
        for (int i = arrayInt.length-1; i>=0; i--) {
            arrayInt[i] = heap.delete();
        }
    }
    
    void sortStringsArray(String[] arrayString){
        HeapString heap = new HeapString(arrayString);
        heap.buildBU();
        for (int i = arrayString.length-1; i>=0; i--) {
            arrayString[i] = heap.delete();
        }
    }
     
    //Strutture dati speciali User
    private class HeapUtentiId {
        private User[] arrayUtenti;
        private User[] pq;
        private int n=0;
    
        public HeapUtentiId(User[] array){
            arrayUtenti = array;
            pq = new User[array.length+1];
        }
        
        public HeapUtentiId(DataBaseUsers database){
           this(database.getDatabase());
        }
        
        public boolean isEmpty(){
            return n==0;
        }
    
        public int size(){
            return n;
        }
 
        public void insert(User v){
            pq[++n]=v;
            swim(n);
        }
        
        public User read(){
            return pq[1];
        }
    
        public User delete(){
            User max=pq[1];
            exch(1,n--);
            pq[n+1]=null;
            sink(1);
            return max;
        }
    
        private boolean precede(int i,int j){
            return (pq[i].getUserId().toLowerCase()).compareTo(pq[j].getUserId().toLowerCase())<0;
        }
    
        private void exch(int i,int j){
            User t=pq[i];
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
        private User[] arrayUtenti;
        private User[] pq;
        private int n=0;
    
        public HeapUtentiCf(User[] array){
            arrayUtenti = array;
            pq = new User[array.length+1];
        }
        
        public HeapUtentiCf(DataBaseUsers database){
           this(database.getDatabase());
        }
        
        public boolean isEmpty(){
            return n==0;
        }
    
        public int size(){
            return n;
        }
 
        public void insert(User v){
            pq[++n]=v;
            swim(n);
        }
        
        public User read(){
            return pq[1];
        }
    
        public User delete(){
            User max=pq[1];
            exch(1,n--);
            pq[n+1]=null;
            sink(1);
            return max;
        }
    
        private boolean precede(int i,int j){
            return (pq[i].getCF().toLowerCase()).compareTo(pq[j].getCF().toLowerCase())<0;
        }
    
        private void exch(int i,int j){
            User t=pq[i];
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
    
    //Strutture dati speciali Song
    private class HeapTagBrani{
        
        private Song[] arrayBrani;
        private Song[] pq;
        private int n=0;
    
        public HeapTagBrani(Song[] brani){
            arrayBrani = brani;
            pq = new Song[brani.length+1];
        }
        
        public boolean isEmpty(){
            return n==0;
        }
    
        public int size(){
            return n;
        }
 
        public void insert(Song brano){
            pq[++n]=brano;
            swim(n);
        }
        
        public Song read(){
            return pq[1];
        }
    
        public Song delete(){
            Song max=pq[1];
            exch(1,n--);
            pq[n+1]=null;
            sink(1);
            return max;
        }
    
        private boolean isBefore(int i,int j){
            return (pq[i].getTag()).compareTo(pq[j].getTag())<0;
        }
    
        private void exch(int i,int j){
            Song t=pq[i];
            pq[i]=pq[j];
            pq[j] = t;
        }
    
        private void swim(int k){
            while(k>1&&isBefore(k/2,k)){
                exch(k/2,k);
                k=k/2;
            }
        }
    
        private void sink(int k){
            while(2*k<=n){
                int j=2*k;
                if(j<n&&isBefore(j,j+1))j++;
                if(!isBefore(k,j))break;
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
    
    private class HeapTitleBrani{
        private Song[] arrayBrani;
        private Song[] pq;
        private int n=0;
    
        public HeapTitleBrani(Song[] brani){
            arrayBrani = brani;
            pq = new Song[brani.length+1];
        }
        
        public boolean isEmpty(){
            return n==0;
        }
    
        public int size(){
            return n;
        }
 
        public void insert(Song brano){
            pq[++n]=brano;
            swim(n);
        }
        
        public Song read(){
            return pq[1];
        }
    
        public Song delete(){
            Song max=pq[1];
            exch(1,n--);
            pq[n+1]=null;
            sink(1);
            return max;
        }
    
        private boolean isBefore(int i,int j){
            return (pq[i].getTitle()).compareTo(pq[j].getTitle())<0;
        }
    
        private void exch(int i,int j){
            Song t=pq[i];
            pq[i]=pq[j];
            pq[j] = t;
        }
    
        private void swim(int k){
            while(k>1&&isBefore(k/2,k)){
                exch(k/2,k);
                k=k/2;
            }
        }
    
        private void sink(int k){
            while(2*k<=n){
                int j=2*k;
                if(j<n&&isBefore(j,j+1))j++;
                if(!isBefore(k,j))break;
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
    
    private class HeapAuthorBrani{
        private Song[] arrayBrani;
        private Song[] pq;
        private int n=0;
    
        public HeapAuthorBrani(Song[] brani){
            arrayBrani = brani;
            pq = new Song[brani.length+1];
        }
        
        public boolean isEmpty(){
            return n==0;
        }
    
        public int size(){
            return n;
        }
 
        public void insert(Song brano){
            pq[++n]=brano;
            swim(n);
        }
        
        public Song read(){
            return pq[1];
        }
    
        public Song delete(){
            Song max=pq[1];
            exch(1,n--);
            pq[n+1]=null;
            sink(1);
            return max;
        }
    
        private boolean isBefore(int i,int j){
            return (pq[i].getAuthor()).compareTo(pq[j].getAuthor())<0;
        }
    
        private void exch(int i,int j){
            Song t=pq[i];
            pq[i]=pq[j];
            pq[j] = t;
        }
    
        private void swim(int k){
            while(k>1&&isBefore(k/2,k)){
                exch(k/2,k);
                k=k/2;
            }
        }
    
        private void sink(int k){
            while(2*k<=n){
                int j=2*k;
                if(j<n&&isBefore(j,j+1))j++;
                if(!isBefore(k,j))break;
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
    
    //strutture dati speciali records
    private class HeapRecords{
        private Record[] arrayRecords;
        private Record[] pq;
        private int n=0;
    
        public HeapRecords(DataBaseRecords dataBaseEmozioni){
            arrayRecords = dataBaseEmozioni.getArray();
            pq = new Record[arrayRecords.length+1];
        }
        
        public boolean isEmpty(){
            return n==0;
        }
    
        public int size(){
            return n;
        }
 
        public void insert(Record record){
            pq[++n]=record;
            swim(n);
        }
        
        public Record read(){
            return pq[1];
        }
    
        public Record delete(){
            Record max=pq[1];
            exch(1,n--);
            pq[n+1]=null;
            sink(1);
            return max;
        }
    
        private boolean isBefore(int i,int j){
            return (pq[i].getTag()).compareTo(pq[j].getTag())<0;
        }
    
        private void exch(int i,int j){
            Record t=pq[i];
            pq[i]=pq[j];
            pq[j] = t;
        }
    
        private void swim(int k){
            while(k>1&&isBefore(k/2,k)){
                exch(k/2,k);
                k=k/2;
            }
        }
    
        private void sink(int k){
            while(2*k<=n){
                int j=2*k;
                if(j<n&&isBefore(j,j+1))j++;
                if(!isBefore(k,j))break;
                exch(k,j);
                k=j;
            }
        }   
    
        public void buildBU(){
            if(arrayRecords.length<pq.length){
                n=arrayRecords.length;
                for(int i=0;i<arrayRecords.length;i++) pq[i+1]=arrayRecords[i];
                for(int i=n/2;i>=1;i--) sink(i);
            } 
        }   
    }
    
    //special structure Playlist
    private class HeapPlayListSet{
        private Playlist[] array;
        private Playlist[] pq;
        private int n=0;
    
        public HeapPlayListSet(PlaylistSet playlistSet){
            array = playlistSet.getArray();
            pq = new Playlist[array.length+1];
        }
        
        public boolean isEmpty(){
            return n==0;
        }
    
        public int size(){
            return n;
        }
 
        public void insert(Playlist playlist){
            pq[++n]=playlist;
            swim(n);
        }
        
        public Playlist read(){
            return pq[1];
        }
    
        public Playlist delete(){
            Playlist max=pq[1];
            exch(1,n--);
            pq[n+1]=null;
            sink(1);
            return max;
        }
    
        private boolean isBefore(int i,int j){
            return (pq[i].getName()).compareTo(pq[j].getName())<0;
        }
    
        private void exch(int i,int j){
            Playlist t=pq[i];
            pq[i]=pq[j];
            pq[j] = t;
        }
    
        private void swim(int k){
            while(k>1&&isBefore(k/2,k)){
                exch(k/2,k);
                k=k/2;
            }
        }
    
        private void sink(int k){
            while(2*k<=n){
                int j=2*k;
                if(j<n&&isBefore(j,j+1))j++;
                if(!isBefore(k,j))break;
                exch(k,j);
                k=j;
            }
        }   
    
        public void buildBU(){
            if(array.length<pq.length){
                n=array.length;
                for(int i=0;i<array.length;i++) pq[i+1]=array[i];
                for(int i=n/2;i>=1;i--) sink(i);
            } 
        }   
    }
    
    class HeapDataBaseSets {
        private PlaylistSet[] array;
        private PlaylistSet[] pq;
        private int n=0;
    
        public HeapDataBaseSets(DataBasePlaylists dataBasePlaylists){
            array = dataBasePlaylists.getArray();
            pq = new PlaylistSet[array.length+1];
        }
        
        public boolean isEmpty(){
            return n==0;
        }
    
        public int size(){
            return n;
        }
 
        public void insert(PlaylistSet playlist){
            pq[++n]=playlist;
            swim(n);
        }
        
        public PlaylistSet read(){
            return pq[1];
        }
    
        public PlaylistSet delete(){
            PlaylistSet max=pq[1];
            exch(1,n--);
            pq[n+1]=null;
            sink(1);
            return max;
        }
    
        private boolean isBefore(int i,int j){
            return (pq[i].getOwnerId()).compareTo(pq[j].getOwnerId())<0;
        }
    
        private void exch(int i,int j){
            PlaylistSet t=pq[i];
            pq[i]=pq[j];
            pq[j] = t;
        }
    
        private void swim(int k){
            while(k>1&&isBefore(k/2,k)){
                exch(k/2,k);
                k=k/2;
            }
        }
    
        private void sink(int k){
            while(2*k<=n){
                int j=2*k;
                if(j<n&&isBefore(j,j+1))j++;
                if(!isBefore(k,j))break;
                exch(k,j);
                k=j;
            }
        }   
    
        public void buildBU(){
            if(array.length<pq.length){
                n=array.length;
                for(int i=0;i<array.length;i++) pq[i+1]=array[i];
                for(int i=n/2;i>=1;i--) sink(i);
            } 
        } 
    }
    
    //Strutture dati generali
    private class HeapString{
        private String[] arrayString;
        private String[] pq;
        private int n=0;
    
        public HeapString(String[] array){
            arrayString = array;
            pq = new String[array.length+1];
        }
        
        public boolean isEmpty(){
            return n==0;
        }
    
        public int size(){
            return n;
        }
 
        public void insert(String v){
            pq[++n]=v;
            swim(n);
        }
        
        public String read(){
            return pq[1];
        }
    
        public String delete(){
            String max=pq[1];
            exch(1,n--);
            pq[n+1] = null;
            sink(1);
            return max;
        }
    
        private boolean isBefore(int i,int j){
            return pq[i].compareTo(pq[j])<0;
        }
    
        private void exch(int i,int j){
            String t=pq[i];
            pq[i]=pq[j];
            pq[j] = t;
        }
    
        private void swim(int k){
            while(k>1&&isBefore(k/2,k)){
                exch(k/2,k);
                k=k/2;
            }
        }
    
        private void sink(int k){
            while(2*k<=n){
                int j=2*k;
                if(j<n&&isBefore(j,j+1))j++;
                if(!isBefore(k,j))break;
                exch(k,j);
                k=j;
            }
        }   
    
        public void buildBU(){
            if(arrayString.length<pq.length){
                n=arrayString.length;
                for(int i=0;i<arrayString.length;i++) pq[i+1]=arrayString[i];
                for(int i=n/2;i>=1;i--) sink(i);
            } 
        } 
    }
    
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

