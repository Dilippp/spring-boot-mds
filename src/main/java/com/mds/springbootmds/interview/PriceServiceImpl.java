package com.mds.springbootmds.interview;

import com.mds.springbootmds.model.Product;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceServiceImpl implements PriceService {

  @Autowired private ProductRepository productRepository;

  @Override
  public double getProductPrice(List<Long> itemIdList) {
    // fetching all items from db
    List<Product> products = productRepository.findByIdList(itemIdList);
    double allPrice = products.stream().map(Product::getPrice).reduce(0d, Double::sum);
    LocalDateTime now = LocalDateTime.now();
    LocalDateTime nine_am_every_day = LocalDateTime.of(now.toLocalDate(), LocalTime.of(8, 59, 59));
    LocalDateTime five_pm_every_day = LocalDateTime.of(now.toLocalDate(), LocalTime.of(16, 59, 59));

    if ((now.equals(nine_am_every_day) || now.isAfter(nine_am_every_day))
        || (now.equals(five_pm_every_day) || now.isBefore(five_pm_every_day))) {
      return (allPrice - (allPrice * 30 / 100));
    } else if (UserMemberShipUtil.isAMember(new User())) {
      return (allPrice - (allPrice * 10 / 100));
    } else {
      return (allPrice - (allPrice * 10 / 100));
    }
  }
}
