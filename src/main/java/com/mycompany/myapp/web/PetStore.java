package com.mycompany.myapp.web;

import org.springframework.web.bind.annotation.*;
import  com.mycompany.myapp.web.api.PetApi;
import com.mycompany.myapp.web.api.model.Pet;
import  com.mycompany.myapp.web.api.StoreApi;
import  com.mycompany.myapp.web.api.UserApi;
import org.springframework.http.HttpStatus;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.http.ResponseEntity;
import java.util.*;
import java.util.stream.*;

@RestController
@RequestMapping("/api/petstore")
public class PetStore implements PetApi, StoreApi, UserApi {


@Override
public ResponseEntity<List<Pet>> findPetsByStatus(@RequestParam List<String> status) {
  return new ResponseEntity<>(
      status.stream()
          .distinct()
          .map(Pet.StatusEnum::fromValue)
          .map(statusEnum -> new Pet().id(RandomUtils.nextLong()).status(statusEnum))
          .collect(Collectors.toList()),
      HttpStatus.OK);
}

}
