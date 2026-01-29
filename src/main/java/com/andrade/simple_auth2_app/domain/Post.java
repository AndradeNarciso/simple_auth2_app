package com.andrade.simple_auth2_app.domain;

import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "post_user")
@Builder
@Getter 
@Setter 
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long postId;

    @Column(name = "post_from")
    @ManyToOne
    private User ownerPost;

    private String content;

    @Column(name = "created_at")
    @CreationTimestamp
    private Instant dataCreationPost;

}
