package com.zpay.zpay.services.impl;

import com.zpay.zpay.domain.Section;
import com.zpay.zpay.repository.SectionRepo;
import com.zpay.zpay.services.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SectionServiceImpl implements SectionService {
    @Autowired
    private SectionRepo sectionRepo;

    @Override
    public Section findById(Long id) {
        return sectionRepo.findById(id).orElseThrow(() -> new UsernameNotFoundException("Section Not Found"));
    }
}
