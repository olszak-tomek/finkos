package pl.sda.final_project.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import pl.sda.final_project.dto.ProductDto;

@RestController
@RequestMapping("/rest")
public class TestRestController {
    @Autowired
    private RestTemplate restTemplate;



    @GetMapping("/test")
    public TestObject showTheMagic(TestObject testObject) {
        return testObject;
    }

    @PostMapping("/test")
    public TestObject showTheMagic2(@RequestBody TestObject testObject) {
        return testObject;
    }

    @GetMapping("/product")
    public void getProducts(){
        restTemplate.exchange("http://localhost:8080/rest/test", HttpMethod.POST, new HttpEntity<>(new TestObject()), TestObject.class);
    }

}
