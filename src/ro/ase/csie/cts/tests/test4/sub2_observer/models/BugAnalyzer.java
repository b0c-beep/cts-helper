package ro.ase.csie.cts.tests.test4.sub2_observer.models;

import ro.ase.csie.cts.tests.test4.sub2_observer.abstracts.IAnalyzer;
import ro.ase.csie.cts.tests.test4.sub2_observer.abstracts.ICode;

public class BugAnalyzer implements IAnalyzer {

    @Override
    public void resumeParse(ICode code) {
        System.out.println("RESUMING PARSING " + code.getName() + " FOR BUGS");
        code.parse();
    }
}
