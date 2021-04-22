package me.ohdyno.katas.game.of.life;

import org.approvaltests.Approvals;
import org.approvaltests.reporters.ClipboardReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GameOfLifeTest {
    @UseReporter(ClipboardReporter.class)
    @Test
    void appHasAGreetingWithApprovalTests() {
        GameOfLife classUnderTest = new GameOfLife();
        Approvals.verify(classUnderTest.getGreeting());
    }
}
