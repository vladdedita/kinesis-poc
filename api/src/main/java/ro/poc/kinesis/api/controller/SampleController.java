package ro.poc.kinesis.api.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.poc.kinesis.api.dto.AverageTypeValueDTO;
import ro.poc.kinesis.api.service.SampleServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class SampleController {

    private final SampleServiceImpl sampleService;

    @GetMapping("/average")
    public List<AverageTypeValueDTO> getAverage() {
        return sampleService.getAverage();
    }

    @GetMapping("/{eventType}/average")
    public AverageTypeValueDTO getTypeAverage(@PathVariable String eventType, Long from,  Long to) {
        return sampleService.getTypeAverage(eventType, from, to);
    }
}
