package com.debug.boot.middleware.server.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BaseDto implements Serializable {
    private Integer id;
    private String content;

    /*public BaseDto() {
    }

    public BaseDto(Integer id, String content) {
        this.id = id;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "BaseDto{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }*/
}
