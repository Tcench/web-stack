package tcench.restapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;
import tcench.restapi.util.LocalDateAdapter;
import tcench.restapi.vo.DemoVO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

public class DemoTests {

    /**
     * 获取json值
     */
    @Test
    public void getJson() {

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateAdapter())
                .create();
        // 注意 不要使用 new BigDecimal(2011.55)， 因double的精确度问题。
        DemoVO demoVO = new DemoVO(1001, LocalDateTime.now(), new BigDecimal("2011.55"));
        System.out.println(gson.toJson(demoVO));

    }

}
