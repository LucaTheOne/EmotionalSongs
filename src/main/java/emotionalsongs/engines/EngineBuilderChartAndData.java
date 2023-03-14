//Luca Bolelli - 749137 - VA
//Natanail Danailov Danailov - 739887 - VA


package emotionalsongs.engines;

import emotionalsongs.*;
import emotionalsongs.basic_structures.*;
import emotionalsongs.data_structures.*;
import emotionalsongs.gui.allerter.*;
import java.awt.*;
import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;

/**
 *
 * Classe il cui ruolo è quello di fornire metodi per la costruzione, rappresentazione ed esposizione dei dati
 * estratti dalle classi del package emotionalsongs.data_structure.
 */
public class EngineBuilderChartAndData {
    
    private Song analizingSong;
    private EmotionalJudgement[] songUsersJudgements;
    private int[] amazementMarks,solemnityMarks,tendernessMarks,nostalgiaMarks,calmnessMarks,powerMarks,joyMarks,tensionMarks,sadnessMarks;
    private String amazementNotes = "",solemnityNotes ="",tendernessNotes = "",nostalgiaNotes = "",calmnessNotes = "",powerNotes = "",joyNotes = "",tensionNotes = "",sadnessNotes = "";
    private JFreeChart[] arrayChartsEmotions;
    
