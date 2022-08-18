package src.ex07;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Vector;

import javax.swing.JPanel;

import src.Observer;
import src.Observable;
import src.LayoutConstants;

public class PieChartObserver extends JPanel implements Observer {


    public PieChartObserver(PieData data) {
        data.attach(this);
        this.pieData = data.getUpdate();
        this.setPreferredSize(new Dimension(2 * LayoutConstants.xOffset
                + (LayoutConstants.barSpacing + LayoutConstants.barWidth)
                * this.pieData.size(), LayoutConstants.graphHeight + 2
                * LayoutConstants.yOffset));
        this.setBackground(Color.white);
        System.out.println("Chegou no construtor paint");
    }


    public void paint(Graphics g) {
        super.paint(g);

        System.out.println("Chegou na classe paint");
        int radius = 100;
        int totalPies = this.pieData.size();

        //first compute the total number of students
        double total = 0.0;
        for (int i = 0; i < totalPies; i++) {
            PieRecord record =  pieData.elementAt(i);
            total += record.getnumOfPie();
            System.out.println(total);
        }

        //if total == 0 nothing to draw
        if (total != 0) {
            double startAngle = 0.0;
            for (int i = 0; i < totalPies; i++) {
                PieRecord record =  pieData.elementAt(i);
                double ratio = (record.getnumOfPie() / total) * 360.0;
                //draw the arc
                g.setColor(LayoutConstants.subjectColors[i%LayoutConstants.subjectColors.length]);
                g.fillArc(LayoutConstants.xOffset, LayoutConstants.yOffset , 2 * radius, 2 * radius, (int) startAngle, (int) ratio);
                startAngle += ratio;
                //System.out.println(startAngle);
            }
           // System.out.println(startAngle);
        }

        System.out.println("saiu na classe paint");
    }


    public void update(Observable o) {
        PieData data = (PieData) o;
        this.pieData = data.getUpdate();

        this.setPreferredSize(new Dimension(2 * LayoutConstants.xOffset
                + (LayoutConstants.barSpacing + LayoutConstants.barWidth)
                * this.pieData.size(), LayoutConstants.graphHeight + 2
                * LayoutConstants.yOffset));
        this.revalidate();
        this.repaint();
    }

    private Vector<PieRecord> pieData;
}
