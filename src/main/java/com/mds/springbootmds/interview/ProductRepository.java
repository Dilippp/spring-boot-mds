package com.mds.springbootmds.interview;

import com.mds.springbootmds.model.Product;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

  @Query(value = "select * from products where id in (:itemIdList)", nativeQuery = true)
  List<Product> findByIdList(@Param(value = "itemIdList") List<Long> itemIdList);
}
