package me.ohdyno.katas.game.of.life;

import org.approvaltests.reporters.GenericDiffReporter;

public class FileMergeReporter extends GenericDiffReporter {

    public FileMergeReporter() {
        super("/usr/bin/opendiff");
    }
}
