package src.ex07;

import java.util.Vector;

import javax.swing.JOptionPane;

import src.Observable;

public class PieData extends Observable {



    public PieData() {
        this.pieData = new Vector<PieRecord>();
    }


    public void addPieRecord(PieRecord pieRecord) {
        boolean alreadyExists = false;
        for (int i = 0; i < pieData.size(); i++) {
            PieRecord record = pieData.elementAt(i);
            if (record.getName().equals(pieRecord.getName())) {
                alreadyExists = true;
                JOptionPane
                        .showMessageDialog(
                                null,
                                "Warning: Attempt to add new pie with an already existing name",
                                "alert", JOptionPane.ERROR_MESSAGE);
                i = pieData.size(); // exit the loop
            }
        }
        if (!alreadyExists)
            this.pieData.addElement(pieRecord);
        this.notifyObservers();
    }

    public void changePieRecord(String subjectName, int numInPie) {
        for (int i = 0; i < pieData.size(); i++) {
            PieRecord record = pieData.elementAt(i);
            if (record.getName().equals(subjectName)) {
                record.setNumOfPie(numInPie);
                i = pieData.size();
            }
        }
        this.notifyObservers();
    }


    public Vector<PieRecord> getUpdate() {
        return (Vector<PieRecord>) pieData.clone();
    }

    private Vector<PieRecord> pieData;
}
