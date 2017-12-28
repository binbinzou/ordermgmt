package com.wifishared.ordermgmt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wifishared.ordermgmt.domain.OrderDetail;
import com.wifishared.ordermgmt.domain.OrderMerge;
import com.wifishared.ordermgmt.domain.OrderMergeHistory;

@Repository
public interface OrderMergeHistoryRepository extends JpaRepository<OrderMergeHistory, String> {

	List<OrderMergeHistory> findByCreator(String userId);

}
