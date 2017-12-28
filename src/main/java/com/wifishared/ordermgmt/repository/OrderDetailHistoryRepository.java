package com.wifishared.ordermgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wifishared.ordermgmt.domain.OrderDetailHistory;

@Repository
public interface OrderDetailHistoryRepository extends JpaRepository<OrderDetailHistory, String> {



}
