package kata.web;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Before;
import org.junit.Test;

/**@ClassName: TomcatUserTest
 * @Description:  
 */
public class TomcatUserTest {
    
    TomcatUser user = new TomcatUser();
    private String lastName = "ZHANG";
    /**@method setUp
     * @description 
     * @return void
    */
    @Before
    public void setUp() throws Exception {
        user.setFirstName("Mike");
        user.setLastName(lastName);
    }

    /**
     * Test method for {@link kata.web.TomcatUser#getFirstName()}.
     */
    @Test
    public final void testGetFirstName() {
        Object ob = user;
        assertNotNull(ob);
        assertEquals("kata.web.TomcatUser",ob.getClass().getName());
        Field[] field = ob.getClass().getDeclaredFields();
        for (int i = 0; i < field.length; i++) {
            // 权限修饰符
            int mo = field[i].getModifiers();
            String priv = Modifier.toString(mo);
            // 属性类型
            Class<?> type = field[i].getType();
            System.out.println(priv + " " + type.getName() + " "
                    + field[i].getName() + ";");
        }
        
        System.out.println("===============实现的接口或者父类的属性========================");
        // 取得实现的接口或者父类的属性
        Field[] fieldList2 = ob.getClass().getFields();
        for (int j = 0; j < fieldList2.length; j++) {
            // 权限修饰符
            int mo = fieldList2[j].getModifiers();
            String priv = Modifier.toString(mo);
            // 属性类型
            Class<?> type = fieldList2[j].getType();
            System.out.println(priv + " " + type.getName() + " "
                    + fieldList2[j].getName() + ";");
        }
        
        System.out.println("===============方法====================");
        
        Method[] methods = ob.getClass().getDeclaredMethods();
        for(int i=0; i<methods.length;i++){
            System.out.println(methods[i].getName());
            String methodName = methods[i].getName();
            if(methodName.startsWith("get")){
                System.out.println(methodName.substring(3).toLowerCase());
            }
        }
        assertEquals(lastName, getter(ob, "LastName"));
    }

    public Object getter(Object obj, String att) {
        try {
            Method method = obj.getClass().getMethod("get" + att);
            System.out.println(method.invoke(obj));
            return method.invoke(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
