package librarymanagementsystem.GUI;

import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset; 
import org.jfree.data.xy.XYSeries; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 
import org.jfree.chart.plot.XYPlot; 
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.plot.PlotOrientation; 
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class ChartDrawing{
   
    //** PieChart **//
    private PieDataset createDataSet_PieChart(ArrayList <String> key, ArrayList <Double> value){
        DefaultPieDataset dataset = new DefaultPieDataset( );
        for (int i=0; i<key.size(); i++){
            dataset.setValue(key.get(i) , value.get(i) );  
        }
        return dataset;         
    }
   
    private JFreeChart createChart_PieChart(String title, PieDataset dataset ) {
        JFreeChart chart = ChartFactory.createPieChart(      
            title,  
            dataset,       
            true,           
            true, 
            false);

        return chart;
    }
    
    public JPanel pieChart(String title, ArrayList <String> name_value, ArrayList <Double> value) {
        JFreeChart chart = createChart_PieChart(title, createDataSet_PieChart(name_value, value) );  
        return new ChartPanel( chart ); 
    }
    
    //** Line Chart **//
    private DefaultCategoryDataset createDataSet_LineChart(String series, ArrayList <Double> value_1, ArrayList <Double> value_2){
        DefaultCategoryDataset  dataset = new DefaultCategoryDataset( );
        for (int i=0; i<value_1.size(); i++){
            dataset.setValue(value_1.get(i), series, value_2.get(i));  
        }
        return dataset;
    }
    
    /*
    private DefaultCategoryDataset createDataSet_LineChart(String series, ArrayList <Double> value_1, ArrayList <Double> value_2){
        ArrayList <String> value_2_str = new ArrayList <String> ();
        
        for (Double e : value_2){
            value_2_str.add(Double.toString(e));
        }
        
        DefaultCategoryDataset  dataset = new DefaultCategoryDataset( );
        for (int i=0; i<value_1.size(); i++){
            dataset.setValue(value_1.get(i), series, value_2_str.get(i));  
        }
        return dataset;
    }
    */
    
    private JFreeChart createChart_PieChart(String title, String name_value_1, String name_value_2, DefaultCategoryDataset dataset ) {
        JFreeChart lineChart = ChartFactory.createLineChart(
            title,
            name_value_1, name_value_2,
            dataset,    
            PlotOrientation.VERTICAL,
            true,true,false);
        
        return lineChart;
    }
    
    public JPanel lineChart(String title, String series, String name_value_1, String name_value_2, ArrayList <Double> value_1, ArrayList <Double> value_2) {
        ChartPanel chart = new ChartPanel(createChart_PieChart(title, name_value_1, name_value_2, createDataSet_LineChart(series, value_1, value_2)));  
        return chart; 
    }
    
    
    //** XY Chart **//
    // for 1 series_name
    private XYDataset createDataSet_XYChart(String series, ArrayList <Double> value_1, ArrayList <Double> value_2){

        XYSeries ser = new XYSeries(series);          
        for (int i=0; i<value_1.size(); i++){
            ser.add(value_1.get(i), value_2.get(i)); 
        }
        
        XYSeriesCollection dataset = new XYSeriesCollection( );          
        dataset.addSeries( ser );    
        return dataset;
    }
    
    private JFreeChart createChart_XYChart(String title, String name_value_1, String name_value_2, XYDataset dataset ) {

        JFreeChart xylineChart = ChartFactory.createXYLineChart(
            title ,
            name_value_1 ,
            name_value_2 ,
            dataset ,
            PlotOrientation.VERTICAL ,
            true , true , false);
        
        return xylineChart;
    }
    
    public JPanel xyChart(String title, String series, String name_value_1, String name_value_2, ArrayList <Double> value_1, ArrayList <Double> value_2) {
        ChartPanel chart = new ChartPanel(createChart_XYChart(title, name_value_1, name_value_2, createDataSet_XYChart(series, value_1, value_2)));  
        return chart; 
    }
    
    
    public static void main( String[ ] args ) {
        //ChartDrawing demo = new ChartDrawing( "Mobile Sales" );  
        //demo.setSize( 560 , 367 );    
        //RefineryUtilities.ceterFrameOnScreen( demo );    
        //demo.setVisible( true ); 
        //JFrame t = new JFrame("asd");
        //t.add(createDemoPanel());
        //t.setSize(600, 600);
        //t.setVisible(true);
        
        ArrayList <Double> name_value = new ArrayList <Double> ();
        ArrayList <Double> value = new ArrayList <Double> ();
        
        name_value.add(2d);
        name_value.add(3d);
        name_value.add(4d);
        name_value.add(5d);
        name_value.add(20d);
        
        value.add(123d);
        value.add(12.2);
        value.add(134d);
        value.add(1d);
        value.add(1233d);
        ChartDrawing demo = new ChartDrawing();
        JFrame t = new JFrame("Tdsafsadn");
        JPanel p = demo.lineChart("Hsdsane", "ser asdsa", "nasmdnd", "asdnsadn", value, name_value);
        t.add(p);
        t.setSize(600, 600);
        t.setVisible(true);
    }
}
