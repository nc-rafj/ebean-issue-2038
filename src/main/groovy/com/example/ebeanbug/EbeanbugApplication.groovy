package com.example.ebeanbug;

import com.example.ebeanbug.model.Bar
import com.example.ebeanbug.model.Baz;
import com.example.ebeanbug.model.Foo

import io.ebean.DB;
import io.ebean.Database;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class EbeanbugApplication {

	public static void main(String[] args) {
		SpringApplication.run(EbeanbugApplication.class, args)

		Database server = DB.getDefault()

		Bar bar = new Bar()
		List<Foo> fooList = []
		fooList.add(createNewFooWithBar(bar))

		bar.setFooList(fooList)

		server.save(bar)

		Foo fooFromDb = server
				.find(Foo.class)
				.where()
				.eq("id", bar.fooList[0].id)
				.findOne()

		// This works
		List<Foo> foosList = fooFromDb.bar.fooList

		Baz bazFromDb = server
				.find(Baz.class)
				.where()
				.eq("id", bar.fooList[0].bazList[0].id)
				.findOne()

		// This does not work and gives the exception
		List<Foo> foosList1 = bazFromDb.foo.bar.fooList
	}

	private static Foo createNewFooWithBar(Bar bar) {
		Foo foo = new Foo()
		foo.setBar(bar)
		Baz baz = new Baz()
		baz.foo = foo
		foo.bazList.add(baz)
		return foo
	}

}
