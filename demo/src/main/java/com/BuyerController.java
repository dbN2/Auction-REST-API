package com;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
public class BuyerController {

private final BuyerRepository repository;
BuyerController(BuyerRepository repository){
    this.repository = repository;
}

@GetMapping("/buyers")
    List<Buyer> all() {
    return repository.findAll();
}

@PostMapping("/buyers")
    Buyer newBuyer(@RequestBody Buyer newBuyer) {
    return repository.save(newBuyer);
}

@GetMapping("/buyers/{id}")
    EntityModel<Buyer> one(@PathVariable Long id){
    Buyer buyer = repository.findById(id)
            .orElseThrow(() -> new BuyerNotFoundException(id));
    return EntityModel.of(buyer,
            linkTo(methodOn(BuyerController.class).one(id)).withSelfRel(),
            linkTo(methodOn(BuyerController.class).all()).withRel("buyers"));
}
@PutMapping("/buyers/{id}")
    Buyer replaceBuyer(@RequestBody Buyer newBuyer, @PathVariable Long id) {
    return repository.findById(id)
            .map(buyer -> {
                buyer.setName(newBuyer.getName());
                return repository.save(buyer);
            })
            .orElseGet(() -> {
                Buyer buyer = new Buyer(id);
                return repository.save(buyer);
            });
}

@DeleteMapping("/buyers/{id}")
    void deleteBuyer(@PathVariable Long id){
    repository.deleteById(id);
}

}
