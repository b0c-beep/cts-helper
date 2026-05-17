package ro.ase.csie.cts.tests.test4.sub2_observer.models;

import ro.ase.csie.cts.tests.test4.sub2_observer.abstracts.IAnalyzer;
import ro.ase.csie.cts.tests.test4.sub2_observer.abstracts.ICode;

import java.util.ArrayList;
import java.util.List;

public class JavaCode implements ICode {
    private String fileName;
    private int linesOfCode;
    private List<IAnalyzer> analyzers = new ArrayList<>();

    public JavaCode(String fileName, int linesOfCode) {
        this.fileName = fileName;
        this.linesOfCode = linesOfCode;
    }

    @Override
    public String getName() {
        return fileName;
    }

    public int getLinesOfCode() {
        return linesOfCode;
    }

    public void modifyCode(int linesOfCode) {
        this.linesOfCode = linesOfCode;
        notifyAnalyzers();
    }

    public void addAnalyzer(IAnalyzer analyzer) {
        analyzers.add(analyzer);
    }

    public void removeAnalyzer(IAnalyzer analyzer) {
        analyzers.remove(analyzer);
    }

    @Override
    public void parse() {
        System.out.println("CURRENTLY PARSING " + fileName + " WITH " + linesOfCode + " LINES OF CODE");
    }

    @Override
    public void notifyAnalyzers() {
        analyzers.stream().forEach(a -> a.resumeParse(this));
    }
}
