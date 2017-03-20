package kata.cucumber;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/**
 * @ClassName: TaskManagerTest
 * @Description:
 */
@RunWith(Parameterized.class)
public class TaskManagerTest {
    @Parameters
    public static Collection<Object[]> prepareData() {
        // 测试数据
        Object[][] objects = {
                // total, finished, left
                {
                        200, 12, 188 },
                {
                        18, 2, 16 }, };

        return Arrays.asList(objects);// 将数组转换成集合返回

    }

    @Parameter // first data value (0) is default /* NOT private */
    public int total;
    @Parameter(1)
    public int finished;
    @Parameter(2)
    public int left;
    TaskManager taskManager = new TaskManager();

    /**
     * @method setUp
     * @description
     * @return void
     */
    @Before
    public void setUp() throws Exception {

    }

    /**
     * Test method for {@link kata.cucumber.TaskManager#getLeft()}.
     */
    @Test
    public final void testGetLeft() {
        // Given
        taskManager.setTotal(this.total);
        // When
        taskManager.setDone(finished);
        // Then
        assertEquals(left, taskManager.getLeft());
    }

}
