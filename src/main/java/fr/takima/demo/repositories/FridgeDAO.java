package fr.takima.demo.repositories;

import fr.takima.demo.models.MyFridge;
import fr.takima.demo.models.MyList;
import fr.takima.demo.models.ProductFridge;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FridgeDAO extends CrudRepository<MyFridge, Long> {
    MyFridge findMyFridgeByFridgeList(MyList fridgeList);
    MyFridge findMyFridgeByReference(String reference);
}
