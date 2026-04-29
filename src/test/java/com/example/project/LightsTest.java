import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LightGridTest {

    @Test
    void testTurnOnSingleLight() {
        LightGrid grid = new LightGrid(1000);
        grid.applyInstructionPart1("turn on 0,0 through 0,0");
        assertEquals(1, grid.countLightsOn());
    }

    @Test
    void testToggleRow() {
        LightGrid grid = new LightGrid(1000);
        grid.applyInstructionPart1("toggle 0,0 through 999,0");
        assertEquals(1000, grid.countLightsOn());
    }

    @Test
    void testTurnOff() {
        LightGrid grid = new LightGrid(1000);
        grid.applyInstructionPart1("turn on 0,0 through 9,9");
        grid.applyInstructionPart1("turn off 0,0 through 9,9");
        assertEquals(0, grid.countLightsOn());
    }

    @Test
    void testBrightnessIncrease() {
        LightGrid grid = new LightGrid(1000);
        grid.applyInstructionPart2("turn on 0,0 through 0,0");
        assertEquals(1, grid.totalBrightness());
    }

    @Test
    void testToggleBrightness() {
        LightGrid grid = new LightGrid(1000);
        grid.applyInstructionPart2("toggle 0,0 through 999,999");
        assertEquals(2000000, grid.totalBrightness());
    }

    @Test
    void testBrightnessNotNegative() {
        LightGrid grid = new LightGrid(1000);
        grid.applyInstructionPart2("turn off 0,0 through 0,0");
        assertEquals(0, grid.totalBrightness());
    }
}
