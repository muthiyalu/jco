package org.jco.applications.domain.user;

import org.springframework.data.mongodb.repository.MongoRepository;



public interface User12TRepo  extends  MongoRepository<User12T, Long> {

    public User12T findByEmail( String email);


}
