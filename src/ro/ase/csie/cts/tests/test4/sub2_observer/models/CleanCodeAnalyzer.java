package ro.ase.csie.cts.tests.test4.sub2_observer.models;

import ro.ase.csie.cts.tests.test4.sub2_observer.abstracts.IAnalyzer;
import ro.ase.csie.cts.tests.test4.sub2_observer.abstracts.ICode;

public class CleanCodeAnalyzer implements IAnalyzer {

    @Override
    public void resumeParse(ICode code) {
        System.out.println("RESUMING PARSING " + code.getName() + " FOR CLEAN CODE");
        code.parse();
    }
}
