package com.mds.springbootmds.interview;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class PriceController {

  @Autowired private PriceService priceService;

  @GetMapping(value = "/products")
  public double getProductPrice(@RequestParam(value = "itemIdList") List<Long> itemIdList) {
    return priceService.getProductPrice(itemIdList);
  }
}
