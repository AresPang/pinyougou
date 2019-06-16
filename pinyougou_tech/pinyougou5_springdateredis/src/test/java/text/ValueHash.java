package text;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring/applicationContext*")
public class ValueHash {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testSetValue() {
        redisTemplate.boundHashOps("namehash").put("a", "唐僧");
        redisTemplate.boundHashOps("namehash").put("b", "孙悟空");
        redisTemplate.boundHashOps("namehash").put("c", "猪八戒");
        redisTemplate.boundHashOps("namehash").put("d", "沙僧");
    }


    @Test
    public void testgetKeys() {
        BoundHashOperations boundHashOps = redisTemplate.boundHashOps("namehash");
        Set keys = boundHashOps.keys();
        for (Object key : keys) {
            System.out.println(key);
        }
    }

    @Test
    public void getValue() {
        BoundHashOperations boundHashOps = redisTemplate.boundHashOps("namehash");
        Object b = boundHashOps.get("b");
        System.out.println(b);
    }

    //移除key

    @Test
    public void removeKey(){
        BoundHashOperations boundHashOps = redisTemplate.boundHashOps("namehash");
        boundHashOps.delete("b");

    }

}
