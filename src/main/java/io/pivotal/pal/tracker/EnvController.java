package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController()


public class EnvController {

   String port;
   String memoryLimit;
   String cfInstance;
   String address;
   //Test comment

    public EnvController(
                @Value ("${PORT:NOT SET}") String port,
                @Value("${MEMORY_LIMIT:NOT SET}") String memoryLimit,
                @Value("${CF_INSTANCE_INDEX:NOT SET}") String cfInstance,
                @Value("${CF_INSTANCE_ADDR:NOT SET}") String address) {

        this.port = port;
        this.memoryLimit = memoryLimit;
        this.cfInstance = cfInstance;
        this.address = address;
    }

    @GetMapping("/env")
    public Map<String, String> getEnv(){
        Map env = new HashMap<String, String>();
        env.put("PORT", port);
        env.put("MEMORY_LIMIT", memoryLimit);
        env.put("CF_INSTANCE_INDEX", cfInstance);
        env.put("CF_INSTANCE_ADDR", address);
        return env;
    }



}