    /**
     * Costruttore che riceve come argomento il tag di un brano e ne ricava e costruisce i dati.
     * @param songTag Tag della canzone di cui costruire i dati.
     */
    public EngineBuilderChartAndData(String songTag) {
        buildData(songTag);
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
    public String[] getArrayNotes(){
        String[] arrayNotes = new String[9];
        arrayNotes[0] = amazementNotes;
        arrayNotes[1] = solemnityNotes;
        arrayNotes[2] = tendernessNotes;
        arrayNotes[3] = nostalgiaNotes;
        arrayNotes[4] = calmnessNotes;
        arrayNotes[5] = powerNotes;
        arrayNotes[6] = joyNotes;
        arrayNotes[7] = tensionNotes;
        arrayNotes[8] = sadnessNotes;
        return arrayNotes;
    }
    /**
     * Metodo che prende come argomento un'emozione e ne restituisce tutte le note associate relativamente al giudizio del brano trattato.
     * @param emotion Emozione di cui si vogliono ricevere le note emozionali.
     * @return Stringa contenente tutte le note emozionali relative all'emozione passata come argomento, relativamente
     * al brano rappresentato.
     */
    public String getEmotionNotes(int emotion){
        return "    "+getArrayNotes()[emotion];
    }
    /**
     * 
     * @return Il report testuale dell'analisi dei dati immessi dagli utenti riguardo la valutazione emozionale del brano trattato.
     */
    public String getSongDataReport(){
        String report = EmotionalSongs.dialoghi.reportPaneTitle() +
                "   " + EmotionalSongs.dialoghi.title() + ":" + analizingSong.getTitle() + ",\n"+
                "   " + EmotionalSongs.dialoghi.author() + ":" + analizingSong.getAuthor() + ",\n"+
                "   " + EmotionalSongs.dialoghi.year() + ":" + analizingSong.getYear() + "\n\n"+
                
                EmotionalSongs.dialoghi.votedYet() + getNumberOfJudgements() + ".\n\n"+   
                
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
        String report = "COMMENTI ESPRESSI DAGLI UTENTI RIGUARDO OGNI EMOZIONE:\n\n"+
                "   Meraviglia:\n"+
                getEmotionNotes(Emotions.AMAZEMENT_INDEX)+"\n\n"+
                
                "   Solennità:\n"+
                getEmotionNotes(Emotions.SOLEMNITY_INDEX)+"\n\n"+
                
                "   Tenerezza:\n"+
                getEmotionNotes(Emotions.TENDERNESS_INDEX)+"\n\n"+
                
                "   Nostalgia:\n"+
                getEmotionNotes(Emotions.NOSTALGIA_INDEX)+"\n\n"+
                
                "   Calma:\n"+
                getEmotionNotes(Emotions.CALMNESS_INDEX)+"\n\n"+
                
                "   Potere:\n"+
                getEmotionNotes(Emotions.POWER_INDEX)+"\n\n"+
                
                "   Gioia:\n"+
                getEmotionNotes(Emotions.JOY_INDEX)+"\n\n"+
                
                "   Tensione:\n"+
                getEmotionNotes(Emotions.TENSION_INDEX)+"\n\n"+
                
                "   Tristezza:\n"+
                getEmotionNotes(Emotions.SADNESS_INDEX)+"\n";
        
        return report;
    }
    /**
     * 
     * @return Il nome che verrà assegnato alla cartella che conterrà il report esportato, relativo al brano rappresentato.
     */
    public String buildDataFolderName(){
        String folderName = "Report_"+analizingSong.getTitle()+"_"+analizingSong.getAuthor()+"_"+analizingSong.getYear()+"_"+analizingSong.getTag();
        folderName.replace(" ","_");
        folderName.replace(System.getProperty("file.separator"),"_");
        return folderName ;
    }
    
    // private internal methods
    private void buildData(String songTag){
        analizingSong=new EngineSearcher().searchBySongTag(Repository.getInstance(), songTag);
        songUsersJudgements = DataBaseJudgements.getInstance().searchJudgements(songTag);
        if(songUsersJudgements == null){
            new PopUpAllert(
                    "Non sono disponibili informazioni\nper la seguente canzone: \n" + 
                    "Titolo: " + analizingSong.getTitle() + ",\n " +
                    "Autore: " + analizingSong.getAuthor() + ",\n "+
                    "Anno: " + analizingSong.getYear() + "."
            ).setVisible(true);
            return;
        }
        
        initializeArrays(songUsersJudgements.length);
        
        for(int i = 0; i< songUsersJudgements.length;i++){
            amazementMarks[i] = songUsersJudgements[i].getAmazementMark();
            amazementNotes += songUsersJudgements[i].getAmazementNotes() + "; ";
            
            solemnityMarks[i] = songUsersJudgements[i].getSolemnityMark();
            solemnityNotes += songUsersJudgements[i].getSolemnityNotes() + "; ";
            
            tendernessMarks[i] = songUsersJudgements[i].getTendernessMark();
            tendernessNotes += songUsersJudgements[i].getTendernessNotes() + "; ";
            
            nostalgiaMarks[i] = songUsersJudgements[i].getNostalgiaMark();
            nostalgiaNotes += songUsersJudgements[i].getNostalgiaNotes() + "; ";
            
            calmnessMarks[i] = songUsersJudgements[i].getCalmnessMark();
            calmnessNotes += songUsersJudgements[i].getCalmnessNotes()+ "; ";
            
            powerMarks[i] = songUsersJudgements[i].getPowerMark();
            powerNotes+=songUsersJudgements[i].getPowerNotes()+ "; ";
            
            joyMarks[i] = songUsersJudgements[i].getJoyMark();
            joyNotes+=songUsersJudgements[i].getJoyNotes()+ "; ";
            
            tensionMarks[i] = songUsersJudgements[i].getTensionMark();
            tensionNotes+=songUsersJudgements[i].getTensionNotes()+ "; ";
            
            sadnessMarks[i] = songUsersJudgements[i].getSadnessMark();
            sadnessNotes+=songUsersJudgements[i].getSadnessNotes()+ "; ";
            
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
        array[0] = buildBarEmotionChart("Amazement", marksCounter(amazementMarks));
        array[1] = buildBarEmotionChart("Solemnity", marksCounter(solemnityMarks));
        array[2] = buildBarEmotionChart("Tenderness", marksCounter(tendernessMarks));
        array[3] = buildBarEmotionChart("Nostalgia", marksCounter(nostalgiaMarks));
        array[4] = buildBarEmotionChart("Calmness", marksCounter(calmnessMarks));
        array[5] = buildBarEmotionChart("Power", marksCounter(powerMarks));
        array[6] = buildBarEmotionChart("Joy", marksCounter(joyMarks));
        array[7] = buildBarEmotionChart("Tension", marksCounter(tensionMarks));
        array[8] = buildBarEmotionChart("Sadness", marksCounter(sadnessMarks));
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
        new EngineSorter().sortIntArray(arrayOfInt);
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
    
    private int getNumberOfJudgements(){
        return songUsersJudgements.length;
    }
}
