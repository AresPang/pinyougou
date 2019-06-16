package text;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring/applicationContext*")
public class ValueZset {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testSetValue() {
        BoundValueOperations boundValueOps = redisTemplate.boundValueOps("zsetName");
        boundValueOps.append("张三");
        boundValueOps.append("李四");
        boundValueOps.append("王五");
        boundValueOps.append("赵六");

    }

    @Test
    public void getValue(){
       String name = (String) redisTemplate.boundValueOps("name").get();
        System.out.println(name);
    }

    @Test
    public void deleteValue(){
        redisTemplate.delete("name");
    }
}
