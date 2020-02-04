package by.kiselevich.task1.testRun;

import by.kiselevich.task1.controller.ChildRoomController;
import org.junit.Assert;
import org.junit.Test;

public class RunTest {
    @Test
    public void runTest() {
        ChildRoomController childRoomController = new ChildRoomController();
        childRoomController.serveChildren();
        Assert.assertTrue(true);
    }
}
