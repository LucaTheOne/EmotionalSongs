# Emotional Songs
### Progetto di Laboratorio A e B AA.AA. 2021/22 - 2022/23

Autori:

- Luca Bolelli - 749137
- Natanail Danailov - 739887
- Riccardo Maria Rosarin - 749914
- Eleonora Macchi - 748736

Installazione: 
    Per l' installazione dei software client-server consultare la documentazione ufficiale al sito: https://emotionalsongs.eu/.

Importazione del progetto su ide:
    Il progetto è basato sul repository di Maven, pertanto per aprirlo bisogna aprire il proprio ide ed aggiungere il progetto che si trova nella cartella contenente questo stesso file di testo.
    Qualora si volesse avviare il Client di questo software è sufficiente eseguire il progetto oppure il file emotionalsongs.EmotionalSongs.java; qualora si volesse, invece, avviarne il Sever bisognerà Eseguire il file serverEs.ServerES.java.
    Nel file pom del progetto sono contenute anche le istruzioni per permettere al ide di creare un file .jar del progetto, tuttavia per come è attualmente impostato, il jar prodotto eseguirà soltanto il client, qual' ora si volesse invece un .jar che esegua il server sarà necessario effettuare la seguente procedura:
    - Aprire il file pom.xml con un editor di testo.
    - Scorrere in basso fino ad incontrare la riga 64 del file: 
        <mainClass>emotionalsongs.EmotionalSongs</mainClass>
    - Sostiture il testo emotionalsongs.EmotionalSongs con serverES.ServerEs.

    Alternativamente sul sito prima citato sono disponibili i progetti sia del client che del server separati e pronti per essere avviati da ide, compilati ed inseriti in un file .jar adeguatamente.

NB: i .jar eseguibili saranno generati nella cartella target, selezionare il file che termina con "with-dependencies.jar".

Librerie esterne utilizzate:
    il file pom.xml contiene già le istruzioni per far si che maven importi direttamente dal suo DB le librerie necessarie, che comunque verranno qui elencate:

    AbsoluteLayout-RELEASE130
    commons-lang3-3.1
    commons-validator 
    javaee-api-8.0.1
    jfreechart-1.0.13 -> generazione di grafici.
    jsoup-1.15.3 
    postgresql-42.6.0 -> gestione dei driver per comunicare con il database postgres; NB i driver devono essere scaricati ed installati sulla macchina.
    activation-1.1 -
    commons-beanutils-1.9.4
    commons-collections-3.2.2
    commons-digester-2.1
    commons-logging-1.2
    javax.mail-1.6.2
    jcommon-1.0.16 

Tools di supporto alla creazione delle relazioni del DB.
    Dopo aver scaricato postgresql/pgadmin, creato ed avviato il proprio database (Seguire la guida presente al sito di cui sopra),
    si potra utilizzare uno specifico tools fornito nella cartella support_tool il quale permetterà di inizializzare automaticamente il DB, 
    popolandolo delle necessarie tabelle ed eventualmente anche di canzoni (fornite nel file txt, presente sempre nella cartella support_tool).
    Sarà sufficiente avviare con un doppio click il file .jar, in esso inserire utente, password e porta del database e qual'ora si voglia
    inserire anche i dati del repository di canzoni, inserire il link assoluto del file.
    NB: il file usa come separatore la stringa £SEP£. 

