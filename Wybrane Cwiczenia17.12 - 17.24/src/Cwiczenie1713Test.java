import java.util.List;

public class Cwiczenie1713Test {
    public static void main(String[] args) {
        Cwiczenie1713 cwiczenie1713 = new Cwiczenie1713();
        String createAndSaveVerb = cwiczenie1713.createAndSaveVerbs();
        List<String> splitVerbsAndToList = cwiczenie1713.splitVerbsAndToList(createAndSaveVerb);
        cwiczenie1713.OriginalIgnoreCaseAndPrint(splitVerbsAndToList);
    }
}
