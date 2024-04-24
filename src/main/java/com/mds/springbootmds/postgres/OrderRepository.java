package com.mds.springbootmds.postgres;

import com.mds.springbootmds.kela.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {}
