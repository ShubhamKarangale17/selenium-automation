import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleTestNG {

    @Test
    public void firstTest() {
        System.out.println("TestNG is working");
        Assert.assertEquals(2 + 2, 4);
    }
}
