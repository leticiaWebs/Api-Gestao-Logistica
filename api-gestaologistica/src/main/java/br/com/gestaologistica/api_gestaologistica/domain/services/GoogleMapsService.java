package br.com.gestaologistica.api_gestaologistica.domain.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "googleMapsClient", url = "https://maps.googleapis.com/maps/api")
public interface GoogleMapsService {

    @GetMapping("/distancematrix/json")
    String calcularDistancia(@RequestParam("origins") String origem,
                             @RequestParam("destinations") String destino,
                             @RequestParam("key") String apiKey);

}
