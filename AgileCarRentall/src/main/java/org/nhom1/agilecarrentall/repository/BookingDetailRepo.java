package org.nhom1.agilecarrentall.repository;

import org.nhom1.agilecarrentall.entity.BookingDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingDetailRepo extends JpaRepository<BookingDetail, Integer> {
}
