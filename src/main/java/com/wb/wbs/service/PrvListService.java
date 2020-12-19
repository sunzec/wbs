package com.wb.wbs.service;

import com.wb.wbs.dao.ClPrvListRepository;
import com.wb.wbs.entity.ClPrvList;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.List;

@Service
public class PrvListService {

    public ClPrvListRepository clPrvListRepository;

    public ClPrvList saveOne(ClPrvList clPrvList){

        return clPrvListRepository.save(clPrvList);

    }

    public ClPrvList findOne(Long id) {

        return clPrvListRepository.findById(id).orElse(null);
    }

    public void rmOne(ClPrvList clPrvList) {
          clPrvListRepository.delete(clPrvList);
    }

    public List<ClPrvList> list() {
        return clPrvListRepository.findAll();
    }

    public List<Predicate> find(Specification specification) {
        return clPrvListRepository.findAll(specification);
    }
}
