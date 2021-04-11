package ro.poc.kinesis.api.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.poc.kinesis.api.dto.AverageTypeValueDTO;
import ro.poc.kinesis.api.service.SampleServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class SampleController {

    private final SampleServiceImpl sampleService;

    @GetMapping("/average")
    public List<AverageTypeValueDTO> getTypeAverage() {
        return sampleService.getTypeAverage();
    }
}
