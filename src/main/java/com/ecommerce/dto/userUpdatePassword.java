package com.ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class userUpdatePassword
{
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String username;

    private String newPassword;

}
