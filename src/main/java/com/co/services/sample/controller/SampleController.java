package com.co.services.sample.controller;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    MathContext m = new MathContext(5);
    
    private BigDecimal initValue(Double val) {
        return new BigDecimal(val).round(m);
    }
    
    @GetMapping("/")
    public String sampleApi() {
        Map<Integer, ArrayList<BigDecimal>> sqlResults = new HashMap<Integer, ArrayList<BigDecimal>>();

        sqlResults.put(1,  new ArrayList<BigDecimal>(Arrays.asList(
            initValue(1.0),
            initValue(2.0),
            initValue(3.0),
            initValue(4.0),
            initValue(4.0),
            initValue(3.0),
            initValue(6.0),
            initValue(8.0),
            initValue(9.0),
            initValue(20.0)
        )));

        sqlResults.put(2,  new ArrayList<BigDecimal>(Arrays.asList(
            initValue(5.0),
            initValue(3.0),
            initValue(5.0),
            initValue(9.0),
            initValue(3.0),
            initValue(0.25),
            initValue(4.0),
            initValue(8.5),
            initValue(9.7),
            initValue(2.2)
        )));

        sqlResults.put(3,  new ArrayList<BigDecimal>(Arrays.asList(
            initValue(5.1),
            initValue(3.2),
            initValue(5.3),
            initValue(9.45),
            initValue(3.6),
            initValue(0.45),
            initValue(4.3),
            initValue(2.5),
            initValue(1.7),
            initValue(1.2)
        )));

        // map each period year to the sum of its list of amounts
        Map<Integer, BigDecimal> totals = new HashMap<>();

        // sum the values
        for(Integer k : sqlResults.keySet()) {
            BigDecimal sum = BigDecimal.ZERO;
            for(BigDecimal d : sqlResults.get(k)) {
                sum = sum.add(d);
            }
            totals.put(k, sum.round(m));
        }
        String output = "";
        String lineBreak = "<br>";
        output += "Sample Recalc 7.3" + lineBreak + lineBreak;
        output += "Input" + lineBreak;

        for(Integer k : totals.keySet()) {
            output += "Period Id = " + k.toString() + lineBreak;
            for(BigDecimal d : sqlResults.get(k)) {
                output += "Esn Revenue = " + d.toString() + lineBreak;
            }
        }

        output += lineBreak + "Output" + lineBreak;

        for(Integer k : totals.keySet()) {
            output += "Period Id = " + k.toString();
            output += ", Esn Summed Revenue = " + totals.get(k).toString() + lineBreak;
        }

        return output;
    }
    
}
