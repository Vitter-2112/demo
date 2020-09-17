package com.example.demo;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepo extends CrudRepository<Item, String> {

    List<Item> findName(String name);

    Item findById(long id);


}
