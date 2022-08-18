import java.io.Console;
import java.util.ArrayList;

public class DocumentInvoker {

    private ArrayList<Command> _command = new ArrayList<Command>();

    private Document _doc = new Document();

    public void Redo(int level){
        System.out.println("- - - - Redo " + level + " Level");
        _command.get(level).Redo();
    }

    public void Undo(int level){
        System.out.println("- - - - Undo " + level + " Level");
        _command.get(level).Undo();
    }

    public void Write(String text){
        DocumentEditCommand cmd = new DocumentEditCommand(_doc,text);
        _command.add(cmd);
    }

    public String Read(){
        return _doc.ReadDocument();
    }
}
