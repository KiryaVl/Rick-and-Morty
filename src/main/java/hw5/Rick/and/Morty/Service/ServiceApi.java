package hw5.Rick.and.Morty.Service;

import hw5.Rick.and.Morty.Domain.Character;
import hw5.Rick.and.Morty.Domain.Result;

import java.util.List;

public interface ServiceApi {
    List<Result> getAllCharacters();
    List<Result> getRandomCharacters(int count);

    Result getCharacterById(Integer id);
}

