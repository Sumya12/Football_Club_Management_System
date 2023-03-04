package com.pro.soccer.repo;

import org.aspectj.weaver.patterns.ConcreteCflowPointcut.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlotRepo extends JpaRepository<Slot, Integer>{

}
