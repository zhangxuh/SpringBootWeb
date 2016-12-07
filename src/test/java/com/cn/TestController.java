package com.cn;
import com.cn.controller.HelloWordController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Administrator on 2016/11/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(HelloWordController.class)
@ActiveProfiles("dev")
public class TestController {

    @Autowired
    private MockMvc mockMvc;
    @Test
    public void getProfile()throws Exception {
       this.mockMvc.perform(get("/index").accept(MediaType.TEXT_HTML))
               .andExpect(status().isOk())
               .andExpect(content().string(containsString("Hello Word!")));
    }
}
