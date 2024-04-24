package com.mds.springbootmds.interview;

import java.util.List;

public interface PriceService {
  double getProductPrice(List<Long> itemIdList);
}
