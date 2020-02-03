package elements;

import elements.triad.Triads;
import lombok.Getter;
import tools.Text;

@Getter
public class HarmonicTriad {
    private Triads tonic;
    private Triads subdominant;
    private Triads dominant;
    private String[] functionsOfHarmonicTriad;

    public HarmonicTriad(Triads tonic, Triads subdominant, Triads dominant) {
        this.tonic = tonic;
        this.subdominant = subdominant;
        this.dominant = dominant;
    }

    @Override
    public String toString() {
        StringBuilder createHarmonicTriads = new StringBuilder();
        createHarmonicTriads.append(Text.INPUT_TONIC)
                .append(tonic)
                .append(System.getProperty("line.separator"))
                .append(Text.INPUT_SUBDOMINANT)
                .append(subdominant)
                .append(System.getProperty("line.separator"))
                .append(Text.INPUT_DOMINANTA)
                .append(dominant)
                .append(System.getProperty("line.separator"));
        return createHarmonicTriads.toString();
    }
}