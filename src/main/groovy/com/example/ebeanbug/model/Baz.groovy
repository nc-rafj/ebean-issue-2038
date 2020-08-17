package com.example.ebeanbug.model

import javax.persistence.*

@Entity
@Table(name = "baz")
public class Baz {
    @Id
    @GeneratedValue
    Long id

    @JoinColumn(name = "fooId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    Foo foo
}
