import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @Description TODO
 * @Date 2020/11/9 11:23
 * @Created by Hrz
 */

public class LogTest {

    private Logger log = LoggerFactory.getLogger( LogTest.class);

    @Test
    public void demo() {
        log.info("一个提示");
        log.warn("警告来了");
        log.error("大爆炸啦");
    }
}
