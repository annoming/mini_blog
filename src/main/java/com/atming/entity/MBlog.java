package com.atming.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2020-10-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MBlog implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long userId;

    private String title;

    private String description;

    private String content;

    private LocalDateTime created;

    private Integer status;


}
