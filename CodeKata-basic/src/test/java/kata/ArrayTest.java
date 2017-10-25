package kata;

import static org.junit.Assert.*;
import org.junit.Test;

public class ArrayTest {

    @Test
    public void testLenthofArray() {
        // 测试数据
        Object[][] objects = 
        {{"2015-12-28","1212120015431",1,57,0,"0","0","0","0","10000","5000","1500","4275",null,null,null,null,null,null,null,null,null,null,null,null,null,"2015-10-01","0",null,"90000","45000",9 },
         {"2015-12-28","1212120015432",2,26,0,"0","0","0","0","10000","5000","1500","1950",null,null,null,null,null,null,null,null,null,null,null,null,null,"2015-11-01","0",null,"80000","40000",8 },
         {"2015-12-28","1212120015433",1,58,0,"0","0","0","0","10000","5000","1500","4350",null,null,null,null,null,null,null,null,null,null,null,null,null,"2015-10-01","0",null,"90000","45000",9 },
         {"2015-12-28","1212120015434",2,27,0,"0","0","0","0","10000","5000","1500","2025",null,null,null,null,null,null,null,null,null,null,null,null,null,"2015-11-01","0",null,"80000","40000",8 },
         {"2015-12-28","1212120015435",1,59,0,"0","0","0","0","10000","5000","1500","4425",null,null,null,null,null,null,null,null,null,null,null,null,null,"2015-10-01","0",null,"90000","45000",9 }
         };
        
        assertEquals(5, objects.length);
        assertEquals(32, objects[0].length);
    }

}
