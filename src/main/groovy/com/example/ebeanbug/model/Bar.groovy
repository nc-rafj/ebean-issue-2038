package com.example.ebeanbug.model

import javax.persistence.*

@Entity
@Table(name = "bar")
public class Bar {
    @Id
    @GeneratedValue
    Long id

    @OneToMany(mappedBy = "bar", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Foo> fooList = []
}
