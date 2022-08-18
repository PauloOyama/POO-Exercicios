public class DocumentEditCommand extends Command{

    final private Document _editableDoc;
    final private String _text;

    public DocumentEditCommand(Document doc, String text) {
        this._editableDoc = doc;
        this._text = text;
        this._editableDoc.Write(text);
    }

    @Override
    public void Redo() {
        this._editableDoc.Write(_text);
    }

    @Override
    public void Undo() {
        this._editableDoc.Erase(_text);
    }


    public static void main(String args[]){

        DocumentInvoker instace = new DocumentInvoker();

        instace.Write("This the original text.");

        instace.Write(" Here is some text.");
        System.out.println(instace.Read());
        System.out.println();

        instace.Undo(1);
        System.out.println(instace.Read());
        System.out.println();

        instace.Redo(1);
        System.out.println(instace.Read());
        System.out.println();

        instace.Write(" Add a little more text.");
        System.out.println(instace.Read());
        System.out.println();

        instace.Undo(2);
        System.out.println(instace.Read());
        System.out.println();


        instace.Redo(2);
        System.out.println(instace.Read());
        System.out.println();

        instace.Undo(1);
        System.out.println(instace.Read());
        System.out.println();

    }
}
