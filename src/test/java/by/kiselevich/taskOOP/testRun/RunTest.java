package by.kiselevich.taskOOP.testRun;

import by.kiselevich.taskOOP.controller.ChildRoomController;
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
