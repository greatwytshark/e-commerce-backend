package com.zpay.zpay.controllers;

import com.zpay.zpay.domain.Section;
import com.zpay.zpay.repository.ProductRepo;
import com.zpay.zpay.repository.SectionRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/section")
public class SectionController {

    @Autowired
    private SectionRepo secRepo;
    @Autowired
    private ProductRepo prodRepo;


    record Category(String name, String imgUrl){}

    @PostMapping("/add")
    public void addSection(@RequestBody Category cat){
        Section sec = new Section();
        sec.setName(cat.name);
        sec.setImgUrl(cat.imgUrl);
        secRepo.save(sec);
    }

    @PutMapping("/update/{sectionId}")
    public void updateSection(@PathVariable("sectionId") Long id, @RequestBody Category cat){
        Section sec = new Section();
        sec.setId(id);
        sec.setName(cat.name);
        sec.setImgUrl(cat.imgUrl);
        secRepo.save(sec);
    }

    @DeleteMapping("/delete/{sectionId}")
    public void deleteSection(@PathVariable("sectionId") Long id){
        secRepo.deleteById(id);
    }

    @Transactional
    @DeleteMapping("/products/delete/{sectionId}")
    public void deleteSectionProducts(@PathVariable("sectionId") Long sectionId){
        prodRepo.deleteAllBySection_Id(sectionId);
    }
}
