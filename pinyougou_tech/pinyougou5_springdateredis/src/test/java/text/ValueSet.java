package text;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring/applicationContext*")
public class ValueSet {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void setValue(){
        BoundSetOperations englishName = redisTemplate.boundSetOps("EnglishName");
        englishName.add("Ponter");
        englishName.add("Allen");
        englishName.add("Tiffany");
    }

    @Test
    public void getValue(){
        BoundSetOperations englishName = redisTemplate.boundSetOps("EnglishName");
        Set members = redisTemplate.boundSetOps("EnglishName").members();
        for (Object member : members) {
            System.out.println(member);
        }
        Boolean flag = englishName.isMember("Ponter");
        System.out.println(flag);

    }

    //移除一个值
    @Test
    public void removeValue(){
        Long removeCount = redisTemplate.boundSetOps("EnglishName").remove("Ponter");
        System.out.println(removeCount);
    }

    @Test
    public void delete(){
        redisTemplate.delete("EnglishName");
    }

}
