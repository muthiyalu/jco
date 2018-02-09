package org.jco.applications.domain.user;



import lombok.Data;
import org.jco.applications.domain.core.AbstractDomainObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.jco.applications.domain.core.AbstractDomainObject;


@Document(collection = "User12T")
@Data
public class User12T extends AbstractDomainObject {


    @Id
    private String id = null;

    private String email;

    private String userName;



}

