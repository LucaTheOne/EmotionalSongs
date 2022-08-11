
package emotionalsongs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Megaport
 */
public class RepositoryInspectionPanel extends JPanel {
    
    Layout layout = new Layout();
    JList repoView ;
    JPanel searchPanel;
    public RepositoryInspectionPanel() throws IOException {
        setPreferredSize(layout.centerRightPanelDimension);
        setLayout(new BorderLayout());
        initSearchPanel();
        initRepoView();
        add(repoView,BorderLayout.CENTER);
        add(searchPanel,BorderLayout.SOUTH);
    }
    
    public void initSearchPanel(){
        searchPanel = new JPanel();
        searchPanel.setPreferredSize(new Dimension(layout.lowerPartOfRepoView));
        searchPanel.setBackground(Color.red);
    }
    
    public void initRepoView() throws IOException{
        Repository repo = new Repository();
        repoView = new JList();
        repoView.setPreferredSize(layout.upperPartOfRepoView);
        for(int i = 0;i<repo.getDimensioneRepository();i++){
            Brano branoCorrente = repo.getBrano(i);
            JTextField text = new JTextField(i+branoCorrente.getTitle()+", "+branoCorrente.getAuthor()+", "+branoCorrente.getYear()+".");
            repoView.add(text);
        }
    }
    
    public static void main(String[] args) throws IOException {
       JFrame frame = new JFrame();
       Layout layout = new Layout();
       frame.setSize(layout.centerRightPanelDimension);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       JPanel panel = new RepositoryInspectionPanel();
       frame.add(panel);
       frame.setVisible(true);
    }
}
