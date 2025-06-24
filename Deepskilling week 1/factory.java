interface Document{
   public void open();
}
class WordDocument implements Document{
    public void open(){
        System.out.println("Opening word document");
    }
}
class PdfDocument implements Document{
    public void open(){
        System.out.println("Opening pdf document");
    }
}
class ExcelDocument implements Document{
    public void open(){
        System.out.println("Opening excel document");
    }
}
abstract class DocumentFactory{
    public abstract Document createDocument();
}
class wordfactory extends DocumentFactory{
    public Document createDocument(){
        return new WordDocument();
    }
}
class Pdffactory extends DocumentFactory{
    public Document createDocument(){
        return new PdfDocument();
    }
}
class Excelfactory extends DocumentFactory{
    public Document createDocument(){
        return new ExcelDocument();
    }
}
public class factory {
    public static void main(String args[]){
        DocumentFactory worddoc=new wordfactory();
        Document word=worddoc.createDocument();
        word.open();
        DocumentFactory pdfdoc=new Pdffactory();
        Document pdf=pdfdoc.createDocument();
        pdf.open();
        DocumentFactory exceldoc=new Excelfactory();
        Document excel=exceldoc.createDocument();
        excel.open();
    }
}
