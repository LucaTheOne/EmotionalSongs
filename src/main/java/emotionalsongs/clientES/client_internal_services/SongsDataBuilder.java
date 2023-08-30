/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */
package emotionalsongs.clientES.client_internal_services;

import emotionalsongs.clientES.gui.allerter.PopUpAllert;
import emotionalsongs.clientES.ServicesProvider;
import emotionalsongs.*;
import java.awt.*;
import java.rmi.*;
import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;
import serverES.*;
import serverES.server_services_common_interfaces.data_handler.*;


/**
 *
 * Classe il cui ruolo è quello di fornire metodi per la costruzione, rappresentazione ed esposizione dei dati
 * estratti dalle classi del package emotionalsongs.data_structure.
 */
public class SongsDataBuilder {
    
    private final String SONG_ID;
    private int[] amazementMarks,solemnityMarks,tendernessMarks,nostalgiaMarks,calmnessMarks,powerMarks,joyMarks,tensionMarks,sadnessMarks;
    private String usersComments = "";
    private JFreeChart[] arrayChartsEmotions;
    private final EmotionsDataHandler   EMOTIONS_DATA_HANDLER;
    private final SongsDataHandler SONGS_DATA_HANDLER;
    private final String SEP = ServerUtils.STRING_SEPARATOR;
    
