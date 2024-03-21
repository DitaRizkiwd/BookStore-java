package id.fazzbcas.bookstore.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //untuk membaca kelas sebagai controller api, anotasi kelas
public class GreetingController {
    @GetMapping("/hello") //anotasi method, get mapping tidak boleh sama, sama dengan router
    //http://localhost:8080/hello?name=Dita
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
      return String.format("Hello %s!", name);
    }

    @GetMapping("/halo/{idUser}")
    //localhost:8080/halo/1234567
    //req.params
    public String halo(@PathVariable(value = "idUser")String id){
        return "ID adalah :"+id;
    }

    @PostMapping("/user")
    //req.body
    public Object addUser(@RequestBody Object data){
        return data;
    }
}
