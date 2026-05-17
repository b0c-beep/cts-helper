package ro.ase.csie.cts.tests.test4.sub2_observer;

import ro.ase.csie.cts.tests.test4.sub2_observer.abstracts.IAnalyzer;
import ro.ase.csie.cts.tests.test4.sub2_observer.models.BugAnalyzer;
import ro.ase.csie.cts.tests.test4.sub2_observer.models.CleanCodeAnalyzer;
import ro.ase.csie.cts.tests.test4.sub2_observer.models.JavaCode;
import ro.ase.csie.cts.tests.test4.sub2_observer.models.TypoAnalyzer;

public class Main {
    public static void main(String[] args) {
        JavaCode j1 = new JavaCode("main.java", 100);
        JavaCode j2 = new JavaCode("class.java", 50);

        IAnalyzer a1 = new BugAnalyzer();
        IAnalyzer a2 = new TypoAnalyzer();
        IAnalyzer a3 = new CleanCodeAnalyzer();

        j1.addAnalyzer(a1);
        j1.addAnalyzer(a2);

        j1.modifyCode(110);

        System.out.println();
        j2.addAnalyzer(a1);
        j2.addAnalyzer(a3);

        j2.modifyCode(40);
        System.out.println();
        j2.notifyAnalyzers();
        System.out.println();
    }
}
