package practise;

import harmonic_triad_builder.CreateHarmonicTriad;
import java.util.Scanner;

public interface Practise {
    Scanner input = new Scanner(System.in);
    CreateHarmonicTriad builder = new CreateHarmonicTriad();
    void practise();
}
