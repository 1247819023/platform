package com.nf147.platform.web;

import com.nf147.platform.entity.GeEnterpriseNature;
import com.nf147.platform.entity.GeEnterpriseScale;
import com.nf147.platform.service.GeEnterpriseScaleService;
import com.nf147.platform.util.response.Constants;
import com.nf147.platform.util.response.JSONResponse;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeEnterpriseScaleController {
    @Autowired
    private GeEnterpriseScaleService geEnterpriseScaleService;

    /**
     * 添加企业规模表数据
     * @author 梁光健
     * @// TODO: 2019/02/26
     * */
    @PostMapping("/nature/insert")
    public JSONResponse insertScale(@RequestBody GeEnterpriseScale geEnterpriseScale) {
        try {
            if (geEnterpriseScale != null) {
                int result = geEnterpriseScaleService.insert(geEnterpriseScale);
                if (result > 0) {
                    return  JSONResponse.OK(Constants.SUCCESS_200,result);
                }
            }
        } catch (MyBatisSystemException ex) {
            return JSONResponse.ERROR(Constants.ERROR_500,ex.getMessage());
        } catch (Exception ex) {
            return JSONResponse.ERROR(Constants.ERROR_408,ex.getMessage());
        }
        return null;
    }
}
