package com.genieworks.ginterface.product.controller;

import com.genieworks.ginterface.product.config.ProductTestConfig;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.restdocs.operation.preprocess.Preprocessors;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
//@SpringBootTest(classes = ProductTestConfig.class)
@SpringBootTest
public class HelloControllerTest {

    @Rule
    public JUnitRestDocumentation jUnitRestDocumentation = new JUnitRestDocumentation();

    @Autowired
    private WebApplicationContext context;

    protected MockMvc mockMvc;

    @Before
    public void setup() {
        RestDocumentationResultHandler restDocumentationResultHandler = MockMvcRestDocumentation.document("{class-name}/{method-name}", Preprocessors.preprocessResponse(Preprocessors.prettyPrint()));
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
                .apply(MockMvcRestDocumentation.documentationConfiguration(this.jUnitRestDocumentation).uris().withHost("localhost"))
                .alwaysDo(restDocumentationResultHandler)
                .build();
    }

    @Test
    public void testProductDetail() throws Exception {
        this.mockMvc.perform(get("/hello/{name}", "PRODUCT_TEST").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


}
