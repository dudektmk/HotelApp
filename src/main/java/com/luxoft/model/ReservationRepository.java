package com.luxoft.model;

/**
 * Created by Dudi on 2015-02-11.
 */

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {
}
