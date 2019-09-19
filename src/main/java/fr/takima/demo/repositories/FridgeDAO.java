package fr.takima.demo.repositories;

import fr.takima.demo.models.MyFridge;
import fr.takima.demo.models.MyList;
import org.springframework.data.repository.CrudRepository;

public interface FridgeDAO extends CrudRepository<MyFridge, Long> {
    MyFridge findMyFridgeByFridgeList(MyList fridgeList);
    MyFridge findMyFridgeByReference(String reference);
}
