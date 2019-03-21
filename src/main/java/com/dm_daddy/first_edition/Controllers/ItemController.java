package com.dm_daddy.first_edition.Controllers;

import com.dm_daddy.first_edition.Model.Items;
import com.dm_daddy.first_edition.Model.RefCode;
import com.dm_daddy.first_edition.Repositories.ItemRepository;
import com.dm_daddy.first_edition.Repositories.RefCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RepositoryRestController
@CrossOrigin
public class ItemController {
    @Autowired
    private ItemRepository repo;

    @Autowired
    private RefCodeRepository refRepo;


    //----- Load All Items --------
    //-----------------------------
    @GetMapping("/items/all")
    public Page<Items> getAllItems(@RequestParam int page, @RequestParam int size){
        Page<Items> itemList = (Page<Items>) repo.getAllItems(PageRequest.of(page, size));
        return itemList;
    }

    //--- Load Item List -----
    //------------------------
    @GetMapping("/items/list")
    public List<Items> getAllItemList(){
        List<Items> itemList = (List<Items>) repo.findAll();
        return itemList;
    }

    //---- Load Item Type -------
    //---------------------------
    @GetMapping("/items/type")
    public List<RefCode>  getItemType(){
        List<RefCode> itemTypes = (List<RefCode>) refRepo.findByParentId((long) 9);
        return itemTypes;
    }

    //----- Load Rarity ---------
    //---------------------------
    @GetMapping("/items/rarity")
    public List<RefCode> getRarity(){
        List<RefCode> rarity = refRepo.findByParentId((long) 1);
        return rarity;
    }

    //---- Load Attunement -----
    //--------------------------
    @GetMapping("/items/attunement")
    public List<RefCode> getAttunment(){
        List<RefCode> attunement = refRepo.findByParentId((long) 19);
        return attunement;
    }

    //---- Load Armor Type ------
    //---------------------------
    @GetMapping("/items/armorType")
    public List<RefCode> getArmorType(){
        List<RefCode> armorType = refRepo.findByParentId((long) 22);
        return armorType;
    }

    //----- Load Weapon Type ---
    //--------------------------
    @GetMapping("/items/weaponType")
    public List<RefCode> getWeaponType(){
        List<RefCode> weaponType = refRepo.findByParentId((long) 37);
        return weaponType;
    }

    //---- Create an Item -------
    //---------------------------
    @RequestMapping(value="/items/create")
    @PostMapping
    public Items createItem(@RequestBody Items item){
        Items createdItem = repo.save(item);
        return createdItem;
    }

    //---- Delete an Item -----
    //-------------------------
    @RequestMapping(value="/items/{id}", method = RequestMethod.DELETE)
    @Transactional
    public List<Items> deleteItem(@PathVariable Long id){
        repo.deleteById(id);
        List<Items> itemList = (List<Items>) repo.findAll();
        return itemList;
    }


//    ResponseEntity<List<Items>> getAllItems(){
//        List<Items> itemList = (List<Items>) repo.findAll();
//        return ResponseEntity.ok(itemList);
//    }
}