    private final String TITLE,AUTHOR,YEAR;
    private String[] usersEmotionalJudgements;
    private final int 
            _AMAZEMENT = 3,
            _SOLEMNITY = 4,
            _TENDERNESS = 5,
            _NOSTALGIA = 6,
            _CALMNESS = 7,
            _POWER = 8,
            _JOY = 9,
            _TENSION = 10,
            _SADNESS = 11,
            _COMMENT = 2,
            _TITLE = 2,
            _AUTHOR = 3,
            _YEAR = 4;
            
                    
    /**
     * Costruttore che riceve come argomento il tag di un brano e ne ricava e costruisce i dati.
     * @param songId Tag della canzone di cui costruire i dati.
     */
    public SongsDataBuilder(String songId) {
        SONG_ID = songId;
        ServicesProvider sp = ServicesProvider.getInstance();
        EMOTIONS_DATA_HANDLER = (EmotionsDataHandler) sp.getService(ServicesProvider.EMOTIONS_DATA_HANDLER);
        SONGS_DATA_HANDLER = (SongsDataHandler) sp.getService(ServicesProvider.SONGS_DATA_HANDLER);
        String songData[] = null;
        try {
            songData = SONGS_DATA_HANDLER.requestSongData(SONG_ID).split(SEP);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        TITLE = songData[_TITLE];
        AUTHOR = songData[_AUTHOR];
        YEAR = songData[_YEAR];
        buildData();
        arrayChartsEmotions = buildAllEmotionsChart();     
    }
    
    // chart getter methods
    /**
     * 
     * @return Un array di grafici, ciascuno rappresentante i dati di ogni emozione relativa ai giudizi emozionali
     * espressi per la canzone di cui la classe costruisce i dati.
     */
    public JFreeChart[] getArrayCharts(){
        return arrayChartsEmotions;
    }
    /**
     * 
     * @param emotion Tipo di emozione di cui si vuole avere il grafico delle valutazioni degli utenti.
     * @return Il grafico relativo all'emozione passata come argomento.
     */
    public JFreeChart getChart(int emotion){
        return arrayChartsEmotions[emotion];
    }
    /**
     * 
     * @return Il grafico che esprime la media dei voti che ciascuna emozione ha ricevuto, relativamente ai giudizi emozionali
     * espressi sul brano rappresentato da più utenti.
     */
    public JFreeChart getMediumsChart(){
        return buildBarMediumsChart();
    }
    /**
     * 
     * @return Il grafico che esprime la moda dei voti che ciascuna emozione ha ricevuto, relativamente ai giudizi emozionali
     * espressi sul brano rappresentato da più utenti.
     */
    public JFreeChart getTrendsChart(){
        return buildBarTrendsChart();
    }
    /**
     * 
     * @return Il grafico che esprime la mediana dei voti che ciascuna emozione ha ricevuto, relativamente ai giudizi emozionali
     * espressi sul brano rappresentato da più utenti.
     */
    public JFreeChart getMediansChart(){
        return buildBarMediansChart();
    }
    
    //String data getters
    /**
     * Metodo che costruisce un array di stringhe di 9 posizioni, una per ogni emozione.
     * Ogni posizione dell'array contiene tutti i giudizi espressi da tutti gli utenti relativamente alla percezione
     * di una precisa emozione.
     * @return Array con tutte le note emozionali.
     */
    public String getComments(){
        return usersComments;
    }
    
    /**
     * 
     * @return Il report testuale dell'analisi dei dati immessi dagli utenti riguardo la valutazione emozionale del brano trattato.
     */
    public String getSongDataReport(){
        String[] songData = null;
        try {
            songData = SONGS_DATA_HANDLER.requestSongData(SONG_ID).split(SEP);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
       
        String report = EmotionalSongs.dialoghi.reportPaneTitle() +
                "   " + EmotionalSongs.dialoghi.title() + ":" + TITLE + ",\n"+
                "   " + EmotionalSongs.dialoghi.author() + ":" + AUTHOR + ",\n"+
                "   " + EmotionalSongs.dialoghi.year() + ":" + YEAR + "\n\n"+
                
                EmotionalSongs.dialoghi.votedYet() + usersEmotionalJudgements.length + ".\n\n"+   
                
                EmotionalSongs.dialoghi.relativeData() +"\n\n"+
                
                "   " + EmotionalSongs.dialoghi.amazementName()+":\n" +
                "   " + EmotionalSongs.dialoghi.aritmeticalMedium() + calculateAritmethicalMedium(amazementMarks) + "\n" + 
                "   " + EmotionalSongs.dialoghi.trend() + findTrend(amazementMarks) + "\n"+
                "   " + EmotionalSongs.dialoghi.median() + findMedian(amazementMarks) + "\n\n"+
                
                "   " + EmotionalSongs.dialoghi.solemnityName()+":\n" +
                "   " + EmotionalSongs.dialoghi.aritmeticalMedium() + calculateAritmethicalMedium(solemnityMarks) + "\n" + 
                "   " + EmotionalSongs.dialoghi.trend() + findTrend(solemnityMarks) + "\n"+
                "   " + EmotionalSongs.dialoghi.median() + findMedian(solemnityMarks) + "\n\n"+
                
                "   " + EmotionalSongs.dialoghi.tendernessName() + ":\n" +
                "   " + EmotionalSongs.dialoghi.aritmeticalMedium() + calculateAritmethicalMedium(tendernessMarks) + "\n" + 
                "   " + EmotionalSongs.dialoghi.trend() + findTrend(tendernessMarks) + "\n"+
                "   " + EmotionalSongs.dialoghi.median() + findMedian(tendernessMarks) + "\n\n"+
                
                "   " + EmotionalSongs.dialoghi.nostalgiaName()+":\n" +
                "   " +EmotionalSongs.dialoghi.aritmeticalMedium() + calculateAritmethicalMedium(nostalgiaMarks) + "\n" + 
                "   " +EmotionalSongs.dialoghi.trend() + findTrend(nostalgiaMarks) + "\n"+
                "   " +EmotionalSongs.dialoghi.median() + findMedian(nostalgiaMarks) + "\n\n"+
                
                "   " + EmotionalSongs.dialoghi.calmnessName()+ ":\n" +
                "   " + EmotionalSongs.dialoghi.aritmeticalMedium() + calculateAritmethicalMedium(calmnessMarks) + "\n" + 
                "   " + EmotionalSongs.dialoghi.trend() + findTrend(calmnessMarks) + "\n"+
                "   " + EmotionalSongs.dialoghi.median() + findMedian(calmnessMarks) + "\n\n"+
                
                "   " + EmotionalSongs.dialoghi.powerName() + ":\n" +
                "   " + EmotionalSongs.dialoghi.aritmeticalMedium() + calculateAritmethicalMedium(powerMarks) + "\n" + 
                "   " + EmotionalSongs.dialoghi.trend() + findTrend(powerMarks) + "\n"+
                "   " + EmotionalSongs.dialoghi.median() + findMedian(powerMarks) + "\n\n"+
                
                "   " + EmotionalSongs.dialoghi.joyName()+":\n" +
                "   " + EmotionalSongs.dialoghi.aritmeticalMedium() + calculateAritmethicalMedium(joyMarks) + "\n" + 
                "   " + EmotionalSongs.dialoghi.trend() + findTrend(joyMarks) + "\n"+
                "   " + EmotionalSongs.dialoghi.median() + findMedian(joyMarks) + "\n\n"+
                
                "   " + EmotionalSongs.dialoghi.tensionName()+":\n" +
                "   " + EmotionalSongs.dialoghi.aritmeticalMedium() + calculateAritmethicalMedium(tensionMarks) + "\n" + 
                "   " + EmotionalSongs.dialoghi.trend() + findTrend(tensionMarks) + "\n"+
                "   " + EmotionalSongs.dialoghi.median() + findMedian(tensionMarks) + "\n\n"+
                
                "   " + EmotionalSongs.dialoghi.sadnessName()+":\n" +
                "   " + EmotionalSongs.dialoghi.aritmeticalMedium() + calculateAritmethicalMedium(sadnessMarks) + "\n" + 
                "   " + EmotionalSongs.dialoghi.trend() + findTrend(sadnessMarks) + "\n" + 
                "   " + EmotionalSongs.dialoghi.median() + findMedian(sadnessMarks) + ".\n\n";
        return report;
    }
    /**
     * 
     * @return Il report contenente tutte le note emozionali rilasciati dagli utenti, relativamente al brano trattato.
     */
    public String getSongNotesReport(){
        return "COMMENTI ESPRESSI DAGLI UTENTI RIGUARDO OGNI EMOZIONE:\n\n"+getComments();
    }
    /**
     * 
     * @return Il nome che verrà assegnato alla cartella che conterrà il report esportato, relativo al brano rappresentato.
     */
    public String buildDataFolderName(){
        String folderName = "Report_"+TITLE+"_"+AUTHOR+"_"+YEAR+"_"+SONG_ID;
        folderName.replace(" ","_");
        folderName.replace(System.getProperty("file.separator"),"_");
        return folderName ;
    }
    
    // private internal methods
    private void buildData(){
        try {
            usersEmotionalJudgements = EMOTIONS_DATA_HANDLER.requestDataJudgementsSong(SONG_ID);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        if(usersEmotionalJudgements == null){
            new PopUpAllert(
                    "Non sono disponibili informazioni per la seguente canzone: \n" + 
                    "Titolo: " + TITLE + ",\n " +
                    "Autore: " + AUTHOR + ",\n "+
                    "Anno: " + YEAR + "."
            ).setVisible(true);
        }
        
        initializeArrays(usersEmotionalJudgements.length);
        
        for(int i = 0; i< usersEmotionalJudgements.length;i++){
            String[] currentData = usersEmotionalJudgements[i].split(SEP);
            
            amazementMarks[i] = Integer.parseInt(currentData[_AMAZEMENT]);
            solemnityMarks[i] = Integer.parseInt(currentData[_SOLEMNITY]);            
            tendernessMarks[i] = Integer.parseInt(currentData[_TENDERNESS]);            
            nostalgiaMarks[i] = Integer.parseInt(currentData[_NOSTALGIA]);            
            calmnessMarks[i] = Integer.parseInt(currentData[_CALMNESS]);;           
            powerMarks[i] = Integer.parseInt(currentData[_POWER]);            
            joyMarks[i] = Integer.parseInt(currentData[_JOY]);            
            tensionMarks[i] = Integer.parseInt(currentData[_TENSION]);            
            sadnessMarks[i] = Integer.parseInt(currentData[_SADNESS]);

            usersComments += currentData[_COMMENT]+ (i!=(usersEmotionalJudgements.length-1)? " <> ":"");
        }   
    }
    
    private void initializeArrays(int numberOfJudgements){
        amazementMarks = new int[numberOfJudgements];
        solemnityMarks = new int[numberOfJudgements];
        tendernessMarks = new int[numberOfJudgements];
        nostalgiaMarks = new int[numberOfJudgements];
        calmnessMarks = new int[numberOfJudgements];
        powerMarks = new int[numberOfJudgements];
        joyMarks = new int[numberOfJudgements];
        tensionMarks = new int[numberOfJudgements];
        sadnessMarks = new int[numberOfJudgements];
    }
    
    private int[] marksCounter(int[] mark){
        int[] arrayCount = new int[5];
        for(int i = 0; i< 5;i++){
            arrayCount[i] = 0;
        }
        for(int i = 0; i<mark.length;i++){
            switch (mark[i]) {
                case 1:
                    arrayCount[0]++;
                    break;
                case 2:
                    arrayCount[1]++;
                    break;
                case 3:
                    arrayCount[2]++;
                    break;
                case 4:
                    arrayCount[3]++;
                    break;
                case 5:
                    arrayCount[4]++;
                    break;
                default:
                    throw new AssertionError();
            }
        }
        return arrayCount;
    }
    
    private JFreeChart buildBarMediumsChart(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(calculateAritmethicalMedium(amazementMarks), "amazement", "");
        dataset.setValue(calculateAritmethicalMedium(solemnityMarks), "solemnity", "");
        dataset.setValue(calculateAritmethicalMedium(tendernessMarks), "tenderness", "");
        dataset.setValue(calculateAritmethicalMedium(nostalgiaMarks), "nostalgia", "");
        dataset.setValue(calculateAritmethicalMedium(calmnessMarks), "calmness", "");
        dataset.setValue(calculateAritmethicalMedium(powerMarks), "power", "");
        dataset.setValue(calculateAritmethicalMedium(joyMarks), "joy", "");
        dataset.setValue(calculateAritmethicalMedium(tensionMarks), "tension", "");
        dataset.setValue(calculateAritmethicalMedium(sadnessMarks), "sadness", "");
        
        JFreeChart barChart = ChartFactory.createBarChart(EmotionalSongs.dialoghi.chartMedium(), EmotionalSongs.dialoghi.emotions(), EmotionalSongs.dialoghi.marksMedium(), dataset, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot plot = barChart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.BLACK);
        NumberAxis yRange = new NumberAxis();
        yRange.setRange(0, 5);
        yRange.setTickUnit(new NumberTickUnit(0.2));
        plot.setRangeAxis(yRange);
        return barChart;
    }
    
    private JFreeChart buildBarTrendsChart(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(findTrend(amazementMarks), "amazement", "");
        dataset.setValue(findTrend(solemnityMarks), "solemnity", "");
        dataset.setValue(findTrend(tendernessMarks), "tenderness", "");
        dataset.setValue(findTrend(nostalgiaMarks), "nostalgia", "");
        dataset.setValue(findTrend(calmnessMarks), "calmness", "");
        dataset.setValue(findTrend(powerMarks), "power", "");
        dataset.setValue(findTrend(joyMarks), "joy", "");
        dataset.setValue(findTrend(tensionMarks), "tension", "");
        dataset.setValue(findTrend(sadnessMarks), "sadness", "");
        
        JFreeChart barChart = ChartFactory.createBarChart(EmotionalSongs.dialoghi.chartTrend(), EmotionalSongs.dialoghi.emotions(), EmotionalSongs.dialoghi.trendsV(), dataset, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot plot = barChart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.BLACK);
        NumberAxis yRange = new NumberAxis();
        yRange.setRange(0, 5);
        yRange.setTickUnit(new NumberTickUnit(0.2));
        plot.setRangeAxis(yRange);
        return barChart;
    }
    
    private JFreeChart buildBarMediansChart(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(findMedian(amazementMarks), "amazement", "");
        dataset.setValue(findMedian(solemnityMarks), "solemnity", "");
        dataset.setValue(findMedian(tendernessMarks), "tenderness", "");
        dataset.setValue(findMedian(nostalgiaMarks), "nostalgia", "");
        dataset.setValue(findMedian(calmnessMarks), "calmness", "");
        dataset.setValue(findMedian(powerMarks), "power", "");
        dataset.setValue(findMedian(joyMarks), "joy", "");
        dataset.setValue(findMedian(tensionMarks), "tension", "");
        dataset.setValue(findMedian(sadnessMarks), "sadness", "");
        
        JFreeChart barChart = ChartFactory.createBarChart(EmotionalSongs.dialoghi.chartMedian(), EmotionalSongs.dialoghi.emotions(), EmotionalSongs.dialoghi.marksMedium(), dataset, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot plot = barChart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.BLACK);
        NumberAxis yRange = new NumberAxis();
        yRange.setRange(0, 5);
        yRange.setTickUnit(new NumberTickUnit(0.2));
        plot.setRangeAxis(yRange);
        return barChart;
    }
    
    private JFreeChart buildBarEmotionChart(String typeOfEmotion,int[] emotionMarkCounter){
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        dataSet.setValue(emotionMarkCounter[0], "1", "");
        dataSet.setValue(emotionMarkCounter[1], "2", "");
        dataSet.setValue(emotionMarkCounter[2], "3", "");
        dataSet.setValue(emotionMarkCounter[3], "4", "");
        dataSet.setValue(emotionMarkCounter[4], "5", "");
        
        JFreeChart barChart = ChartFactory.createBarChart(typeOfEmotion, EmotionalSongs.dialoghi.howMuchFeeled(), EmotionalSongs.dialoghi.numberOfUser(), dataSet, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot plot = barChart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.BLACK);
        return barChart;
    }
    
    private JFreeChart[] buildAllEmotionsChart(){
        JFreeChart[] array = new JFreeChart[9];
        array[_AMAZEMENT-3] = buildBarEmotionChart("Amazement", marksCounter(amazementMarks));
        array[_SOLEMNITY-3] = buildBarEmotionChart("Solemnity", marksCounter(solemnityMarks));
        array[_TENDERNESS-3] = buildBarEmotionChart("Tenderness", marksCounter(tendernessMarks));
        array[_NOSTALGIA-3] = buildBarEmotionChart("Nostalgia", marksCounter(nostalgiaMarks));
        array[_CALMNESS-3] = buildBarEmotionChart("Calmness", marksCounter(calmnessMarks));
        array[_POWER-3] = buildBarEmotionChart("Power", marksCounter(powerMarks));
        array[_JOY-3] = buildBarEmotionChart("Joy", marksCounter(joyMarks));
        array[_TENSION-3] = buildBarEmotionChart("Tension", marksCounter(tensionMarks));
        array[_SADNESS-3] = buildBarEmotionChart("Sadness", marksCounter(sadnessMarks));
        return array;
        
    }
    
    
    private double calculateAritmethicalMedium(int[] arrayOfInt){
        int sum = 0;
        for(int i = 0; i< arrayOfInt.length;i++) sum += arrayOfInt[i];
        double medium = (double)sum / (double) arrayOfInt.length;
        return medium;
    }
    
    private double findMedian(int[] arrayOfInt){
        double median = 0;
        ClientUtilities.sort(arrayOfInt);
        int length = arrayOfInt.length;
        if(length%2!=0) median = (double)arrayOfInt[length/2];
        else {
            int sumeOfMiddles = arrayOfInt[length/2-1]+arrayOfInt[length/2];
            median = ((double)sumeOfMiddles)/2;
        }
        return median;
    }
    
    private int findTrend(int[] arrayOfInt){
        int maxcount = 0;
        int n = arrayOfInt.length;
        int element_having_max_freq = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arrayOfInt[i] == arrayOfInt[j]) {
                count++;
            }
        }
        if (count > maxcount) {
            maxcount = count;
            element_having_max_freq = arrayOfInt[i];
        }
    }
 
    return element_having_max_freq;
    }
}

