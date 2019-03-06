package com.cloudmall.item.web;

import com.cloudmall.common.vo.PageResult;
import com.cloudmall.item.pojo.Brand;
import com.cloudmall.item.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    /**
     * 分页查询品牌
     * @param page
     * @param rows
     * @param sortBy
     * @param desc
     * @param key
     * @return
     */
    @GetMapping("page")
    public ResponseEntity<PageResult<Brand>> queryBrandByPage(
            @RequestParam(value="page",defaultValue = "1") Integer page,
            @RequestParam(value="rows",defaultValue = "5") Integer rows,
            @RequestParam(value = "sortBy",required = false) String sortBy,
            @RequestParam(value="desc",defaultValue = "false") Boolean desc,
            @RequestParam(value = "key" , required = false) String key
    ){
       PageResult<Brand> result=brandService.queryBrandByPage(page,rows,sortBy,desc,key);
       return ResponseEntity.ok(result);
    }

    /**
     * 新增品牌
     * @param brand
     * @param categories
     * @return
     */
    @PostMapping
    //传递过来的商品分类cids是多个
    public ResponseEntity<Void> saveBrand(Brand brand,@RequestParam("categories") List<Long> categories){
        brandService.saveBrand(brand,categories);
        //201新增成功，有返回提body没有返回提body
        return ResponseEntity.status(HttpStatus.CREATED ).build();
    }
}