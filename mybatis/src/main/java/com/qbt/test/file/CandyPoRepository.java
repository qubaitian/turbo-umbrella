package com.qbt.test.file;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qbt.test.mock.SimpleReflect;
import com.yhhl.ebo.commom.persistence.Page;
import com.yhhl.ebo.commom.persistence.PageRequest;
import com.yhhl.ebo.commom.persistence.Repository;
import com.yhhl.ebo.commom.persistence.Specification;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@org.springframework.stereotype.Repository
public class CandyPoRepository implements Repository<Candy> {

    @Autowired
    private CandyPoDao candyPoDao;

    @Override
    public void add(Candy candy) {
        CandyPo candyPo = CandyPoUtil.toPo(candy);
        candyPoDao.add(candyPo);
        SimpleReflect.setter(candy, "id", candyPo.getId());
    }

    @Override
    public void update(Candy candy) {
        CandyPo candyPo = CandyPoUtil.toPo(candy);
        candyPoDao.update(candyPo);
    }

    @Override
    public void delete(Candy candy) {
        CandyPo candyPo = CandyPoUtil.toPo(candy);
        candyPoDao.delete(candyPo);
    }

    @Override
    public Candy findById(Long id) {
        CandyPo candyPo = candyPoDao.findById(id);
        Candy candy = CandyPoUtil.toEntity(candyPo);
        return candy;
    }

    @Override
    public List<Candy> findAll(Specification specification) {
        List<CandyPo> list = candyPoDao.findAll((CandySpecification) specification);
        return CandyPoUtil.toEntityList(list);
    }

    @Override
    public Page<Candy> findAll(Specification specification, PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.pageNumber(), pageRequest.pageSize());
        List<CandyPo> list = candyPoDao.findAll((CandySpecification) specification);
        PageInfo<CandyPo> pageInfo = new PageInfo<>(list);
        long total = pageInfo.getTotal();
        return Page.of(total, CandyPoUtil.toEntityList(list));
    }

}
