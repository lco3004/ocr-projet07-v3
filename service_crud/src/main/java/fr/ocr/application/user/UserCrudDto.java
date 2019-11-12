package fr.ocr.application.user;

import lombok.Value;

import java.io.Serializable;


@Value
public class UserCrudDto implements Serializable {
    static final long serialVersionUID = 5453281303625368221L;

    private String username;
    private String email;

}
