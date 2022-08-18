import java.util.ArrayList;

class Document {

    private ArrayList _textArray = new ArrayList();

    public void Write(String text){
        _textArray.add(text);
    }

    public void Erase(String text){
        _textArray.remove(text);
    }

    public void Erase(int textLevel){
        _textArray.remove(textLevel);
    }

    public String ReadDocument(){
        StringBuilder sb = new StringBuilder();
        _textArray.forEach(text -> sb.append(text));
        return sb.toString();
    }

}
