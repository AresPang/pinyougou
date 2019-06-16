package text;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring/applicationContext*")
public class ValueList {
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 右压栈
     */
    @Test
    public void testSetListValueRight() {
        BoundListOperations engLishName = redisTemplate.boundListOps("EngLishName");
        engLishName.rightPush("Ponter1");
        engLishName.rightPush("Allen1");
        engLishName.rightPush("Tiffany1");
    }

    /**
     * 左压栈
     */
    @Test
    public void testSetListValueLeft() {
        BoundListOperations engLishName = redisTemplate.boundListOps("EngLishName");
        engLishName.leftPush("Ponter1");
        engLishName.leftPush("Allen1");
        engLishName.leftPush("Tiffany1");
    }

    /**
     * 获取范围元素
     */
    @Test
    public void testgetSetListValues() {
        List engLishNames = redisTemplate.boundListOps("EngLishName").range(0, -1);
        for (Object engLishName : engLishNames) {
            System.out.println(engLishName);
        }
    }

    /**
     * 获取指定单一元素
     */
    @Test
    public void testgetSetListValue() {
        Object engLishName = redisTemplate.boundListOps("EngLishName").index(1);
        System.out.println(engLishName);

        BoundListOperations boundListOperations = redisTemplate.boundListOps("EngLishName");
        boundListOperations.set(1, "Allen1");
    }

    @Test
    public void testRemove(){
        BoundListOperations boundListOperations = redisTemplate.boundListOps("EngLishName");
        boundListOperations.remove(2,"Allen1");//从左至右删除param1 个 param2元素
    }
}
