package com.transion.eksath.blogic.dispatch.repository;

import com.transion.eksath.blogic.dispatch.model.Dispatch;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DispatchRepository extends CrudRepository<Dispatch, String> {
    public List<Dispatch> findByUserId(String user);
    public Dispatch findByUserIdAndDispatchOrder(String userId, String dispatchOrderId);
}
