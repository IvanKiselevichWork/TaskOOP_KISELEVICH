package by.kiselevich.task1.specification.toy;

import by.kiselevich.task1.entity.toy.Toy;
import by.kiselevich.task1.repository.Repository;

import java.util.ArrayList;
import java.util.List;

public class GetToyById implements ToySpecification {

    private int id;

    public GetToyById(int id) {
        this.id = id;
    }

    @Override
    public List<Toy> query(Repository<Toy> repository) {
        List<Toy> result = new ArrayList<>();
        List<Toy> toyList = repository.getAll();
        for (Toy toy : toyList) {
            if (toy.getId() == id) {
                result.add(toy);
                break;
            }
        }
        return result;
    }
}
