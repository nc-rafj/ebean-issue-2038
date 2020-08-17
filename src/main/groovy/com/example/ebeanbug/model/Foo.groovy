package com.example.ebeanbug.model;

import javax.persistence.*;

@Entity
@Table(name = "foo")
public class Foo {
    @Id
    @GeneratedValue
    Long id
    
    @JoinColumn(name = "barId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    Bar bar

    @OneToMany(mappedBy = "foo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Baz> bazList = []
}
