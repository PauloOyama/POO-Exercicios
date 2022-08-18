package src.ex07;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


import src.*;

public class PieController extends JPanel implements Observer, ChangeListener, ActionListener {

    public PieController(PieData pie) {
        this.pieData = pie;
        this.sliders = new Vector<JSlider>();
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.white);

        piePanel = new JPanel();
        piePanel.setBorder(new TitledBorder("PieGraphics"));
        piePanel.setLayout(new GridLayout(0, 1));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        pieData.attach(this);
        Vector<PieRecord> state = pie.getUpdate();

        for (int i = 0; i < state.size(); i++)
            this.addPie(state.elementAt(i));

        JScrollPane scrollPane = new JScrollPane(piePanel,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JButton button = new JButton("New Pie Graphic");
        button.addActionListener(this);

        constraints.weightx = 0.5;
        constraints.weighty = 1.0;
        constraints.gridx = 0;
        constraints.gridy = 0;
        this.add(scrollPane, constraints);

        constraints.weightx = 0.5;
        constraints.weighty = 0;
        constraints.gridy = 1;
        this.add(button, constraints);
    }


    public void addPie(PieRecord record) {
        JSlider slider = new JSlider();
        slider.setBackground(Color.white);
        slider.setName(record.getName());
        slider.setValue(record.getnumOfPie());
        slider.setMinimum(0);
        slider.setMaximum(100);
        slider.setMajorTickSpacing(25);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setBorder(new TitledBorder(record.getName()));
        slider.addChangeListener(this);
        piePanel.add(slider);
        piePanel.revalidate();
        sliders.addElement(slider);
    }

    public void update(Observable o) {
        PieData pies = (PieData) o;
        Vector<PieRecord> newPies = pies.getUpdate();
        for (int i = sliders.size(); i < newPies.size(); i++) {
            this.addPie((PieRecord) newPies.elementAt(i));
        }
    }


    public void actionPerformed(ActionEvent arg0) {
        String input = JOptionPane.showInputDialog("Please enter new pie name:");
        if (input != null){
            pieData.addPieRecord(new PieRecord(input, 50));
            // leave it up notify/update mechanism to invoke this.addCourse
        }
    }


    public void stateChanged(ChangeEvent arg0) {
        JSlider slider = (JSlider) arg0.getSource();
        pieData.changePieRecord(slider.getName(), slider.getValue());
    }

    public static void main(String[] args) {
        PieData data = new PieData();
        data.addPieRecord(new PieRecord("Physics", 60));
        data.addPieRecord(new PieRecord("Chemistry", 50));
        data.addPieRecord(new PieRecord("Biology", 50));

        PieController controller = new PieController(data);
        PieChartObserver bar = new PieChartObserver(data);

        JScrollPane scrollPane = new JScrollPane(bar,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        JFrame frame = new JFrame("Observer Pattern");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new GridBagLayout());
        frame.setResizable(false);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 0.25;
        constraints.weighty = 1.0;
        constraints.gridx = 0;
        constraints.gridy = 0;
        frame.getContentPane().add(controller, constraints);
        constraints.weightx = 0.5;
        constraints.weighty = 1.0;
        constraints.gridx = 1;
        constraints.gridy = 0;
        frame.getContentPane().add(scrollPane, constraints);
        frame.pack();
        frame.setVisible(true);
    }

    private PieData pieData;

    private Vector<JSlider> sliders;

    private JPanel piePanel;
}
