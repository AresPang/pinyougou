package text;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring/applicationContext*")
public class ValueTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testSetValue() {
        redisTemplate.boundValueOps("name").set("bigshark01");
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
